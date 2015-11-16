package ru.nnesterov.bot.model

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Advice {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("sound")
    @Expose
    var sound: String? = null

    @SerializedName("text")
    @Expose
    var text: String? = null
}
