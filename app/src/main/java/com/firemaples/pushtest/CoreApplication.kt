package com.firemaples.pushtest

import android.app.Application
import com.firemaples.pushtest.LoggerFactory.Companion.getLogger

class CoreApplication : Application() {
    private val logger: Logger = getLogger(CoreApplication::class.java)

    override fun onCreate() {
        super.onCreate()
        logger.debug("onCreate()")

        PushManager.init(this)
    }
}