package com.dimadl.androidarchitecturetemplate;

import android.app.Application;


import com.dimadl.androidarchitecturetemplate.internal.di.component.ApplicationComponent;
import com.dimadl.androidarchitecturetemplate.internal.di.component.DaggerApplicationComponent;
import com.dimadl.androidarchitecturetemplate.internal.di.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
