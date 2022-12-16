package com.projects.trending.dicitionary.data

import com.projects.trending.dicitionary.data.network.RetrofitInstance
import com.projects.trending.dicitionary.model.Definition
import com.projects.trending.dicitionary.model.dataModel
import retrofit2.Response

class MainRepository  {

    suspend fun getPost(): Response<dataModel> {
        return RetrofitInstance.api.getPost()
    }
}