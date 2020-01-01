package com.firemaples.pushtest

import android.app.Application
import com.firemaples.pushtest.LoggerFactory.Companion.getLogger
import com.firemaples.pushtest.getui.GetuiPushManager

class CoreApplication : Application() {
    private val logger: Logger = getLogger(CoreApplication::class.java)

    override fun onCreate() {
        super.onCreate()
        logger.debug("onCreate()")

        GetuiPushManager.init(this)
    }
}