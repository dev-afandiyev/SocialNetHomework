package com.example.socialnethomework.data.be

import com.example.socialnethomework.data.be.model.NewsRequest
import retrofit2.http.GET

interface BackendApi {

    /**
     * Get News requests
     *
     * */

    @GET("/posts")
    suspend fun getNews(): List<NewsRequest>

}