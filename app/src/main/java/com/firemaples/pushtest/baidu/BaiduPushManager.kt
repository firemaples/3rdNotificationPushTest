package com.firemaples.pushtest.baidu

import android.content.Context
import com.baidu.android.pushservice.PushConstants
import com.firemaples.pushtest.BuildConfig
import com.firemaples.pushtest.PushManager
import com.firemaples.pushtest.PushService

/**
 * https://push.baidu.com/console/GZ5Q74meMG0Tii2bpodxFrIg?device_type=3#/android/notice
 */
object BaiduPushManager {
    fun init(context: Context) {
        com.baidu.android.pushservice.PushManager.startWork(
            context,
            PushConstants.LOGIN_TYPE_API_KEY, BuildConfig.BAIDU_PUSH_KEY
        )
    }

    fun onBind(channelId: String) {
        PushManager.onReceivedRegId(PushService.Baidu, channelId)
    }

    fun onMessage(message: String) {
        PushManager.onReceiveData(PushService.Baidu, message)
    }
}