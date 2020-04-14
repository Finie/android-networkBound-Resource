package com.tospay.nbresource.remote.service;

import androidx.lifecycle.LiveData;

import com.tospay.nbresource.models.PreloadResponse;
import com.tospay.nbresource.remote.response.ApiResponse;
import com.tospay.nbresource.remote.response.Result;

import retrofit2.http.GET;

public interface TrainService {
    @GET("preload")
    LiveData<ApiResponse<Result<PreloadResponse>>> preloadData();
}
