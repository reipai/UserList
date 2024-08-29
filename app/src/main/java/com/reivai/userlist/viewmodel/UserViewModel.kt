package com.reivai.userlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reivai.userlist.model.User
import com.reivai.userlist.repository.UserRepository
import com.reivai.userlist.service.RetrofitInstance
import com.reivai.userlist.usecase.GetUserListUseCase
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository(RetrofitInstance.apiService)
    private val getUserListUseCase = GetUserListUseCase(userRepository)

    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> get() = _userList

    init {
        viewModelScope.launch {
            _userList.value = getUserListUseCase()
        }
    }
}