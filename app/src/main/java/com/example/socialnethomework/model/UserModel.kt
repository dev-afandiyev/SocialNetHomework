package com.example.socialnethomework.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
   var name: String? = null,
   val surname: String? = null,
   val email: String? = null,
   val password: String? = null
){ @PrimaryKey(autoGenerate = true)
   var id: Long = 0 }