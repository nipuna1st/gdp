package com.rootcodelabs.gdp.services;

import com.rootcodelabs.gdp.exceptions.NotFoundException;
import com.rootcodelabs.gdp.repositories.CountryCodeRepository;
import com.rootcodelabs.gdp.repositories.GDPDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author - Nipuna Kumaranathunga
 */
@Service
public class GDPService {
    private GDPDataRepository gdpDataRepository;
    private CountryCodeRepository countryCodeRepository;

    @Autowired
    public GDPService(GDPDataRepository gdpDataRepository, CountryCodeRepository countryCodeRepository) {
        this.gdpDataRepository = gdpDataRepository;
        this.countryCodeRepository = countryCodeRepository;
    }

    public String getGDPGrowthRate(String countryCode, Integer year) throws NotFoundException {
        /* validate date range */
        validateYear(year);
        if (countryCode.length()==2)
            countryCode = countryCodeRepository.getAlpha3CodeByAlpha2Code(countryCode.toLowerCase());
        /* validate for 2 digit code CountryCode table*/
        validateCountryCode(countryCode);

        Double finalValue = gdpDataRepository.getValueByYearAndAlpha3Code(year,countryCode.toLowerCase());
        Double initialValue = gdpDataRepository.getValueByYearAndAlpha3Code(year-1,countryCode.toLowerCase());
        /* validate for 3 digit code in GDPData table */
        validateCountryCode(finalValue);
        return calculateGDPGrowthRate(initialValue,finalValue);
    }

    public String calculateGDPGrowthRate(Double initialValue, Double finalValue){
        Double rate = ((finalValue - initialValue) / initialValue)*100;
        return String.valueOf(Math.round(rate*100.0)/100.0).concat(" %");
    }

    public void validateYear(Integer year) throws NotFoundException {
        if(year<2007 || year>2016)
            throw new NotFoundException("YEAR_IS_OUT_OF_RANGE");
    }

    public void validateCountryCode(Object finalValue) throws NotFoundException {
        if (finalValue==null)
            throw new NotFoundException("COUNTRY_CODE_NOT_FOUND");
    }
}
