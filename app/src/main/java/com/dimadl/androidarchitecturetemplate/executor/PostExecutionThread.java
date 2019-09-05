package com.dimadl.androidarchitecturetemplate.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
