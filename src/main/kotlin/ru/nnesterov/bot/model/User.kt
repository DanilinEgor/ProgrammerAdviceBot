package ru.nnesterov.bot.model

import com.google.gson.annotations.SerializedName

class User {

    /**
     * @return Unique identifier for this user or bot
     */
    @SerializedName("id")
    var id: Int = 0

    /**
     * @return User‘s or bot’s first name
     */
    @SerializedName("first_name")
    var firstName: String = ""

    /**
     * *Optional.*

     * @return User‘s or bot’s last name
     */
    @SerializedName("last_name")
    var lastName: String = ""

    /**
     * *Optional.*

     * @return User‘s or bot’s username
     */
    @SerializedName("username")
    var username: String = ""

    /**
     * Parameterless constructor for gson.
     */
    constructor() {

    }

    constructor(id: Int, firstName: String, lastName: String, username: String) {
        this.id = id
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
    }

    override fun toString(): String {
        val sb = StringBuilder("User{")
        sb.append("id=").append(id)
        sb.append(", firstName='").append(firstName).append('\'')
        sb.append(", lastName='").append(lastName).append('\'')
        sb.append(", username='").append(username).append('\'')
        sb.append('}')
        return sb.toString()
    }
}