package com.example.alonaviram.whytimber;

import android.app.Application;
import android.util.Log;

import timber.log.Timber;

/**
 * Created by alonaviram on 26/09/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initTimber();
    }


    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }







    //    Timber.plant(new CrashReportingTree());
    //    Timber.plant(new FileLoggingTree());
    private class MyDebugTree extends Timber.DebugTree {
        @Override
        protected String createStackElementTag(StackTraceElement element) {
            // add line number.
            return super.createStackElementTag(element) + ":" + element.getLineNumber();
        }
    }

    private class CrashReportingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
//            Crashlytics.log(priority, tag, message);
//            if (t == null) { // can add by priority -  priority == Log.VERBOSE || priority == Log.DEBUG
//                return;
//            }
//            if (t != null) {
//                Crashlytics.logException(t);
//            }

        }

        @Override
        protected boolean isLoggable(String tag, int priority) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return false;
            }
            return true;
        }
    }

    private class FileLoggingTree extends Timber.Tree {
        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            if (shouldWriteToFile(priority, tag, message, t)) {
                writeToFile(priority, tag, message, t);
            }
        }

        private boolean shouldWriteToFile(int priority, String tag, String message, Throwable t) {
            // TODO: 27/09/2017 implement
            return priority == Log.DEBUG;
        }

        private void writeToFile(int priority, String tag, String message, Throwable t) {
            // TODO: 27/09/2017 implement
        }
    }
}
