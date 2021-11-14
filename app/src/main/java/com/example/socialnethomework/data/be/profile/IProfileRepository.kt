package com.example.socialnethomework.data.be.profile

import androidx.lifecycle.LiveData
import com.example.socialnethomework.data.be.model.NewsRequest
import com.example.socialnethomework.model.UserModel
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface IProfileRepository {

    fun getAllItem(): LiveData<UserModel?>?

    fun getNews() : Flow<List<NewsRequest>>

}