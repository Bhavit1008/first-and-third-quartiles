package com.pgworks.analytics.controller;

import com.pgworks.analytics.controller.request.ThirdQuartileRequest;
import com.pgworks.analytics.service.CalculateQuartileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalculateController {

    @Autowired
    CalculateQuartileServiceImpl calculateQuartileService;

    @GetMapping("/thirdQuartile")
    public Map<Object,Object> calculateThirdQuartile(@RequestBody ThirdQuartileRequest quartileRequest){
        Map<Object,Object> map = new HashMap<>();
        int Q1=0;
        int Q2=0;
        float median = 0;
        List<Integer> arr = new ArrayList<>();
        Map<Object,Object> quartileMap = new HashMap<>();
        if(quartileRequest!=null && quartileRequest.getArray().size()!=0){
            arr = quartileRequest.getArray();

            //sorting the given list in increasing order
            arr = calculateQuartileService.sortRequestArray(arr);
            median = calculateQuartileService.calculateMedian(arr);
            quartileMap =  calculateQuartileService.calculateFirstQuartile(arr);
        }
        map.put("sorted dataset",arr);
        map.put("median",median);
        map.put("quartile",quartileMap);
        return map;
    }

    @GetMapping("/fiveNoSummary")
    public Map<Object,Object> calculateTheFiveNoSummary(@RequestBody ThirdQuartileRequest quartileRequest){
        Map<Object,Object> map = new HashMap<>();
        int Q1=0;
        int Q2=0;
        float median = 0;
        int min = 0;
        int max = 0;
        List<Integer> arr = new ArrayList<>();
        Map<Object,Object> quartileMap = new HashMap<>();
        if(quartileRequest!=null && quartileRequest.getArray().size()!=0){
            arr = quartileRequest.getArray();

            //sorting the given list in increasing order
            arr = calculateQuartileService.sortRequestArray(arr);
            median = calculateQuartileService.calculateMedian(arr);
            quartileMap =  calculateQuartileService.calculateFirstQuartile(arr);
            min = arr.get(0);
            max = arr.get(arr.size()-1);
        }
        map.put("minimu",min);
        map.put("maximum",max);
        map.put("median",median);
        map.put("quartile",quartileMap);
        return map;
    }
}
