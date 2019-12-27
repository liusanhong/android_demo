package com.example.ec_test;

import android.app.Application;

import com.example.lq_core.app.Lq;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

/**
 * file_name:MyApplication
 * date:2019-12-24 08:56
 * author:LQ
 * describe:TODO
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Lq.init(this)
                .withApiHost("https://")// TODO
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}
