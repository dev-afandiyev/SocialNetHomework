package com.example.socialnethomework.data.be.regist

import com.example.socialnethomework.db.IUserDao
import com.example.socialnethomework.model.UserModel
import javax.inject.Inject

class RegistrationRepository
@Inject constructor(private var userDao: IUserDao)
    : IRegistrationRepository {

    override fun insert(userModel: UserModel) {
        userDao.insert(userModel)
    }

}