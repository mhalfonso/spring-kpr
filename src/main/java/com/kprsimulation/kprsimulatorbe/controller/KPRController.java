package com.kprsimulation.kprsimulatorbe.controller;

import com.kprsimulation.kprsimulatorbe.entity.CalculatedValues;
import com.kprsimulation.kprsimulatorbe.service.KPRService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class KPRController {

    @Autowired
    private KPRService kprService;
    CalculatedValues calculatedValues = new CalculatedValues();

    @GetMapping(value = "/result")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<JSONObject> DisplayData() {

        return kprService.DisplayResult();
    }

    @PostMapping(value = "/set", consumes = {"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public List<JSONObject> Calculate(double harga, double dp, double bunga, int tenor) {
        return kprService.DisplayCalculatedResult(harga, dp, bunga, tenor);
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "*")
    public List<JSONObject> GetData() {
        return kprService.getJsonObjectList();
    }












/*
    @PostMapping(value = "/multiplyparams", consumes = {"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:3000")
    public int MultiplyParams(int num1, int num2){
        calculatedValues.setA(num1);
        calculatedValues.setB(num2);

        System.out.println(calculatedValues.getA());
        System.out.println(calculatedValues.getB());

        return num1 * num2;
    }
*/






/*    @PostMapping(value = "/multiply", consumes = {"application/x-www-form-urlencoded"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public int Multiply(CalculatedValues values){
        return values.a * values.b;
    }*/
}

