package com.example.alonaviram.whytimber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView tv;
    private ActivityTree mTree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.logTextView);

        if (BuildConfig.DEBUG) {
            mTree = new ActivityTree();
            Timber.plant(mTree);
        }
        noTag();
        customTag();
        stringFormat();
        loggingException();


        // add log to file.

        // unit tests.
    }


    private void noTag() {
        Timber.d("some message");
        L.d(TAG, "some message");
    }

    private void customTag() {
        Timber.tag("LifeCycle").d("Activity created"); // can be used in LifeCycleListener class.
    }

    private void stringFormat() {
        Timber.d("a = %d b = %d", 5, 6);
        // L - need to implement.
    }


    private void loggingException() {
        try {
            Plus p = null;
            p.result();
        } catch (NullPointerException e) {
            Timber.d(e); // debug log - won't be logged in Release.
            Timber.e(e); // error log - will be logged in Release.

            // no timber:
            e.printStackTrace(); // will be printed on release
            // or
            L.e(e.getMessage()); // won't print stacktrace
            Log.e("tag", "msg", e); // need to implement in L
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.uproot(mTree);
    }

    class ActivityTree extends Timber.Tree {

        @Override
        protected void log(int priority, String tag, String message, Throwable t) {
            tv.append(tag + " : " + message + "\n");
        }
    }
}
