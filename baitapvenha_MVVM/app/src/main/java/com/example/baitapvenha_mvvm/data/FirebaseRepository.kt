package com.example.baitapvenha_mvvm.data

import com.google.firebase.database.*
class FirebaseRepository {
    private val dbRef: DatabaseReference = FirebaseDatabase.getInstance().getReference("tasks")

    fun addTask(task: Task) {
        val id = dbRef.push().key ?: return
        task.id = id
        dbRef.child(id).setValue(task)
    }

    fun getTasks(callback: (List<Task>) -> Unit) {
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val taskList = mutableListOf<Task>()
                for (taskSnap in snapshot.children) {
                    val task = taskSnap.getValue(Task::class.java)
                    task?.let { taskList.add(it) }
                }
                callback(taskList)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}