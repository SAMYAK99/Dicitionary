package com.projects.trending.dicitionary.data.network

import com.projects.trending.dicitionary.model.Definition
import com.projects.trending.dicitionary.model.dataModel
import retrofit2.Response
import retrofit2.http.GET
import java.util.*

interface SimpleApi {

    @GET("bar")
    suspend fun getPost() : Response<dataModel>
}