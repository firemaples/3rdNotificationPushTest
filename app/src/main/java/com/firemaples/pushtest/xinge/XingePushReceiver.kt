package com.firemaples.pushtest.xinge

import android.content.Context
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory
import com.tencent.android.tpush.*

class XingePushReceiver : XGPushBaseReceiver() {
    private val logger: Logger = LoggerFactory.getLogger(XingePushReceiver::class.java)

    override fun onRegisterResult(
        context: Context?,
        errorCode: Int,
        registerMessage: XGPushRegisterResult?
    ) {
        logger.debug("onRegisterResult(), errorCode: $errorCode, registerMessage: $registerMessage")
    }

    override fun onUnregisterResult(context: Context?, errorCode: Int) {
        logger.debug("onUnregisterResult(), errorCode: $errorCode")
    }

    /**
     * Data message
     *
     * Example:
     * onTextMessage(), message: XGPushShowedResult [title=null, content={"key":"user","value":"firemaples"}, customContent=null]
     */
    override fun onTextMessage(context: Context?, message: XGPushTextMessage?) {
        logger.debug("onTextMessage(), message: $message")
        if (message != null) {
            XingePushManager.onTextMessage(message)
        }
    }

    override fun onSetTagResult(context: Context?, errorCode: Int, tagName: String?) {
        logger.debug("onSetTagResult(), errorCode: $errorCode, tagName: $tagName")
    }

    override fun onDeleteTagResult(context: Context?, errorCode: Int, tagName: String?) {
        logger.debug("onDeleteTagResult(), errorCode: $errorCode, tagName: $tagName")
    }

    /**
     * General message
     *
     * Example:
     * onNotifactionShowedResult(), notifiShowedRlt: XGPushShowedResult [msgId=2326522928, title=TestTitle, content=TestContent, customContent=, activity=com.firemaples.pushtest.MainActivity, notificationActionType1]
     */
    override fun onNotifactionShowedResult(
        context: Context?,
        notifiShowedRlt: XGPushShowedResult?
    ) {
        logger.debug("onNotifactionShowedResult(), notifiShowedRlt: $notifiShowedRlt")
    }

    override fun onNotifactionClickedResult(context: Context?, message: XGPushClickedResult?) {
        logger.debug("onNotifactionClickedResult(), message: $message")
    }

}