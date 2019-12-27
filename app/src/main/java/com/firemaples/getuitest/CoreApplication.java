package com.firemaples.getuitest;

import android.app.Application;
import com.igexin.sdk.PushManager;

public class CoreApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        PushManager.getInstance().initialize(this, GetuiPushService.class);
        PushManager.getInstance().registerPushIntentService(this, GetuiMessageService.class);
//        PushManager.getInstance().turnOnPush(this);
//        PushManager.getInstance().bindAlias(this, "abcd");
//        PushManager.getInstance().setSilentTime(this, 0, 23);
    }
}
