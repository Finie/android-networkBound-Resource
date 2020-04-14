package com.tospay.nbresource.ui.viewModels;

import android.view.View;

import com.tospay.nbresource.remote.repository.TrainRepository;
import com.tospay.nbresource.ui.base.BaseViewModel;
import com.tospay.nbresource.ui.interfaces.HomeNavigator;
import com.tospay.nbresource.utils.SharedPrefManager;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel<HomeNavigator>
        implements View.OnClickListener {

    private final TrainRepository mTrainRepository;
    private final SharedPrefManager sharedPrefManager;

    @Inject
    public HomeViewModel(TrainRepository mTrainRepository, SharedPrefManager sharedPrefManager) {
        this.mTrainRepository = mTrainRepository;
        this.sharedPrefManager = sharedPrefManager;
    }


    @Override
    public void onClick(View v) {

    }
}
