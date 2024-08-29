package com.reivai.userlist.service

import com.reivai.userlist.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("getData/test")
    suspend fun getUserList(): List<User>
}