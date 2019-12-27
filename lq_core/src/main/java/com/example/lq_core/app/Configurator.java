package com.example.lq_core.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * file_name:Configurator
 * date:2019-12-24 09:02
 * author:LQ
 * describe:TODO
 */
public class Configurator {
    private static final HashMap<String, Object> LQ_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();


    private Configurator() {
        LQ_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), false);
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 内部内懒汉单例模式
     *
     * @return
     */
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getConfigs() {
        return LQ_CONFIGS;
    }

    /**
     * 配置完成
     */
    public final void configure() {
        initIcons();
        LQ_CONFIGS.put(ConfigKeys.CONFIG_READY.name(), true);
    }

    /**
     *配置api
     * @param host
     * @return
     */
    public final Configurator withApiHost(String host){
        LQ_CONFIGS.put(ConfigKeys.NATIVE_API_HOST.name(),host);
        return this;
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    /**
     * 检查配置是否完成
     */
    private void checkConfiguration(){
        final boolean isReady = (boolean) LQ_CONFIGS.get(ConfigKeys.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready, call Configurator");
        }
    }


    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object value = LQ_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) LQ_CONFIGS.get(key);
    }
}
