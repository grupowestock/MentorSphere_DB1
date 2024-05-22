package br.com.fiap.challenge.viewmodel

// UserViewModel.kt
//package br.com.fiap.challenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun updateName(newName: String) {
        _name.value = newName
    }
}


