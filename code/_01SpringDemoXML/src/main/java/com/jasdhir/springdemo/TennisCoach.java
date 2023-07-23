package com.jasdhir.springdemo;

public class TennisCoach implements Coach{

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Practice backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
