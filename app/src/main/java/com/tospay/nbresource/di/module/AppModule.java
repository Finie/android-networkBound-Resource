package com.tospay.nbresource.di.module;

import android.content.Context;

import com.tospay.nbresource.BaseApplication;
import com.tospay.nbresource.remote.SgrServiceGenerator;
import com.tospay.nbresource.remote.repository.TrainRepository;
import com.tospay.nbresource.remote.service.TrainService;
import com.tospay.nbresource.remote.util.AppExecutors;
import com.tospay.nbresource.utils.SharedPrefManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author fin
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

    @Provides
    @Singleton
    AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }


    @Provides
    @Singleton
    TrainRepository provideTrainRepository(AppExecutors appExecutors, TrainService trainService){
        return new TrainRepository(trainService,appExecutors);
    }

    @Provides
    @Singleton
    TrainService provideTrainService(Context context){
        return SgrServiceGenerator.createService(TrainService.class,context);
    }


    @Provides
    @Singleton
    SharedPrefManager provideSharedPrefManager(Context context) {
        return SharedPrefManager.getInstance(context);
    }


}
