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

    @GetMapping("/avgMove")
    public String getAvgMove(){
        //stockService.getHistoricData("SPY");

        List<StockData> historicData = stockService.getHistoricData("SPY");
        //stockService.getAllObjWhenConIsTrue(historicData, 1.00);
        double twoDays = stockService.avgTwoDayMove(stockService.getAllObjWhenConIsTruePos(historicData, 1.00));
        double fiveDays = stockService.avgFiveDayMove(stockService.getAllObjWhenConIsTruePos(historicData, 1.00));
        double tenDays = stockService.avgTenDayMove(stockService.getAllObjWhenConIsTruePos(historicData, 1.00));

        stockService.settingAllAvgMoves(twoDays,fiveDays, tenDays);

        return stockService.getAllAvgMoves();
    }







    @GetMapping("/test")
    public double test(){
        List<StockData> historicData = stockService.getHistoricData("SPY");
        double twoDays = stockService.avgTwoDayMove(stockService.getAllObjWhenConIsTruePos(historicData, 1.00));
        stockService.getAverageMove().setAvgTwoDayMove(twoDays);
        return stockService.getAverageMove().getAvgTwoDayMove();
    }

    @GetMapping("/test2")
    public List<StockData> getAllOnePerIntraday(){
        return stockService.getAllObjWhenConIsTruePos(stockService.getHistoricData("SPY"), 1.00);
    }
//
//    @GetMapping("/test2")
//    public double getFieldFromAverageMove(){
//        stockService.settingAvgTwoDayMoveOnePer(stockService.avgTwoDayMoveOnePer(stockService.getHistoricData("SPY")));
//        return stockService.getAverageMove().getAvgTwoDayMoveOnePer();
//    }


}