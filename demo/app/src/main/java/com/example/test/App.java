package com.example.test;

import android.app.Application;

import com.eguan.monitor.EguanMonitorAgent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EguanMonitorAgent.getInstance().setDebugMode(this, true);
        EguanMonitorAgent.getInstance().initEguan(this, "7752552892442721d", "app channel");

    }
}
