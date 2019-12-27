package com.firemaples.getuitest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.igexin.sdk.GTServiceManager

class GetuiPushService : Service() {
    private val logger: Logger = LoggerFactory.getLogger(GetuiPushService::class.java)

    override fun onBind(intent: Intent?): IBinder? {
        logger.info("onBind()")
        return GTServiceManager.getInstance().onBind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        logger.info("onCreate()")
        GTServiceManager.getInstance().onCreate(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        logger.info("onStartCommand(), intent: ${Utils.intentToString(intent)}, flags: $flags, startId: $startId")
        return GTServiceManager.getInstance().onStartCommand(this, intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.info("onDestroy()")
        GTServiceManager.getInstance().onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        logger.info("onLowMemory()")
        GTServiceManager.getInstance().onLowMemory()
    }
}