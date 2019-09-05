package com.dimadl.androidarchitecturetemplate.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.dimadl.androidarchitecturetemplate.AndroidApplication;
import com.dimadl.androidarchitecturetemplate.internal.di.component.ApplicationComponent;
import com.dimadl.androidarchitecturetemplate.navigator.Navigator;

import androidx.appcompat.app.AppCompatActivity;


import javax.inject.Inject;

public class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }
}
