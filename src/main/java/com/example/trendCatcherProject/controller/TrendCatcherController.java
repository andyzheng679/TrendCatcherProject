package com.example.trendCatcherProject.controller;

import com.example.trendCatcherProject.service.StockData;
import com.example.trendCatcherProject.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrendCatcherController {

    @Autowired
    private StockService stockService;

    @GetMapping("/")
    public List<StockData> getHistoricalData(){
        return stockService.getHistoricData("SPY");
    }

    @GetMapping("/move")
    public double getPercentageMove(){
        return stockService.getPercentageMove(505.41, 503.95);
    }
}
