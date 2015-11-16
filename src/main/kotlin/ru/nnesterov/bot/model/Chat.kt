package ru.nnesterov.bot.model

import com.google.gson.annotations.SerializedName

/**
 * Represents a chat.
 * This might be a chat with a [User] or a [GroupChat]
 */
class Chat {

    /**
     * @return Unique identifier for this chat
     */
    @SerializedName("id")
    val id: Int = 0

    @SerializedName("first_name")
    private val firstName: String? = null

    @SerializedName("last_name")
    private val lastName: String? = null

    @SerializedName("username")
    private val username: String? = null

    @SerializedName("title")
    private val title: String? = null

    /**
     * @return Whether this is a chat with a [User]
     */
    val isUser: Boolean
        get() = title == null

    /**
     * @return Whether this is a [GroupChat]
     */
    val isGroupChat: Boolean
        get() = !isUser
}