package com.jasdhir.scheduling.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "MM/dd/yyyy HH:mm:ss");
/***
 * The @Scheduled annotation is used to trigger the scheduler for a specific time period.
 * Fixed Rate scheduler is used to execute the tasks at the specific time. 
 * It does not wait for the completion of previous task. The values should be in milliseconds.
 */
	 
	    @Scheduled(fixedRate = 5000)
	    public void performTask() {

	        System.out.println("Regular task performed at "
	                + dateFormat.format(new Date()));

	    }

/***
 * Fixed Delay scheduler is used to execute the tasks at a specific time. 
 * It should wait for the previous task completion. The values should be in milliseconds.
 */
	    @Scheduled(initialDelay = 1000, fixedRate = 10000)
	    public void performDelayedTask() {

	        System.err.println("Delayed Regular task performed at "
	                + dateFormat.format(new Date()));

	    }

	    @Scheduled(cron = "0 * * * * *")
	    public void performTaskUsingCron() {

	        System.err.println("Regular task performed using Cron at "
	                + dateFormat.format(new Date()));

	    }

}
