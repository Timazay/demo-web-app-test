package com.example.demowebapp.quartz;

import org.apache.log4j.BasicConfigurator;
//import org.quartz.CronScheduleBuilder;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzScheduler {

    public static int TIME_INTERVAL = 10;

    private static Logger log = Logger.getLogger(CreateQuartzJob.class);
    private static final String NAME_OF_JOB = "Job1";
    private static final String NAME_OF_GROUP = "group1";
    private static final String NAME_OF_TRIGGER = "triggerStart";

    //create variable scheduler of type Scheduler
    private static Scheduler scheduler;

    //main() method starts with exception handling
    public static void jobOne() throws Exception {

        BasicConfigurator.configure();

        //show message to know about the main thread
        System.out.println(" The name of the QuartzScheduler main thread is: " + Thread.currentThread().getName());

        //initialize scheduler instance from Quartz
        scheduler = new StdSchedulerFactory().getScheduler();

        //start scheduler
        scheduler.start();

        //create scheduler trigger based on the time interval
        Trigger triggerNew =  createTrigger();

        //create scheduler trigger with a cron expression
        //Trigger triggerNew = createCronTrigger();

        //schedule trigger
        scheduleJob(triggerNew);

    }



    public static void stopJob() throws SchedulerException {
        if (scheduler != null && scheduler.isStarted()) {
            scheduler.shutdown(true);
        } else {
            log.warn("Can't stop scheduler");
        }
    }


    //create scheduleJob() method to schedule a job
    private static void scheduleJob(Trigger triggerNew) throws Exception {

        //create an instance of the JoDetails to connect Quartz job to the CreateQuartzJob
        JobDetail jobInstance = JobBuilder.newJob(CreateQuartzJob.class).withIdentity(NAME_OF_JOB, NAME_OF_GROUP).build();

        //invoke scheduleJob method to connect the Quartz scheduler to the jobInstance and the triggerNew
        scheduler.scheduleJob(jobInstance, triggerNew);

    }

    //create createTrigger() method that returns a trigger based on the time interval
    /*private static Trigger createCronTrigger() {

        //create cron expression
        String CRON_EXPRESSION = "0 * * * * ?";

        //create a trigger to be returned from the method
        Trigger triggerNew = TriggerBuilder.newTrigger().withIdentity(NAME_OF_TRIGGER, NAME_OF_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule(CRON_EXPRESSION)).build();

        //return triggerNew to schedule it in main() method
        return triggerNew;
    }
    */

    //create createTrigger() method that returns a trigger based on the time interval
    private static Trigger createTrigger() {

        //initialize time interval
         TIME_INTERVAL = 10;

        //create a trigger to be returned from the method
        Trigger triggerNew = TriggerBuilder.newTrigger().withIdentity(NAME_OF_TRIGGER, NAME_OF_GROUP)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME_INTERVAL).repeatForever())
                .build();

        // triggerNew to schedule it in main() method
        return triggerNew;
    }
}