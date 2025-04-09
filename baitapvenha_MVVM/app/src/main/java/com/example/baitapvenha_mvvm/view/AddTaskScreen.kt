package com.example.baitapvenha_mvvm.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.baitapvenha_mvvm.viewmodel.TaskViewModel

@Composable
fun AddTaskScreen(viewModel: TaskViewModel = viewModel(), onDone: () -> Unit) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(value = title, onValueChange = { title = it }, label = { Text("Task") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = desc, onValueChange = { desc = it }, label = { Text("Description") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.addTask(title, desc)
            onDone()
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Add")
        }
    }
}