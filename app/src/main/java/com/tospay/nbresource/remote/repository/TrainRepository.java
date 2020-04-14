package com.tospay.nbresource.remote.repository;

import com.tospay.nbresource.remote.service.TrainService;
import com.tospay.nbresource.remote.util.AppExecutors;

public class TrainRepository {

    private final TrainService mTrainService;
    private final AppExecutors mAppExecutors;

    public TrainRepository(TrainService mTrainService, AppExecutors mAppExecutors) {
        this.mTrainService = mTrainService;
        this.mAppExecutors = mAppExecutors;
    }


}
