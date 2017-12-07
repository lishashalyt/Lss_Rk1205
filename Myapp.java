package com.bawei.lss_rk1205;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by love_mysunshine on 2017/12/5.
 */

public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
