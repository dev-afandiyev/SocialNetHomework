package com.example.socialnethomework.domain

import androidx.lifecycle.LiveData
import com.example.socialnethomework.data.be.model.NewsRequest
import com.example.socialnethomework.data.be.profile.ProfileRepository
import com.example.socialnethomework.model.UserModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProfileInteractor @Inject constructor(
    private val repository: ProfileRepository
) {

    fun getAllItem(): LiveData<UserModel?>? {
        return repository.getAllItem()
    }

    fun getNews() : Flow<List<NewsRequest>> {
        return repository.getNews()
    }

}