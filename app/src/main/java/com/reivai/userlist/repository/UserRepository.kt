package com.reivai.userlist.repository

import com.reivai.userlist.model.User
import com.reivai.userlist.service.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun getUserList(): List<User> = apiService.getUserList()
}