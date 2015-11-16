package ru.nnesterov.bot.api

import com.google.appengine.repackaged.com.google.gson.Gson
import ru.nnesterov.bot.model.Advice
import java.net.URL

interface AdviceProvider {
    fun getNext() : String
}

class AdviceProviderHttp : AdviceProvider {
    override fun getNext() : String {
        val text : String = URL("http://fucking-great-advice.ru/api/random_by_tag/кодеру").readText();
        val gson = Gson();
        val advice : Advice = gson.fromJson<Advice>(text, Advice::class.java)
        return advice.text?.replace("&nbsp;", " ") ?: "some problem here"
    }
}
