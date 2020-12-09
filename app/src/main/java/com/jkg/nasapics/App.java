package com.jkg.nasapics;

import android.app.Application;

public class App extends Application {
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Application getApplication(){
        return application;
    }
}
