package com.firemaples.pushtest.umeng

import android.content.Context
import com.firemaples.pushtest.*
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent
import com.umeng.message.UmengMessageHandler
import com.umeng.message.entity.UMessage

object UmengPushManager {
    private val logger: Logger = LoggerFactory.getLogger(UmengPushManager::class.java)

    fun init(context: Context) {
        UMConfigure.init(
            context,
            "5e0d7fcdcb23d2dc8b000048",
            "Umeng",
            UMConfigure.DEVICE_TYPE_PHONE,
            BuildConfig.UMENG_MESSAGE_SECRET_KEY
        )

        with(PushAgent.getInstance(context)) {
            register(object : IUmengRegisterCallback {
                override fun onSuccess(deviceToken: String?) {
                    logger.debug("On register success, deviceToken: $deviceToken")

                    if (deviceToken != null) {
                        onRegisterSuccess(deviceToken)
                    }
                }

                override fun onFailure(s: String?, s1: String?) {
                    logger.warn("On register failed, s: $s, s1: $s1")
                }
            })

            messageHandler = object : UmengMessageHandler() {
                /**
                 * General message
                 *
                 * Example:
                 * dealWithNotificationMessage(), msg: com.umeng.message.entity.UMessage@bbe07c4
                 */
                override fun dealWithNotificationMessage(context: Context?, msg: UMessage?) {
                    super.dealWithNotificationMessage(context, msg)
                    logger.debug("dealWithNotificationMessage(), msg: $msg")
                }

                /**
                 * Data message
                 *
                 * Example:
                 * dealWithCustomMessage(), msg: com.umeng.message.entity.UMessage@842c3a8
                 */
                override fun dealWithCustomMessage(context: Context?, msg: UMessage?) {
                    super.dealWithCustomMessage(context, msg)
                    logger.debug("dealWithCustomMessage(), msg: $msg")

                    if (msg != null) {
                        onReceiveCustomMessage(msg)
                    }
                }
            }

            onAppStart()
        }
    }

    fun onRegisterSuccess(deviceToken: String) {
        PushManager.onReceivedRegId(PushService.Umeng, deviceToken)
    }

    fun onReceiveCustomMessage(msg: UMessage) {
        PushManager.onReceiveData(PushService.Umeng, msg.custom)
    }
}