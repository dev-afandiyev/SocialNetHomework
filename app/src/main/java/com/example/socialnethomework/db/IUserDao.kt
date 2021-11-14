package com.example.socialnethomework.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.socialnethomework.model.UserModel

@Dao
interface IUserDao {

    @Query("SELECT * FROM usermodel")
    fun getAllItem(): LiveData<UserModel?>?

    @Query("SELECT * FROM usermodel where email = :email and password = :pass")
    fun getByLogin(email: String?, pass: String?): UserModel?

    @Insert
    fun insert(usersModel: UserModel?)

}