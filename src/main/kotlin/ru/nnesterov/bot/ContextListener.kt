package ru.nnesterov.bot

import ru.nnesterov.bot.api.TelegramApi
import java.util.*
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

class ContextListener : ServletContextListener {
    override fun contextInitialized(p0: ServletContextEvent?) {
        val context = p0?.servletContext
        val contextPath = context?.contextPath
        val botConfig = BotConfig("bot_config.properties")
        val telegramApi = TelegramApi(botConfig.token)
        telegramApi.setWebHook(botConfig.webHookUri)
    }

    override fun contextDestroyed(p0: ServletContextEvent?) {

    }
}
