package com.reivai.userlist.usecase

import com.reivai.userlist.model.User
import com.reivai.userlist.repository.UserRepository

class GetUserListUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(): List<User> = userRepository.getUserList()
}