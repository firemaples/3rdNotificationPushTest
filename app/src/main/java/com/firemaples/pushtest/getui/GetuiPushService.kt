package com.firemaples.pushtest.getui

import android.content.Intent
import android.os.IBinder
import com.firemaples.pushtest.Logger
import com.firemaples.pushtest.LoggerFactory
import com.firemaples.pushtest.Utils
import com.igexin.sdk.PushService

class GetuiPushService : PushService() {
    private val logger: Logger =
        LoggerFactory.getLogger(
            GetuiPushService::class.java
        )

    override fun onBind(intent: Intent?): IBinder? {
        logger.info("onBind()")
        return super.onBind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        logger.info("onCreate()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        logger.info(
            "onStartCommand(), intent: ${Utils.intentToString(
                intent
            )}, flags: $flags, startId: $startId"
        )
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.info("onDestroy()")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        logger.info("onLowMemory()")
    }
}