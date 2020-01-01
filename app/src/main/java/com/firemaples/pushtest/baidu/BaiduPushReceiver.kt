package com.firemaples.pushtest.baidu

import android.content.Context
import com.baidu.android.pushservice.PushMessageReceiver
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory

class BaiduPushReceiver : PushMessageReceiver() {
    private val logger: Logger = LoggerFactory.getLogger(BaiduPushReceiver::class.java)

    override fun onBind(
        context: Context?,
        errorCode: Int,
        appid: String?,
        userId: String?,
        channelId: String?,
        requestId: String?
    ) {
        logger.debug("onBind(), errorCode: $errorCode, appId: $appid, userId: $userId, channelId: $channelId, requestId: $requestId")
        if (channelId != null) {
            BaiduPushManager.onBind(channelId)
        }
    }

    /**
     * Data message
     *
     * Example:
     * onMessage(), message: {"key":"user", "value":"firemaples"}, customContentString: null
     */
    override fun onMessage(
        context: Context?,
        message: String?,
        customContentString: String?
    ) {
        logger.debug("onMessage(), message: $message, customContentString: $customContentString")

        if (message != null) {
            BaiduPushManager.onMessage(message)
        }
    }

    override fun onNotificationClicked(
        context: Context?,
        title: String?,
        description: String?,
        customContentString: String?
    ) {
        logger.debug("onNotificationClicked(), title: $title, description: $description, customContentString: $customContentString")
    }

    /**
     * General message
     *
     * Example:
     * onNotificationArrived(), title: TestTitle, description: TestContent, customContentString: null
     */
    override fun onNotificationArrived(
        context: Context?,
        title: String?,
        description: String?,
        customContentString: String?
    ) {
        logger.debug("onNotificationArrived(), title: $title, description: $description, customContentString: $customContentString")
    }

    override fun onSetTags(
        context: Context?,
        errorCode: Int,
        successTags: MutableList<String>?,
        failTags: MutableList<String>?,
        requestId: String?
    ) {
        logger.debug("onSetTags(), errorCode: $errorCode, successTags: $successTags, failTags: $failTags, requestId: $requestId")
    }

    override fun onDelTags(
        context: Context?,
        errorCode: Int,
        successTags: MutableList<String>?,
        failTags: MutableList<String>?,
        requestId: String?
    ) {
        logger.debug("onDelTags(), errorCode: $errorCode, successTags: $successTags, failTags: $failTags, requestId: $requestId")
    }

    override fun onListTags(
        context: Context?,
        errorCode: Int,
        tags: MutableList<String>?,
        requestId: String?
    ) {
        logger.debug("onListTags(), errorCode: $errorCode, tags: $tags, requestId: $requestId")
    }

    override fun onUnbind(
        context: Context?,
        errorCode: Int,
        requestId: String?
    ) {
        logger.debug("onUnbind(), errorCode: $errorCode, requestId: $requestId")
    }

}