package com.demo.dbflowsample;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import timber.log.Timber;

/**
 * author marat
 * since 13.07.2017.
 */

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        FlowManager.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        FlowManager.destroy();
    }
}
