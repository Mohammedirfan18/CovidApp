package com.irfan.CovidApp.Controllers;

import com.irfan.CovidApp.Service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid-data/{state}")
public class DistrictController {
    @Autowired
    CovidDataService covidDataService;
    @GetMapping("/{district}")
    public String getDistrictCovidData(@PathVariable String district,@PathVariable String state){
        Long ConfirmedCases = covidDataService.getCovidData_District(state,district);
        if(ConfirmedCases == 0)
        {
            return "No COVID-19 data found for District " + district + " try searching for state data: "+state ;
        }
        String Cases ="the total number of confirmed cases in "+district+"  is "+ConfirmedCases;
        return Cases;
    }
}

