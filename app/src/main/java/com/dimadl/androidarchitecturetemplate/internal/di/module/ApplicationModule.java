package com.dimadl.androidarchitecturetemplate.internal.di.module;

import android.content.Context;

import com.dimadl.androidarchitecturetemplate.AndroidApplication;
import com.dimadl.androidarchitecturetemplate.executor.PostExecutionThread;
import com.dimadl.androidarchitecturetemplate.executor.ThreadExecutor;
import com.dimadl.androidarchitecturetemplate.executor.impl.JobExecutor;
import com.dimadl.androidarchitecturetemplate.executor.impl.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

}
