package org.example;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TennisCoach implements  Coach{

    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "Practice Backhand Volley ! ! ! ! ";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
