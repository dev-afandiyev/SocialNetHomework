package com.example.socialnethomework.data.be.login

import com.example.socialnethomework.model.UserModel

interface ILoginRepository {

    fun getByLogin(email: String?, pass: String?): UserModel?

}