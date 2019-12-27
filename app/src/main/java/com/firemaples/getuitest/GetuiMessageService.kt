package com.firemaples.getuitest

import android.content.Context
import com.google.gson.Gson
import com.igexin.sdk.GTIntentService
import com.igexin.sdk.PushManager
import com.igexin.sdk.message.GTCmdMessage
import com.igexin.sdk.message.GTNotificationMessage
import com.igexin.sdk.message.GTTransmitMessage
import com.workdo.networktester.NetworkTester
import java.nio.charset.Charset

class GetuiMessageService : GTIntentService() {
    private val logger: Logger = LoggerFactory.getLogger(GetuiMessageService::class.java)

    override fun onReceiveServicePid(context: Context?, pid: Int) {
        logger.info("onReceiveServicePid(), pid: $pid")
        logger.info("ClientId: ${PushManager.getInstance().getClientid(context)}")
    }

    override fun onReceiveMessageData(context: Context?, msg: GTTransmitMessage?) {
        logger.info("onReceiveMessageData(), msg: ${msg.toString()}")

        if (msg != null) {
            val result = msg.payload.toString(Charset.defaultCharset())
            logger.info("payload: $result")
            val data = Gson().fromJson<MessageData>(result, MessageData::class.java)
            when (data.key) {
                "user" -> NetworkTester.test(data.value.toString())
            }
        }
    }

    override fun onReceiveClientId(context: Context?, clientId: String?) {
        logger.info("onReceiveClientId(), clientId: $clientId")
    }

    override fun onReceiveOnlineState(context: Context?, online: Boolean) {
        logger.info("onReceiveOnlineState(), online: $online")
    }

    override fun onReceiveCommandResult(context: Context?, cmdMessage: GTCmdMessage?) {
        logger.info("onReceiveCommandResult(), cmdMessage: $cmdMessage")
    }

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

class MessageData {
    val key: String? = null
    val value: String? = null
}