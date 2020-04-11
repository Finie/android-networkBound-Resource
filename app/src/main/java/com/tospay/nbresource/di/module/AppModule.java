package com.tospay.nbresource.di.module;

import android.content.Context;

import com.tospay.nbresource.BaseApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Freddy Genicho
 */
@Module(includes = {
        ViewModelModule.class,
})
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(BaseApplication application) {
        return application;
    }

}
