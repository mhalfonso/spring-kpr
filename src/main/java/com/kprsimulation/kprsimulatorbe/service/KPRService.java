package com.kprsimulation.kprsimulatorbe.service;

import com.kprsimulation.kprsimulatorbe.entity.KPRValues;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KPRService {

    private List<JSONObject> jsonObjectList;

    public List<JSONObject> getJsonObjectList() {
        return jsonObjectList;
    }

    public List<JSONObject> DisplayCalculatedResult(double harga, double dp, double bunga, int tenor) {
        KPRValues kprValues = new KPRValues(harga, dp, bunga, tenor);
        // private List<JSONObject> jsonObjectList = new ArrayList<>();
        jsonObjectList =  new ArrayList<>();

        kprValues.SetAllVariables();
        return kprValues.Calculate(jsonObjectList);
    }
















    public List<JSONObject> DisplayResult() {
        KPRValues kprValues = new KPRValues(750000000, 14, 10, 5);
        List<JSONObject> jsonObjectList = new ArrayList<>();

        kprValues.SetAllVariables();
        return kprValues.Calculate(jsonObjectList);
    }

}
