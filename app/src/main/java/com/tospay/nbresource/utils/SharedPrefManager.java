package com.tospay.nbresource.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.tospay.nbresource.R;
import com.tospay.nbresource.models.TospayUser;

import java.util.Calendar;
import java.util.Date;

public class SharedPrefManager {
    public static final String KEY_REMEMBER_ME = "remember_me";
    private static final String PREF_ACTIVE_USER = "pref_active_user";
    private static final String KEY_TOKEN_EXPIRY = "token_expiry";
    private static final String KEY_REFRESHED_TOKEN = "token";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    private static SharedPreferences sharedPref;
    private Context context;

    private SharedPrefManager(Context context) {
        this.context = context;
    }

    public static SharedPrefManager getInstance(Context context) {
        return new SharedPrefManager(context);
    }

    public TospayUser getActiveUser() {
        SharedPreferences prefs = this.getSettings();
        String json = prefs.getString("pref_active_user", "");
        return !json.isEmpty() && !"null".equals(json) ? (TospayUser)Utils.getGsonParser().fromJson(json, TospayUser.class) : null;
    }

    public void setActiveUser(TospayUser user) {
        if (user != null && user.getExpiredAt() != null) {
            this.setTokenExpiryTime(user.getExpiredAt());
        }

        String json = Utils.getGsonParser().toJson(user);
        SharedPreferences.Editor editor = this.getSettings().edit();
        editor.putString("pref_active_user", json);
        editor.apply();
    }

    public String getAccessToken() {
        return this.getActiveUser() != null ? this.getActiveUser().getToken() : null;
    }

    public String getBearerRefreshToken() {
        return this.getActiveUser() != null ? this.getActiveUser().getRefreshToken() : null;
    }

    private SharedPreferences getSettings() {
        if (sharedPref == null) {
            sharedPref = this.context.getSharedPreferences(this.context.getString(R.string.app_name), 0);
        }

        return sharedPref;
    }

    public boolean read(String name, boolean def) {
        SharedPreferences prefs = this.getSettings();
        return prefs.getBoolean(name, def);
    }

    public void save(String name, boolean value) {
        SharedPreferences.Editor editor = this.getSettings().edit();
        editor.putBoolean(name, value);
        editor.apply();
    }

    public String read(String name, String def) {
        SharedPreferences prefs = this.getSettings();
        return prefs.getString(name, def);
    }

    public void save(String name, String value) {
        SharedPreferences.Editor editor = this.getSettings().edit();
        editor.putString(name, value);
        editor.apply();
    }

    private void setTokenExpiryTime(long expireAt) {
        SharedPreferences.Editor editor = this.getSettings().edit();
        editor.putLong("token_expiry", expireAt);
        editor.apply();
    }

    public boolean isTokenExpiredOrAlmost() {
        SharedPreferences prefs = this.getSettings();
        long expireAt = prefs.getLong("token_expiry", 0L);
        if (expireAt == 0L) {
            return true;
        } else {
            Date date = new Date(expireAt * 1000L);
            long diff = date.getTime() - Calendar.getInstance().getTime().getTime();
            return diff < 5L;
        }
    }

    public String getRefreshedToken() {
        SharedPreferences prefs = this.getSettings();
        return prefs.getString("token", (String)null);
    }

    public void setRefreshedToken(String refreshedToken) {
        SharedPreferences.Editor editor = this.getSettings().edit();
        editor.putString("token", refreshedToken);
        editor.apply();
    }
}
