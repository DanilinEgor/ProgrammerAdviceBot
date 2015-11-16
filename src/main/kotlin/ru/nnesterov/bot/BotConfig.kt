package ru.nnesterov.bot

import java.io.FileInputStream
import java.io.InputStream
import java.util.*


class BotConfig (private val path:String) {
    val botConfig = Properties();
    init {
        val classLoader = Thread.currentThread().getContextClassLoader();
        classLoader.getResourceAsStream(path).use {
            botConfig.load(it)
        }
    }

    val token : String
        get() {
            return botConfig.getProperty("TOKEN")
        }

    val webHookUri : String
        get() {
            return botConfig.getProperty("WEBHOOK_URI")
        }

}
