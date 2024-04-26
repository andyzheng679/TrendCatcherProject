package com.example.trendCatcherProject.service;

import org.springframework.stereotype.Service;

@Service
public class AverageMove {

    //two day 1%, -1%
    private double avgTwoDayMoveOnePer;
    private double avgTwoDayMoveNegOnePer;
    //two day 2%, -2%
    private double avgTwoDayMoveTwoPer;
    private double avgTwoDayMoveNegTwoPer;
    //two day 3%, -3%
    private double avgTwoDayMoveThreePer;
    private double avgTwoDayMoveNegThreePer;
//-----
    //five day 1%, -1%
    private double avgFiveDayMoveOnePer;
    private double avgFiveDayMoveNegOnePer;
    //five day 2%, -2%
    private double avgFiveDayMoveTwoPer;
    private double avgFiveDayMoveNegTwoPer;
    //five day 3%, -3%
    private double avgFiveDayMoveThreePer;
    private double avgFiveDayMoveNegThreePer;
//-----
    //ten day 1%, -1%
    private double avgTenDayMoveOnePer;
    private double avgTenDayMoveNegOnePer;
    //ten day 2%, -2%
    private double avgTenDayMoveTwoPer;
    private double avgTenDayMoveNegTwoPer;
    //ten day 3%, -3%
    private double avgTenDayMoveThreePer;
    private double avgTenDayMoveNegThreePer;


    public AverageMove(){
        //
    }

    //getters, setters


    public double getAvgTwoDayMoveOnePer() {
        return avgTwoDayMoveOnePer;
    }

    public void setAvgTwoDayMoveOnePer(double avgTwoDayMoveOnePer) {
        this.avgTwoDayMoveOnePer = avgTwoDayMoveOnePer;
    }

    public double getAvgTwoDayMoveNegOnePer() {
        return avgTwoDayMoveNegOnePer;
    }

    public void setAvgTwoDayMoveNegOnePer(double avgTwoDayMoveNegOnePer) {
        this.avgTwoDayMoveNegOnePer = avgTwoDayMoveNegOnePer;
    }

    public double getAvgTwoDayMoveTwoPer() {
        return avgTwoDayMoveTwoPer;
    }

    public void setAvgTwoDayMoveTwoPer(double avgTwoDayMoveTwoPer) {
        this.avgTwoDayMoveTwoPer = avgTwoDayMoveTwoPer;
    }

    public double getAvgTwoDayMoveNegTwoPer() {
        return avgTwoDayMoveNegTwoPer;
    }

    public void setAvgTwoDayMoveNegTwoPer(double avgTwoDayMoveNegTwoPer) {
        this.avgTwoDayMoveNegTwoPer = avgTwoDayMoveNegTwoPer;
    }

    public double getAvgTwoDayMoveThreePer() {
        return avgTwoDayMoveThreePer;
    }

    public void setAvgTwoDayMoveThreePer(double avgTwoDayMoveThreePer) {
        this.avgTwoDayMoveThreePer = avgTwoDayMoveThreePer;
    }

    public double getAvgTwoDayMoveNegThreePer() {
        return avgTwoDayMoveNegThreePer;
    }

    public void setAvgTwoDayMoveNegThreePer(double avgTwoDayMoveNegThreePer) {
        this.avgTwoDayMoveNegThreePer = avgTwoDayMoveNegThreePer;
    }

    public double getAvgFiveDayMoveOnePer() {
        return avgFiveDayMoveOnePer;
    }

    public void setAvgFiveDayMoveOnePer(double avgFiveDayMoveOnePer) {
        this.avgFiveDayMoveOnePer = avgFiveDayMoveOnePer;
    }

    public double getAvgFiveDayMoveNegOnePer() {
        return avgFiveDayMoveNegOnePer;
    }

    public void setAvgFiveDayMoveNegOnePer(double avgFiveDayMoveNegOnePer) {
        this.avgFiveDayMoveNegOnePer = avgFiveDayMoveNegOnePer;
    }

    public double getAvgFiveDayMoveTwoPer() {
        return avgFiveDayMoveTwoPer;
    }

    public void setAvgFiveDayMoveTwoPer(double avgFiveDayMoveTwoPer) {
        this.avgFiveDayMoveTwoPer = avgFiveDayMoveTwoPer;
    }

    public double getAvgFiveDayMoveNegTwoPer() {
        return avgFiveDayMoveNegTwoPer;
    }

    public void setAvgFiveDayMoveNegTwoPer(double avgFiveDayMoveNegTwoPer) {
        this.avgFiveDayMoveNegTwoPer = avgFiveDayMoveNegTwoPer;
    }

    public double getAvgFiveDayMoveThreePer() {
        return avgFiveDayMoveThreePer;
    }

    public void setAvgFiveDayMoveThreePer(double avgFiveDayMoveThreePer) {
        this.avgFiveDayMoveThreePer = avgFiveDayMoveThreePer;
    }

    public double getAvgFiveDayMoveNegThreePer() {
        return avgFiveDayMoveNegThreePer;
    }

    public void setAvgFiveDayMoveNegThreePer(double avgFiveDayMoveNegThreePer) {
        this.avgFiveDayMoveNegThreePer = avgFiveDayMoveNegThreePer;
    }

    public double getAvgTenDayMoveOnePer() {
        return avgTenDayMoveOnePer;
    }

    public void setAvgTenDayMoveOnePer(double avgTenDayMoveOnePer) {
        this.avgTenDayMoveOnePer = avgTenDayMoveOnePer;
    }

    public double getAvgTenDayMoveNegOnePer() {
        return avgTenDayMoveNegOnePer;
    }

    public void setAvgTenDayMoveNegOnePer(double avgTenDayMoveNegOnePer) {
        this.avgTenDayMoveNegOnePer = avgTenDayMoveNegOnePer;
    }

    public double getAvgTenDayMoveTwoPer() {
        return avgTenDayMoveTwoPer;
    }

    public void setAvgTenDayMoveTwoPer(double avgTenDayMoveTwoPer) {
        this.avgTenDayMoveTwoPer = avgTenDayMoveTwoPer;
    }

    public double getAvgTenDayMoveNegTwoPer() {
        return avgTenDayMoveNegTwoPer;
    }

    public void setAvgTenDayMoveNegTwoPer(double avgTenDayMoveNegTwoPer) {
        this.avgTenDayMoveNegTwoPer = avgTenDayMoveNegTwoPer;
    }

    public double getAvgTenDayMoveThreePer() {
        return avgTenDayMoveThreePer;
    }

    public void setAvgTenDayMoveThreePer(double avgTenDayMoveThreePer) {
        this.avgTenDayMoveThreePer = avgTenDayMoveThreePer;
    }

    public double getAvgTenDayMoveNegThreePer() {
        return avgTenDayMoveNegThreePer;
    }

    public void setAvgTenDayMoveNegThreePer(double avgTenDayMoveNegThreePer) {
        this.avgTenDayMoveNegThreePer = avgTenDayMoveNegThreePer;
    }
}
