package org.csystem.scheduler.timeout;

import java.util.concurrent.TimeUnit;

public abstract class CountDownSchedulerX extends CountDownScheduler {
    protected CountDownSchedulerX(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        this(timeUnit.toMillis(durationInFuture), timeUnit.toMillis(countDownInterval));
    }

    protected CountDownSchedulerX(long millisInFuture, long countDownInterval)
    {
        super(millisInFuture, countDownInterval);
    }

    public abstract void onStart();

    public void startX()
    {
        onStart();
        start();
    }
}
