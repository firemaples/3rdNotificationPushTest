package com.firemaples.pushtest.jpush

import android.app.Notification
import android.content.Context
import android.content.Intent
import cn.jpush.android.api.CmdMessage
import cn.jpush.android.api.CustomMessage
import cn.jpush.android.api.JPushMessage
import cn.jpush.android.api.NotificationMessage
import cn.jpush.android.service.JPushMessageReceiver
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory
import com.firemaples.pushtest.Utils

class JPushReceiver : JPushMessageReceiver() {
    private val logger: Logger = LoggerFactory.getLogger(JPushReceiver::class.java)

    override fun onCheckTagOperatorResult(context: Context?, jPushMessage: JPushMessage?) {
        super.onCheckTagOperatorResult(context, jPushMessage)
        logger.debug("onCheckTagOperatorResult(), jPushMessage: $jPushMessage")
    }

    override fun onNotifyMessageDismiss(
        context: Context?,
        notificationMessage: NotificationMessage?
    ) {
        super.onNotifyMessageDismiss(context, notificationMessage)
        logger.debug("onNotifyMessageDismiss(), notificationMessage: $notificationMessage")
    }

    override fun getNotification(
        context: Context?,
        notificationMessage: NotificationMessage?
    ): Notification {
        logger.debug("getNotification(), notificationMessage: $notificationMessage")
        return super.getNotification(context, notificationMessage)
    }

    override fun onNotifyMessageOpened(
        context: Context?,
        notificationMessage: NotificationMessage?
    ) {
        super.onNotifyMessageOpened(context, notificationMessage)
        logger.debug("onNotifyMessageOpened(), notificationMessage: $notificationMessage")
    }

    /**
     * General message
     *
     * Example:
     * onNotifyMessageArrived(), notificationMessage: NotificationMessage{notificationId=534119301, msgId='47287833623849523', appkey='bf93ceac2505f286583fc8e4', notificationContent='TestContent', notificationAlertType=7, notificationTitle='TestTtitle', notificationSmallIcon='', notificationLargeIcon='', notificationExtras='{}', notificationStyle=0, notificationBuilderId=0, notificationBigText='', notificationBigPicPath='', notificationInbox='', notificationPriority=0, notificationCategory='', developerArg0='', platform=0, notificationChannelId='', notificationType=0}
     */
    override fun onNotifyMessageArrived(
        context: Context?,
        notificationMessage: NotificationMessage?
    ) {
        super.onNotifyMessageArrived(context, notificationMessage)
        logger.debug("onNotifyMessageArrived(), notificationMessage: $notificationMessage")
    }

    override fun onRegister(context: Context?, registrationId: String?) {
        super.onRegister(context, registrationId)
        // Not working?
        logger.debug("onRegister(), registrationId: $registrationId")
    }

    override fun onCommandResult(context: Context?, cmdMessage: CmdMessage?) {
        super.onCommandResult(context, cmdMessage)
        logger.debug("onCommandResult(), cmdMessage: $cmdMessage")
    }

    /**
     * Data message
     *
     * Example:
     * onMessage(), customMessage: CustomMessage{messageId='29273441718182251', extra='', message='{"key":"user", "value":"firemaples"}', contentType='', title='', senderId='bf93ceac2505f286583fc8e4', appId='com.firemaples.pushtest'}
     */
    override fun onMessage(context: Context?, customMessage: CustomMessage?) {
        super.onMessage(context, customMessage)
        logger.debug("onMessage(), customMessage: $customMessage")

        if (customMessage != null) {
            JPushManager.onMessage(customMessage)
        }
    }

    override fun onTagOperatorResult(context: Context?, jPushMessage: JPushMessage?) {
        super.onTagOperatorResult(context, jPushMessage)
        logger.debug("onTagOperatorResult(), jPushMessage: $jPushMessage")
    }

    override fun onNotificationSettingsCheck(context: Context?, p1: Boolean, p2: Int) {
        super.onNotificationSettingsCheck(context, p1, p2)
        logger.debug("onNotificationSettingsCheck(), p1: $p1, p2: $p2")
    }

    override fun onConnected(context: Context?, p1: Boolean) {
        super.onConnected(context, p1)
        logger.debug("onConnected(), context: $context, p1: $p1")

        if (context != null) {
            JPushManager.onConnected(context)
        }
    }

    override fun onMobileNumberOperatorResult(context: Context?, jPushMessage: JPushMessage?) {
        super.onMobileNumberOperatorResult(context, jPushMessage)
        logger.debug("onMobileNumberOperatorResult(), jPushMessage: $jPushMessage")
    }

    override fun onAliasOperatorResult(context: Context?, jPushMessage: JPushMessage?) {
        super.onAliasOperatorResult(context, jPushMessage)
        logger.debug("onAliasOperatorResult(), jPushMessage: $jPushMessage")
    }

    override fun onMultiActionClicked(context: Context?, intent: Intent?) {
        super.onMultiActionClicked(context, intent)
        logger.debug("onMultiActionClicked(), intent: ${Utils.intentToString(intent)}")
    }
}