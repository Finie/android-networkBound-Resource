package com.tospay.nbresource.ui.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.tospay.nbresource.remote.ApiConstants;
import com.tospay.nbresource.utils.NetworkUtils;
import com.tospay.nbresource.utils.SharedPrefManager;

import org.greenrobot.eventbus.EventBus;

import java.net.URISyntaxException;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding,V extends BaseViewModel>
extends DaggerAppCompatActivity {
    private T mViewDataBinding;
    private V mViewModel;
    private static final String TAG = "BaseActivity";

    @Inject
    SharedPrefManager mSharedPrefManager;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();


    private Emitter.Listener onNewMessage = args -> {
        String jsonStr = args[0].toString();

        /*NotificationUtils.transformPayload(jsonStr);*/
        EventBus.getDefault().post(jsonStr);
    };

    private Socket mSocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();

        if (mSharedPrefManager.getAccessToken() != null) {
            setBearerToken(mSharedPrefManager.getAccessToken());
        }

        if (getAccessToken() != null) {
            try {
                //handlig notification url
                IO.Options mOptions = new IO.Options();
                if (getAccessToken() != null) {
                    mOptions.query = "token=" + getAccessToken();
                    mSocket = IO.socket(ApiConstants.NOTIFICATION_URL, mOptions);
                }
            } catch (URISyntaxException e) {
                Log.e(TAG, "sockets: ", e);
            }

            mSocket.on("notify", onNewMessage);
            mSocket.connect();
        }
    }

    public String getAccessToken() {
        return mSharedPrefManager.getAccessToken();
    }

    /**
     * Performs data binding
     */
    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }

    @Override
    protected void onDestroy() {
        mViewDataBinding.unbind();
        if (mSocket != null) {
            mSocket.disconnect();
            mSocket.off("notify", onNewMessage);
        }
        super.onDestroy();
    }

    /**
     * Starts MainActivity if Token has Expired
     */
    public void openActivityOnTokenExpire() {
        //handle when token expires
       /* startActivityForResult(new Intent(this, AuthActivity.class), AuthActivity.REQUEST_CODE_LOGIN);*/
    }

    /**
     * Hides KeyBoard
     */
    public void hideKeyBoard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        }
    }


    /**
     * Check if network is connected
     *
     * @return true|false
     */
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkAvailable(getApplicationContext());
    }

    public void setBearerToken(String token) {
        String bearerToken = "Bearer " + token;
        mViewModel.setBearerToken(bearerToken);
    }

    public String getBearerToken() {
        return mSharedPrefManager.getAccessToken();
    }

    public void reloadBearerToken() {
        setBearerToken(getBearerToken());
    }
}
