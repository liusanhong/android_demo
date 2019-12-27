package com.example.lq_core.app;

import android.app.Application;
import android.content.Context;

import java.util.WeakHashMap;

/**
 * file_name:Lq
 * date:2019-12-24 08:55
 * author:LQ
 * describe:TODO
 */
public final class Lq {
    public static Configurator init(Context context){
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static WeakHashMap<String ,Object> getConfigurations() {
        return Configurator.getInstance().getConfigs();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Application getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

}
