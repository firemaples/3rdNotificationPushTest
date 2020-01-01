package com.firemaples.pushtest.getui

import android.content.Context
import com.firemaples.pushtest.PushManager
import com.firemaples.pushtest.PushService
import com.igexin.sdk.message.GTTransmitMessage
import java.nio.charset.Charset

object GetuiPushManager {
    fun init(context: Context) {
        with(com.igexin.sdk.PushManager.getInstance()) {
            initialize(context, GetuiPushService::class.java)
            registerPushIntentService(context, GetuiMessageService::class.java)
            setPrivacyPolicyStrategy(context, true)
//        turnOnPush(this);
//        bindAlias(this, "abcd");
//        setSilentTime(this, 0, 23);
        }
    }

    fun onReceiveClientId(clientId: String) {
        PushManager.onReceivedRegId(PushService.Getui, clientId)
    }

    fun onReceiveCustomMessage(msg: GTTransmitMessage) {
        val payload = msg.payload.toString(Charset.forName("UTF-8"))
        PushManager.onReceiveData(PushService.Getui, payload)
    }
}