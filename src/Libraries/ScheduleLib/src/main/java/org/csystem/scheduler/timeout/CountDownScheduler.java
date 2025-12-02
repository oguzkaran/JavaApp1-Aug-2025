package org.csystem.scheduler.timeout;

import java.util.concurrent.TimeUnit;

public abstract class CountDownScheduler {
    protected CountDownScheduler(long durationInFuture, long countDownInterval, TimeUnit timeUnit)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    protected CountDownScheduler(long millisInFuture, long countDownInterval)
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public abstract void onTick(long remainingMilliseconds);
    public abstract void onFinish();

    public final void start()
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }

    public final void cancel()
    {
        throw new UnsupportedOperationException("Not yet implemented.");
    }
}