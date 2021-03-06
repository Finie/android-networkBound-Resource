package com.tospay.nbresource.remote.response;

import android.util.Log;

import androidx.annotation.Nullable;

import com.tospay.nbresource.remote.exception.ApplicationException;
import com.tospay.nbresource.utils.Utils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import retrofit2.Response;

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

    @SuppressWarnings("CatchMayIgnoreException")
    public ApiResponse(Response<T> response) {
        code = response.code();
        if (response.isSuccessful()) {
            body = response.body();
            errorMessage = null;
        } else {
            String message = null;

            if (response.code() == 502) {
                message = "Oop! Service is currently down. Please try again later.";
            } else {
                if (response.errorBody() != null) {
                    try {
                        message = response.errorBody().string();
                        ApplicationException exception = getApplicationException(message);
                        message = exception.getErrorMessage();
                    } catch (IOException ignored) {
                        Log.e(TAG, "error while parsing response: ", ignored);
                    }
                }

                if (message == null || message.trim().length() == 0) {
                    message = response.message();
                }
            }

            errorMessage = message;
            body = null;
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
    private ApplicationException getApplicationException(String errorStr) {
        return Utils.getGsonParser().fromJson(errorStr, ApplicationException.class);
    }
}
