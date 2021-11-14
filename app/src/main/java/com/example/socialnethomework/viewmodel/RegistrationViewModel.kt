package com.example.socialnethomework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.socialnethomework.data.be.regist.RegistrationRepository
import com.example.socialnethomework.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel
@Inject constructor(private val repository: RegistrationRepository)
    : ViewModel() {

    val userState = MutableLiveData<UserModel>()

    fun insertParam(name: String, surname: String, email: String, password: String){
            repository.insert(UserModel(name, surname, email, password))
        }

}