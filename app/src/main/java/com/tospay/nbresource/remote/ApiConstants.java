package com.tospay.nbresource.remote;

public class ApiConstants {

    /**
     * Connection timeout duration
     */
    public static final int CONNECT_TIMEOUT = 60 * 1000;

    /**
     * Connection Read timeout duration
     */
    public static final int READ_TIMEOUT = 60 * 1000;

    /**
     * Connection write timeout duration
     */
    public static final int WRITE_TIMEOUT = 60 * 1000;

    /**
     * Gateway Endpoint
     */
    public static final String BASE_URL = "http://kpa-api.tospay.net:3060/api/";

    /**
     * Notification Endpoint
     */
    public static final String NOTIFICATION_URL = "https://taar.tospay.net";

    /**
     * Notification channel
     */
    public static final String NOTIFICATION_CHANNEL = "notify";
}