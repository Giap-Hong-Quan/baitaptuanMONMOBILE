package com.example.appname.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appname.data.Task
import com.example.appname.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Danh sách công việc", fontSize = 20.sp, modifier = Modifier.padding(8.dp))

        if (error != null) {
            Text(
                text = error ?: "Lỗi không xác định",
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        } else if (tasks.isEmpty()) {
            Text(
                text = "Không có công việc nào!",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 18.sp
            )
        } else {
            LazyColumn {
                items(tasks) { task ->
                    TaskItem(task)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    val backgroundColor = when (task.priority) {
        "High" -> Color.Red.copy(alpha = 0.3f)
        "Medium" -> Color.Yellow.copy(alpha = 0.3f)
        else -> Color.Blue.copy(alpha = 0.3f)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(backgroundColor)
                .padding(16.dp)
        ) {
            Text(text = task.title, fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
            Text(text = task.description, fontSize = 14.sp)
            Text(text = "Trạng thái: ${task.status}", fontSize = 12.sp, color = Color.Gray)
            Text(text = "Hạn chót: ${task.dueDate}", fontSize = 12.sp, color = Color.Gray)
        }
    }
}
