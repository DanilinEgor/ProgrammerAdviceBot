package ru.nnesterov.bot

import com.google.appengine.repackaged.com.google.gson.Gson
import ru.nnesterov.bot.api.AdviceProviderHttp
import ru.nnesterov.bot.logic.BotBehaviour
import ru.nnesterov.bot.api.TelegramApi
import ru.nnesterov.bot.model.Update
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class BotServlet : HttpServlet() {
    // TODO: Add DI
    private val adviceProvider = AdviceProviderHttp()
    private val botBehaviour = BotBehaviour(adviceProvider)
    private val telegramApi = TelegramApi(BotConfig("bot_config.properties").token)



    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) : Unit {
        val text = adviceProvider.getNext()
        resp?.contentType = "text/plain"
        resp?.setStatus(200)
        resp?.characterEncoding = Charsets.UTF_8.displayName()
        resp?.writer?.print(text)
    }



    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val inputStream = req?.inputStream ?: return
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val requestText = bufferedReader.readText()



        val update = Gson().fromJson(requestText, Update::class.java)
        val text = update.message?.text ?: ""
        val chat : String = update.message?.chat?.id?.toString() ?: ""

        val answer : String = botBehaviour.getAsnwer(text) ?: return

        telegramApi.sendMessage(chat, answer)

        resp?.setStatus(200)
    }
}