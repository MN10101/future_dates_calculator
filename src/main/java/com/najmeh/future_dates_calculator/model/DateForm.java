package com.najmeh.future_dates_calculator.model;

public class DateForm {

    private String startingDate;
    private int futureDays;
    private int futureHours;
    private int futureMinutes;
    private String secondDate;

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public int getFutureDays() {
        return futureDays;
    }

    public void setFutureDays(int futureDays) {
        this.futureDays = futureDays;
    }

    public int getFutureHours() {
        return futureHours;
    }

    public void setFutureHours(int futureHours) {
        this.futureHours = futureHours;
    }

    public int getFutureMinutes() {
        return futureMinutes;
    }

    public void setFutureMinutes(int futureMinutes) {
        this.futureMinutes = futureMinutes;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }
}
