package com.firemaples.pushtest.jpush

import android.content.Context
import cn.jpush.android.api.CustomMessage
import cn.jpush.android.api.JPushInterface
import com.firemaples.pushtest.PushManager
import com.firemaples.pushtest.PushService

/**
 * https://www.jiguang.cn/jpush2/#/app/bf93ceac2505f286583fc8e4/push_form/custom
 */
object JPushManager {
    fun init(context: Context) {
        JPushInterface.setDebugMode(true)
        JPushInterface.init(context)
    }

    fun queryRegistrationID(context: Context): String =
        JPushInterface.getRegistrationID(context)

    fun onConnected(context: Context) {
        val regId = queryRegistrationID(context)
        PushManager.onReceivedRegId(PushService.JPush, regId)
    }

    fun onMessage(message: CustomMessage) {
        PushManager.onReceiveData(PushService.JPush, message.message)
    }
}