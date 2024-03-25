/*
* TimerSupplierInterface.java
*/
package org.cobra.timer.api;

import org.cobra.timer.model.TriggerType;
import org.picollo.config.api.AbstractConfigurableInterface;
import org.picollo.config.api.ConfigurationException;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.KeyMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Abstract class (interface) to supply infrastructure for scheduled (timer) business rules (tasks).
 * @author rod
 * @since 2018-08-30
 */
public abstract class TimerSupplierInterface extends AbstractConfigurableInterface {
    private static final Logger log = LoggerFactory.getLogger(TimerSupplierInterface.class);
    private static Scheduler scheduler;
    private static int number;

    static {
        try {
            SchedulerFactory schedulerFactory;
            Properties properties = new Properties();
            properties.setProperty("org.quartz.scheduler.skipUpdateCheck","true");
            properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
            properties.setProperty("org.quartz.threadPool.threadCount", "8");
            schedulerFactory = new StdSchedulerFactory(properties);
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                TimerSupplierInterface.stop();
            }));
        } catch (SchedulerException e) {
            log.error("Error scheduling timers.",e);
        }
    }

    public static void stop() {
        log.info("Stopping the scheduler service...");
        if( scheduler != null ) {
            try {
                scheduler.shutdown(true);
                log.info("Scheduler service stopped successfuly.");
            } catch (SchedulerException e) {
                log.info("Scheduler service stopped with problems.",e);
            }
        }
    }
    public TimerSupplierInterface() throws ConfigurationException {
        super();
        log.info("Starting timer module : {} ...",this.getClass().getName());
        setupTrigger();
        log.info("Finished starting module : {}.",this.getClass().getName());
    }

    protected void setupTrigger() {
        JobDetail jobDetail = null;

        log.info("Starting change configuration for {} ... trigger Type:{} time:{} cron:{}",getName(),getTriggerType(),time(),cronExpression());
        if( getJobClass() == null )
            return;
        try {
            removeJob();
            TimerJobListener timerJobListener = new TimerJobListener(this);
            switch (getTriggerType()) {
                case CRON_EXPRESSION_TRIGGER:
                    if( cronExpression() == null || cronExpression().isEmpty() ) {
                        throw new ConfigurationException("Error launching timer. Wrong cron expression:"+cronExpression());
                    }
                    jobDetail = newJob(getJobClass()).withIdentity(getJobClass().getCanonicalName()+"#"+(number++),getJobClass().getName()).build();
                    CronTrigger cronTrigger = newTrigger()
                            .withSchedule(cronSchedule(cronExpression()))
                            .build();
                    scheduler.scheduleJob(jobDetail,cronTrigger);
                    break;
                case WITH_FIXED_DELAY_TRIGGER:
                case AT_FIXED_RATE_TRIGGER:
                    if( time() <= 0 ) {
                        throw new IllegalArgumentException("Time should be greater than zero.");
                    }
                    jobDetail = newJob(getJobClass()).withIdentity(getJobClass().getCanonicalName(),getJobClass().getName()).build();
                    SimpleTrigger trigger = newTrigger()
                            .withSchedule(simpleSchedule()
                                    .withIntervalInMilliseconds(time())
                                    .repeatForever())
                            .build();
                    scheduler.scheduleJob(jobDetail,trigger);
                    break;
            }
            if( jobDetail == null ) {
                log.error("The job detail could not be configured trigger type={}.",getTriggerType());
            } else {
                scheduler.getListenerManager().addJobListener(timerJobListener, KeyMatcher.keyEquals(jobDetail.getKey()));
            }
            log.info("Configuration for {} changed successfully.",getName());
        } catch (Exception e) {
            log.error("Failed loading module.",e);
        }
    }

    public abstract TriggerType getTriggerType();

    public abstract String cronExpression();

    public abstract Class getJobClass();

    protected int time() {
        return 0;
    }

    protected void postCoreConfig() {
        setupTrigger();
    }

    public void removeJob() {
        try {
            Set<JobKey> contexts = scheduler.getJobKeys(GroupMatcher.groupEquals(getJobClass().getName()));
            contexts.stream()
                    .filter(context -> context.getGroup().equals(getJobClass().getName()))
                    .forEach(context -> {
                        try {
                            log.debug("Stopping {}...",context.getName());
                            scheduler.deleteJob(context);
                        } catch (UnableToInterruptJobException e) {
                            log.error("Unable to Interrupt job.",e);
                        } catch (SchedulerException e) {
                            log.error("Error stopping task.",e);
                        }
                    });
        } catch (SchedulerException e) {
            log.error("Failed to remove job.",e);
        }
    }
}