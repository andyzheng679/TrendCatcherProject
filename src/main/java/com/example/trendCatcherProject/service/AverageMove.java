package com.example.trendCatcherProject.service;

import org.springframework.stereotype.Service;

@Service
public class AverageMove {
    private double avgTwoDayMove;
    private double avgFiveDayMove;
    private double avgTenDayMove;



    public AverageMove(){
        //
    }

    //getters, setters


    public double getAvgTwoDayMove() {
        return avgTwoDayMove;
    }

    public void setAvgTwoDayMove(double avgTwoDayMove) {
        this.avgTwoDayMove = avgTwoDayMove;
    }

    public double getAvgFiveDayMove() {
        return avgFiveDayMove;
    }

    public void setAvgFiveDayMove(double avgFiveDayMove) {
        this.avgFiveDayMove = avgFiveDayMove;
    }

    public double getAvgTenDayMove() {
        return avgTenDayMove;
    }

    public void setAvgTenDayMove(double avgTenDayMove) {
        this.avgTenDayMove = avgTenDayMove;
    }
}
