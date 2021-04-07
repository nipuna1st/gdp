package com.rootcodelabs.gdp.services;

import com.rootcodelabs.gdp.NotFoundException;
import com.rootcodelabs.gdp.entities.CountryCode;
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

    public String calculateGDPGrowthRate(Double initialValue, Double finalValue){
        Double rate = ((finalValue - initialValue) / initialValue)*100;
        return String.valueOf(rate).concat(" %");
    }

    public String getGDPGrowthRate(String countryCode, Integer year) throws NotFoundException {
        if(year<2007 || year>2016)
            throw new NotFoundException("YEAR_IS_OUT_OF_RANGE");

        if (countryCode.length()==3 || countryCode.length()==2){
            if (countryCode.length()==2)
                countryCode = countryCodeRepository.getAlpha3CodeByAlpha2Code(countryCode);
        }else {
            throw new NotFoundException("COUNTRY_CODE_NOT_FOUND");
        }

        Double finalValue = gdpDataRepository.getValueByYearAndAlpha3Code(year,countryCode);
        Double initialValue = gdpDataRepository.getValueByYearAndAlpha3Code(year-1,countryCode);

        if (finalValue==null)
            throw new NotFoundException("COUNTRY_CODE_NOT_FOUND");

        return calculateGDPGrowthRate(initialValue,finalValue);
    }
}
