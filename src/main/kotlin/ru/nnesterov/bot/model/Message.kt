package ru.nnesterov.bot.model

import com.google.gson.annotations.SerializedName

class Message {

    /**
     * @return Unique message identifier
     */
    @SerializedName("message_id")
    val messageId: Int = 0

    /**
     * @return Sender
     */
    @SerializedName("from")
    val from: User? = null

    /**
     * @return Date the message was sent in Unix time
     */
    @SerializedName("date")
    val date: Int = 0

    /**
     * @return Conversation the message belongs to — [User] in case of a private message, [GroupChat] in case of a group
     */
    @SerializedName("chat")
    val chat: Chat? = null

    /**
     * *Optional.*

     * @return For text messages, the actual UTF-8 text of the message
     */
    @SerializedName("text")
    val text: String? = null

}