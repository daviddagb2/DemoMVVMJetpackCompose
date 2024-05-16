package com.gonzalez.blanchard.demomvvm.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<String>>(emptyList())
    val tasks = _tasks.asStateFlow()

    fun addTask(task: String){
        viewModelScope.launch {
            _tasks.value += task
        }
    }

}