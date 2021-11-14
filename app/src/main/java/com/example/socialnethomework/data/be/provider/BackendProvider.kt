package com.example.socialnethomework.data.be.provider

import com.example.socialnethomework.data.be.BackendApi
import com.example.socialnethomework.data.be.model.NewsRequest
import javax.inject.Inject

class BackendProvider @Inject constructor(private val backendApi: BackendApi) {

    suspend fun getNews():List<NewsRequest> = backendApi.getNews()

}