package ru.nnesterov.bot.model

import com.google.gson.annotations.SerializedName

class Update {

    /**
     * @return The update‘s unique identifier.
     * * Update identifiers start from a certain positive number and increase sequentially.
     * * This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order.
     */
    @SerializedName("update_id")
    val updateId: Int = 0

    /**
     * *Optional.*

     * @return New incoming message of any kind — text, photo, sticker, etc.
     */
    @SerializedName("message")
    val message: Message? = null
}
