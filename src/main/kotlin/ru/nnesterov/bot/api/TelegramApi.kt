package ru.nnesterov.bot.api

import com.google.appengine.api.urlfetch.HTTPResponse
import com.google.appengine.repackaged.com.google.protobuf.MapEntry
import sun.net.www.http.HttpClient
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder


class TelegramApi (private val token : String) {
    private val apiUrl = "https://api.telegram.org/bot"

    fun setWebHook(urlCallback : String) {
        val url = apiUrl + token + "/setWebHook"
        val (status, response) = Http.doGetRequest(url, mapOf("url" to urlCallback))
    }

    fun sendMessage(chat: String, text: String) {
        val url = apiUrl + token + "/sendMessage"
        val (status, response) = Http.doGetRequest(url, mapOf("chat_id" to chat, "text" to text))
    }
}


data class HttpResponse(val status: Int, val response :String)


private object Http {
    fun doPostRequest(urlPath: String, mimeType: String, body: String): HttpResponse {
        val url = URL(urlPath)
        val httpConnection = url.openConnection() as HttpURLConnection
        httpConnection.requestMethod = "POST"
        httpConnection.setRequestProperty("content-type", mimeType)
        httpConnection.doOutput = true;
        val outputStream = httpConnection.outputStream
        outputStream.write(body.toByteArray())
        outputStream.close()

        val reader = BufferedReader(InputStreamReader(httpConnection.inputStream))
        val response = reader.readText()
        reader.close()

        return HttpResponse(httpConnection.responseCode, response)
    }

    fun doGetRequest(urlPath: String, params: Map<String, String>) : HttpResponse {
        val resultUrlPath = (params.entries.fold(urlPath + "?") { path, entry -> path + entry.toParameter() + "&" })
        val url = URL(resultUrlPath)
        val httpConnection = url.openConnection() as HttpURLConnection
        httpConnection.requestMethod = "GET"
        httpConnection.doOutput = true;

        val reader = BufferedReader(InputStreamReader(httpConnection.inputStream))
        val response = reader.readText()
        reader.close()

        return HttpResponse(httpConnection.responseCode, response)
    }

    private fun Map.Entry<String, String>.toParameter() : String {
        return this.key + "=" + URLEncoder.encode(this.value, Charsets.UTF_8.displayName())
    }

}