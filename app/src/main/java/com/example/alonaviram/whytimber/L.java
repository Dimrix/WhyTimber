package com.example.alonaviram.whytimber;

import android.util.Log;

public class L {
    private static boolean sLoggingEnabled = BuildConfig.DEBUG;
    private static final String TAG = "TAG";

    public static void e(String string) {
        e(TAG, string);
    }

    public static void e(String tag, String string) {
        if (sLoggingEnabled) {
            Log.e(tag, string);
        }
    }

    public static void e(String name, String message, Exception e) {
        if (sLoggingEnabled) {
            Log.e(TAG, message);
        }
    }

    public static void d(String tag, String string) {
        if (sLoggingEnabled) {
            Log.d(tag, string);
        }
    }

    public static void d(String string) {
        d(TAG, string);
    }

    public static void f(String string) {
        if (sLoggingEnabled) {
            Log.e("FLOW", string);
        }
    }

    public static void f(String tag, String string) {
        if (sLoggingEnabled) {
            Log.e("FLOW", tag + " :" + string);
        }
    }

}

