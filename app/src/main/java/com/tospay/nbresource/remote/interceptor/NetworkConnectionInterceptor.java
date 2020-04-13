package com.tospay.nbresource.remote.interceptor;

import android.content.Context;

import androidx.annotation.NonNull;

import com.tospay.nbresource.remote.exception.NoConnectivityException;
import com.tospay.nbresource.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkConnectionInterceptor implements Interceptor {

    private Context mContext;

    public NetworkConnectionInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        if (!NetworkUtils.isNetworkAvailable(mContext)) {
            throw new NoConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }
}
