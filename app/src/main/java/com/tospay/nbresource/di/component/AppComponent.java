package com.tospay.nbresource.di.component;


import com.tospay.nbresource.BaseApplication;
import com.tospay.nbresource.di.builder.ActivityBuilder;
import com.tospay.nbresource.di.builder.FragmentBuilder;
import com.tospay.nbresource.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        FragmentBuilder.class
})
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BaseApplication> {

    }
}
