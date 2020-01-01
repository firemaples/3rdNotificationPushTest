package com.firemaples.pushtest.getui

import android.content.Context
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory
import com.igexin.sdk.GTIntentService
import com.igexin.sdk.PushManager
import com.igexin.sdk.message.GTCmdMessage
import com.igexin.sdk.message.GTNotificationMessage
import com.igexin.sdk.message.GTTransmitMessage

class GetuiMessageService : GTIntentService() {
    private val logger: Logger =
        LoggerFactory.getLogger(
            GetuiMessageService::class.java
        )

    override fun onReceiveServicePid(context: Context?, pid: Int) {
        logger.info("onReceiveServicePid(), pid: $pid")
        logger.info("ClientId: ${PushManager.getInstance().getClientid(context)}")
    }

    /**
     * Data message
     *
     * Example:
     * onReceiveMessageData(), msg: {messageId: cd488ff2f1d74b0ebab68c12cbbe96ab, taskId: GT_0101_6c2443d5e0fe259650736a44573c1399, payloadId: cd488ff2f1d74b0ebab68c12cbbe96ab:GT_0101_6c2443d5e0fe259650736a44573c1399, payloadSize: 36}
     */
    override fun onReceiveMessageData(context: Context?, msg: GTTransmitMessage?) {
        logger.info("onReceiveMessageData(), msg: ${msg.toString()}")

        if (msg != null) {
            GetuiPushManager.onReceiveCustomMessage(msg)
        }
    }

    override fun onReceiveClientId(context: Context?, clientId: String?) {
        logger.info("onReceiveClientId(), clientId: $clientId")
        if (clientId != null) GetuiPushManager.onReceiveClientId(clientId)
    }

    override fun onReceiveOnlineState(context: Context?, online: Boolean) {
        logger.info("onReceiveOnlineState(), online: $online")
    }

    override fun onReceiveCommandResult(context: Context?, cmdMessage: GTCmdMessage?) {
        logger.info("onReceiveCommandResult(), cmdMessage: $cmdMessage")
    }

    /**
     * General message
     *
     * Example:
     * onNotificationMessageArrived(), msg: {messageId: 261258d0e166413b9a16f1ee9426b6d5, taskId: TEST_0101_aaf21cfa62350c22f18c9218b2e2bdd0, title: TestTitle, content: TestContent}
     */
    override fun onNotificationMessageArrived(context: Context?, msg: GTNotificationMessage?) {
        logger.info("onNotificationMessageArrived(), msg: ${msg.toString()}")
    }

    override fun onNotificationMessageClicked(context: Context?, msg: GTNotificationMessage?) {
        logger.info("onNotificationMessageClicked(), msg: ${msg.toString()}")
    }
}

fun GTTransmitMessage?.toString(): String =
    this?.let { "{messageId: ${this.messageId}, taskId: ${this.taskId}, payloadId: ${this.payloadId}, payloadSize: ${this.payload.size}}" }
        ?: "null"

fun GTCmdMessage?.toString(): String =
    this?.let { "{action: ${this.action}}" } ?: "null"

fun GTNotificationMessage?.toString(): String =
    this?.let { "{messageId: ${this.messageId}, taskId: ${this.taskId}, title: ${this.title}, content: ${this.content}}" }
        ?: "null"
