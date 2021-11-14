package com.example.socialnethomework.data.be.profile

import androidx.lifecycle.LiveData
import com.example.socialnethomework.data.be.model.NewsRequest
import com.example.socialnethomework.data.be.provider.BackendProvider
import com.example.socialnethomework.db.IUserDao
import com.example.socialnethomework.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProfileRepository
@Inject constructor(private var userDao: IUserDao,
                    private val backendProvider: BackendProvider
) : IProfileRepository {

    override fun getAllItem(): LiveData<UserModel?>? {
        return userDao.getAllItem()
    }

    override fun getNews(): Flow<List<NewsRequest>> = flow {
        emit(backendProvider.getNews())
    }.flowOn(Dispatchers.IO)


}