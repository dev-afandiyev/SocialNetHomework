package com.example.socialnethomework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.socialnethomework.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun usersDao(): IUserDao?
}