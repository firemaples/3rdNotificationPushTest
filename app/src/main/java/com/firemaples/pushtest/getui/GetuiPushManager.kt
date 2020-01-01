package com.firemaples.pushtest.getui

import android.content.Context
import com.igexin.sdk.PushManager

object GetuiPushManager {
    fun init(context: Context) {
        PushManager.getInstance().initialize(context, GetuiPushService::class.java)
        PushManager.getInstance()
            .registerPushIntentService(context, GetuiMessageService::class.java)
        PushManager.getInstance().setPrivacyPolicyStrategy(context, true)
        //        PushManager.getInstance().turnOnPush(this);
//        PushManager.getInstance().bindAlias(this, "abcd");
//        PushManager.getInstance().setSilentTime(this, 0, 23);
    }
}