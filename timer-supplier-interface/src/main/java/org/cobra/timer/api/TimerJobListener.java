package org.cobra.timer.api;

import org.picollo.driver.DriverState;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class TimerJobListener implements JobListener {
    private TimerSupplierInterface timer;

    public TimerJobListener(TimerSupplierInterface timer) {
        this.timer = timer;
    }

    @Override
    public String getName() {
        return "TimerJobListener";
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        timer.setState(DriverState.RUNNING);
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        timer.setState(DriverState.STOPPED);
    }
}
