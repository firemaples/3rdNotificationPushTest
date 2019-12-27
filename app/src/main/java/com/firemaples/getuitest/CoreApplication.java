package com.firemaples.getuitest;

import android.app.Application;
import com.igexin.sdk.PushManager;

public class CoreApplication extends Application {
    private Logger logger = LoggerFactory.getLogger(CoreApplication.class);

    @Override
    public void onCreate() {
        super.onCreate();

        logger.debug("onCreate()");

        PushManager.getInstance().initialize(this, GetuiPushService.class);
        PushManager.getInstance().registerPushIntentService(this, GetuiMessageService.class);

        PushManager.getInstance().setPrivacyPolicyStrategy(this, true);
//        PushManager.getInstance().turnOnPush(this);
//        PushManager.getInstance().bindAlias(this, "abcd");
//        PushManager.getInstance().setSilentTime(this, 0, 23);
    }
}
