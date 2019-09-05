package com.dimadl.androidarchitecturetemplate.presenter;

public abstract class BasePresenter<T> {
    protected T view;

    public void bindView(T baseView) {
        this.view = baseView;
    }

    public void destroy() {
        this.view = null;
    }

}
