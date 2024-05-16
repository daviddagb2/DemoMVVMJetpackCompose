package com.gonzalez.blanchard.demomvvm.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gonzalez.blanchard.demomvvm.viewmodels.TaskViewModel

@Composable
fun MainScreen(
    taskViewModel: TaskViewModel = viewModel()
){
    val tasks by taskViewModel.tasks.collectAsState()
    var newTask by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(top = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(value = newTask,
            onValueChange = {
               newTask = it
            },
            label = {
                Text(text = "Agregar nueva tarea")
            }
        )

        Button(onClick = {
            taskViewModel.addTask(newTask)
            newTask = ""
        }) {
            Text(text = "Agregar")
        }

        LazyColumn {
            items(tasks){task ->
                Text(text = task)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen(){
    MainScreen()
}