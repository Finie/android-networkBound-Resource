package com.tospay.nbresource.di.builder;

import com.tospay.nbresource.BaseApplication;
import com.tospay.nbresource.ui.activities.HomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract HomeActivity bindHomeActivity();


}
