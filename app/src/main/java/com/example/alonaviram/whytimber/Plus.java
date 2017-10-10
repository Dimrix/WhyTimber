package com.example.alonaviram.whytimber;

import timber.log.Timber;

/**
 * Created by alonaviram on 27/09/2017.
 */

class Plus {
    private static final String TAG = "Plus";
    int x;
    int y;

    public Plus(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int result() {
        Timber.d("result() called");
        return x + y;
    }
}
