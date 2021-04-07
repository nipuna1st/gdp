package com.rootcodelabs.gdp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author - Nipuna Kumaranathunga
 */
@Entity
public class CountryCode {
    @Id
    private Long id;
    private String countryName;
    private String alpha2Code;
    private String alpha3Code;
    private Integer numeric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public Integer getNumeric() {
        return numeric;
    }

    public void setNumeric(Integer numeric) {
        this.numeric = numeric;
    }
}
