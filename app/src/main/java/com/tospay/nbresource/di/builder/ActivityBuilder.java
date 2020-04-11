package com.tospay.nbresource.di.builder;

import com.tospay.nbresource.BaseApplication;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract BaseApplication bindBaseApplication();

}
