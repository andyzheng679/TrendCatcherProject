package com.example.trendCatcherProject.service;

public class StockData {

    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double percentageMove;

    // Constructor
    public StockData(String date, double open, double high, double low, double close) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.percentageMove = calculatePercentageMove(open, close);
    }

    private double calculatePercentageMove(double start, double end) {
        double result =  ((end - start) / start) * 100;
        return Math.ceil(result * 100)/100;
    }

    // Getters and setters
    public double getPercentageMove() {
        return percentageMove;
    }

    public void setPercentageMove(double percentageMove) {
        this.percentageMove = percentageMove;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }
}
