package com.projects.trending.dicitionary.data.network

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization" , "Token 78bb251553954d4c34a988e991e28ed8a6be322f")
            .build()
            return chain.proceed(request)
    }
}