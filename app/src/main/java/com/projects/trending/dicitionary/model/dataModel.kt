package com.projects.trending.dicitionary.model


import com.google.gson.annotations.SerializedName

data class dataModel(
    @SerializedName("definitions")
    val definitions: ArrayList<Definition>,
    @SerializedName("pronunciation")
    val pronunciation: String,
    @SerializedName("word")
    val word: String
)