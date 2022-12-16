package com.projects.trending.dicitionary.model


import com.google.gson.annotations.SerializedName

data class Definition(
    @SerializedName("definition")
    val definition: String,
    @SerializedName("emoji")
    val emoji: Any,
    @SerializedName("example")
    val example: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("type")
    val type: String
)