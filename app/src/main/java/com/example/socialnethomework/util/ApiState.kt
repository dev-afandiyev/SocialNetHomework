package com.example.socialnethomework.util

import com.example.socialnethomework.data.be.model.NewsRequest

sealed class ApiState{
    object Loading : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    class Success(val data: List<NewsRequest>) : ApiState()
    object Empty : ApiState()
}