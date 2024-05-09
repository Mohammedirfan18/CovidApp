package com.irfan.CovidApp.Service;

import com.irfan.CovidApp.Utililty.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@Service
public class CovidDataService {
    @Autowired
    RestTemplate restTemplate;

    public long getCovidData_State(String state) {
        Map<String, Object> map = restTemplate.getForObject(util.COVID_DATA_API, Map.class);
        Map<String, Object> Statewise_Data = (Map<String, Object>) map.get(state);
        Map<String, Object> total_Data = (Map<String, Object>) Statewise_Data.get("total");
        long confirmCases = ((Number) total_Data.get("confirmed")).longValue();
        return confirmCases;
    }
    public long getCovidData_District(String state,String district) {
       Map<String, Object> map = restTemplate.getForObject(util.COVID_DATA_API, Map.class);
        Map<String, Object> Statewise_Data = (Map<String, Object>) map.get(state);
        Map<String, Object> State_total_Data = (Map<String, Object>) Statewise_Data.get("total");
        Map<String, Object> Districtwise_Data = (Map<String, Object>) Statewise_Data.get("districts");
        Map<String, Object> districtCases = (Map<String, Object>) Districtwise_Data.get(district);
        Map<String, Object> total_Data = (Map<String, Object>) districtCases.get("total");
        long confirmCases;
        if(total_Data.get("confirmed")==null)
        {
            return 0;
        }
        confirmCases = ((Number) total_Data.get("confirmed")).longValue();
        return confirmCases;

//      if(total_Data.get("confirmed")!=null)
////        {
////             confirmCases = ((Number) total_Data.get("confirmed")).longValue();
////        }else {
////            confirmCases = ((Number) State_total_Data.get("confirmed")).longValue();
////        }


    }

}
