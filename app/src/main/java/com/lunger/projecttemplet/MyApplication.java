package com.lunger.projecttemplet;

import android.app.Application;

/**
 * Created by Lunger on 2017/7/21.
 */

public class MyApplication extends Application{
    private static MyApplication instance;

    /**
     * 提供全局Context
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
