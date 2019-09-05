package com.dimadl.androidarchitecturetemplate.internal.di.component;


import com.dimadl.androidarchitecturetemplate.internal.di.module.ApplicationModule;
import com.dimadl.androidarchitecturetemplate.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
}
