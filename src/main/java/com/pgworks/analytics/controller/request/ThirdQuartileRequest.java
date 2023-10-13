package com.pgworks.analytics.controller.request;

import java.util.ArrayList;
import java.util.List;

public class ThirdQuartileRequest {
    List<Integer> array = new ArrayList<>();

    public ThirdQuartileRequest() {
    }

    public ThirdQuartileRequest(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getArray() {
        return array;
    }

    public void setArray(List<Integer> array) {
        this.array = array;
    }
}
