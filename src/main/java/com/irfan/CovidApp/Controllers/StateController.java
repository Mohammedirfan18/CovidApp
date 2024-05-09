package com.irfan.CovidApp.Controllers;

import com.irfan.CovidApp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data")
public class StateController {
    @Autowired
    CovidDataService covidDataService;
    //localhost:8080/covid-data/delhi
    @GetMapping("/{state}")
    public String getCovidCases(@PathVariable String state)
    {
        Long confirmedCases = covidDataService.getCovidData_State(state);
        if (confirmedCases == null) {
            return "No COVID-19 data found for state: " + state;
        }
        return "The total number of confirmed cases in " + state + " is " + confirmedCases;
    }
}
