package com.example.socialnethomework.data.be.regist

import com.example.socialnethomework.model.UserModel

interface IRegistrationRepository {

    fun insert(userModel: UserModel)

}