package com.pgworks.analytics.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalculateQuartileServiceImpl {

    public List<Integer> sortRequestArray(List<Integer> arr){
        Collections.sort(arr);
        return arr;
    }

    public float calculateMedian(List<Integer> arr){
        int size = arr.size();
        float median = 0;
        if(size%2==0){
            //even number of elements in the dataset
            int pos1 = size/2;
            int pos2 = ((size/2) - 1);
            float sum = arr.get(pos1) + arr.get(pos2);
            median = sum/2f;
            return median;
        }
        else{
            median = arr.get(size/2);
        }
        return median;
    }

    public Map<Object,Object> calculateFirstQuartile(List<Integer> arr){
        float q1 = 0;
        float q2 = 0;
        int size = arr.size();
        List<Integer> lowerHalf = new ArrayList<>();
        List<Integer> upperHalf = new ArrayList<>();
        Map<Object,Object> map = new HashMap<>();
        arr = sortRequestArray(arr);
        List[] split = {};
        split = split(arr);
        System.out.println(split[0]);
        System.out.println(split[1]);
        q1 = calculateMedian(split[0]);
        q2 = calculateMedian(split[1]);
        map.put("Q1",q1);
        map.put("Q2",q2);
        return map;
    }

    public static List[] split(List<Integer> list)
    {

        list.remove(list.size()/2);
        // Setting value of midIndex using comparators
        int midIndex
                = ((list.size() / 2)
                - (((list.size() % 2) > 0) ? 0 : 1));

        // Creating object of List with reference to
        // ArrayList class Declaring object List<String>
        // type
        List<List<Integer> > lists = new ArrayList<>(
                list.stream()
                        .collect(Collectors.partitioningBy(
                                s -> list.indexOf(s) > midIndex))
                        .values());

        // Returning an array containing both lists
        return new List[] { lists.get(0), lists.get(1) };
    }
}
