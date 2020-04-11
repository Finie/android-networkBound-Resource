package com.tospay.nbresource.remote.response;

import androidx.annotation.Nullable;

import com.tospay.nbresource.remote.exception.ApplicationException;
import com.tospay.nbresource.utils.Utils;

import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

public class ApiResponse<T> {

    private static final String TAG = "ApiResponse";

    public final int code;

    @Nullable
    public final T body;

    @Nullable
    public final String errorMessage;

    public ApiResponse(Throwable error) {
        code = 500;
        body = null;

        if (error instanceof UnknownHostException) {
            errorMessage = "No network available, please check your WiFi or Data connection";
        } else if (error instanceof ConnectException) {
            errorMessage = "No network available, please check your WiFi or Data connection";
        } else if (error instanceof SSLException) {
            errorMessage = "Failed, please try again";
        } else {
            errorMessage = error.getMessage();
        }
    }


    /**
     * Checks response code
     *
     * @return true
     */
    public boolean isSuccessful() {
        return code >= 200 && code < 300;
    }

    /**
     * Parse json response from server
     *
     * @param errorStr - json string
     * @return tospay exception
     */
    private ApplicationException getTospayException(String errorStr) {
        return Utils.getGsonParser().fromJson(errorStr, ApplicationException.class);
    }
}
