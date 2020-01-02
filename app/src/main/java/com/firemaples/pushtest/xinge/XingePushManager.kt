package com.firemaples.pushtest.xinge

import android.content.Context
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory
import com.firemaples.pushtest.PushManager
import com.firemaples.pushtest.PushService
import com.tencent.android.tpush.XGIOperateCallback
import com.tencent.android.tpush.XGPushConfig
import com.tencent.android.tpush.XGPushManager
import com.tencent.android.tpush.XGPushTextMessage

/**
 * http://xg.qq.com/app/ctr_index/index#/app/2100351405/order/create
 */
object XingePushManager {
    private val logger: Logger = LoggerFactory.getLogger(XingePushManager::class.java)

    fun init(context: Context) {
        XGPushConfig.enableDebug(context, true)

//        XGPushConfig.enableOtherPush(context, true)
//        XGPushConfig.setHuaweiDebug(true)
//        XGPushConfig.setMiPushAppId(context, "APPID")
//        XGPushConfig.setMiPushAppKey(context, "APPKEY")
//        XGPushConfig.setMzPushAppId(context, "APPID")
//        XGPushConfig.setMzPushAppKey(context, "APPKEY")

        XGPushManager.registerPush(context, object : XGIOperateCallback {
            override fun onSuccess(data: Any?, flag: Int) {
                logger.debug("Register success, data: $data, flag: $flag")
                if (data is String) {
                    onRegisterPushSuccess(data)
                }
            }

            override fun onFail(data: Any?, errorCode: Int, msg: String?) {
                logger.warn("Register failed, data: $data, errorCode: $errorCode, msg: $msg")
            }

        })
    }

    fun onRegisterPushSuccess(token: String) {
        PushManager.onReceivedRegId(PushService.Xinge, token)
    }

    fun onTextMessage(message: XGPushTextMessage) {
        PushManager.onReceiveData(PushService.Xinge, message.content)
    }
}