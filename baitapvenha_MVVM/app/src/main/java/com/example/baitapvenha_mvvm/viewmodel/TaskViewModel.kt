package com.example.baitapvenha_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.example.baitapvenha_mvvm.data.FirebaseRepository
import com.example.baitapvenha_mvvm.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {
    private val repo = FirebaseRepository()

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        loadTasks()
    }

    private fun loadTasks() {
        repo.getTasks {
            _tasks.value = it
        }
    }

    fun addTask(title: String, description: String) {
        val task = Task(title = title, description = description)
        repo.addTask(task)
    }
}