package com.dimadl.androidarchitecturetemplate.internal.di.component;


import com.dimadl.androidarchitecturetemplate.internal.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetModule.class)
public interface NetComponent {
}
