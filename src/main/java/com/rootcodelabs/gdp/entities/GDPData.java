package com.rootcodelabs.gdp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author - Nipuna Kumaranathunga
 */
@Entity
public class GDPData {
    @Id
    private Long id;
    private String countryName;
    private String alpha3Code;
    private Integer year;
    private Double value;

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

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
