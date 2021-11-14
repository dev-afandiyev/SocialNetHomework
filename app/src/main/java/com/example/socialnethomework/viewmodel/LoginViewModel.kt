package com.example.socialnethomework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialnethomework.data.be.login.LoginRepository
import com.example.socialnethomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor(private val repository: LoginRepository)
    : ViewModel() {

    val logPassState = MutableLiveData<UserModel>()

    fun getByLogin(email: String?, pass: String?): UserModel? {
        return repository.getByLogin(email, pass)
    }

}