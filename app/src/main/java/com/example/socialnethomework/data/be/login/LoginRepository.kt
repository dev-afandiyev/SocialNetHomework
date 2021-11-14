package com.example.socialnethomework.data.be.login

import com.example.socialnethomework.db.IUserDao
import com.example.socialnethomework.model.UserModel
import javax.inject.Inject

class LoginRepository @Inject constructor(private var userDao: IUserDao) : ILoginRepository {

    override fun getByLogin(email: String?, pass: String?): UserModel? {
        return userDao.getByLogin(email, pass)
    }

}