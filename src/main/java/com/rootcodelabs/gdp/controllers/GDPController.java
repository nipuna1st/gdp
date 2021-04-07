package com.rootcodelabs.gdp.controllers;

import com.rootcodelabs.gdp.exceptions.NotFoundException;
import com.rootcodelabs.gdp.responses.ApiResponse;
import com.rootcodelabs.gdp.services.GDPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author - Nipuna Kumaranathunga
 */
@RestController
@RequestMapping("/gdp")
public class GDPController {
    private GDPService gdpService;

    @Autowired
    public GDPController(GDPService gdpService) {
        this.gdpService = gdpService;
    }

    @GetMapping("/{country_code}/{year}")
    public ApiResponse getGDPGrowthRate(@PathVariable("country_code") String countryCode, @PathVariable("year") Integer year){
        try {
            return new ApiResponse("SUCCESS",gdpService.getGDPGrowthRate(countryCode,year));
        } catch (Exception e){
            return new ApiResponse("FAILED",e.getMessage());
        }
    }
}
