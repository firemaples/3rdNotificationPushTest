package com.firemaples.pushtest

import android.util.Log

class Logger(val tag: String) {
    constructor(clazz: Class<*>) : this(clazz.simpleName)

    fun debug(msg: String) {
        Log.d(tag, msg)
    }

    fun info(msg: String) {
        Log.i(tag, msg)
    }

    fun warn(msg: String) {
        Log.w(tag, msg)
    }

    fun error(msg: String, t: Throwable?) {
        Log.e(tag, msg, t)
    }
}

class LoggerFactory() {
    companion object {
        @JvmStatic
        fun getLogger(tag: String): Logger =
            Logger(tag)

        @JvmStatic
        fun getLogger(clazz: Class<*>): Logger =
            Logger(clazz)
    }
}