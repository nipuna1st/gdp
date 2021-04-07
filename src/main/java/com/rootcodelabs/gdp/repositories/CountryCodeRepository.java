package com.rootcodelabs.gdp.repositories;

import com.rootcodelabs.gdp.entities.CountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author - Nipuna Kumaranathunga
 */
@Repository
public interface CountryCodeRepository extends JpaRepository<CountryCode, Integer> {
    @Query(value="SELECT c.alpha3Code FROM CountryCode c WHERE LOWER(c.alpha2Code)=:alpha2Code")
    public String getAlpha3CodeByAlpha2Code(@Param("alpha2Code") String alpha2Code);
}
