package com.tospay.nbresource.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.tospay.nbresource.BR;
import com.tospay.nbresource.R;
import com.tospay.nbresource.databinding.ActivityHomeBinding;
import com.tospay.nbresource.ui.base.BaseActivity;
import com.tospay.nbresource.ui.interfaces.HomeNavigator;
import com.tospay.nbresource.ui.viewModels.HomeViewModel;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel>  {

    private ActivityHomeBinding mBinding;
    private HomeViewModel homeViewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public int getBindingVariable() {
        return BR.homeViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        homeViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel.class);
        return homeViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        mBinding.setHomeViewModel(homeViewModel);
    }
}
