package com.firemaples.pushtest

import android.content.Context
import com.firemaples.pushtest.baidu.BaiduPushManager
import com.firemaples.pushtest.getui.GetuiPushManager
import com.firemaples.pushtest.jpush.JPushManager
import com.firemaples.pushtest.xinge.XingePushManager
import com.google.gson.Gson
import com.workdo.networktester.NetworkTester

object PushManager {
    private val logger: Logger = LoggerFactory.getLogger(PushManager::class.java)

    fun init(context: Context) {
        GetuiPushManager.init(context)
        JPushManager.init(context)
        BaiduPushManager.init(context)
        XingePushManager.init(context)
    }

    fun onReceivedRegId(pushService: PushService, regId: String) {
        logger.debug("onReceivedClientId(), pushService: $pushService, regId: $regId")
    }

    fun onReceiveData(pushService: PushService, payload: String) {
        logger.debug("onReceiveData(), pushService: $pushService, payload: $payload")

        try {
            val data = Gson().fromJson<MessageData>(payload, MessageData::class.java)
            when (data.key) {
                "user" -> NetworkTester.test(data.value.toString())
            }
        } catch (e: Exception) {
            logger.error("", e)
        }
    }
}

enum class PushService {
    Getui,
    JPush,
    Baidu,
    Xinge,
}

class MessageData {
    val key: String? = null
    val value: String? = null
}