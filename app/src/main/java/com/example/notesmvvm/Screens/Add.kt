package com.example.notesmvvm.Screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesmvvm.MainViewModel
import com.example.notesmvvm.MainViewModelFactory
import com.example.notesmvvm.navigation.NavRoute
import com.example.notesmvvm.ui.theme.NotesMVVMTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController, viewModel: MainViewModel) {
    var title by remember { mutableStateOf("")}
    var subtitle by remember { mutableStateOf("")}
    var isButtonEnabled by remember { mutableStateOf(false)}
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = com.example.notesmvvm.utils.Constants.Keys.ADD_NEW_NOTE,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(
                value = title,
                onValueChange = {
                        title = it
                        isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                    },
                label = { Text(text = com.example.notesmvvm.utils.Constants.Keys.NOTE_TITLE) },
                isError = title.isEmpty()
            )
            OutlinedTextField(
                value = subtitle,
                onValueChange = {
                        subtitle = it
                        isButtonEnabled = title.isNotEmpty() && subtitle.isNotEmpty()
                    },
                label = { Text(text = com.example.notesmvvm.utils.Constants.Keys.NOTE_SUBTITLE) },
                isError = subtitle.isEmpty()
            )
            Button(
                modifier = Modifier.padding(top = 16.dp),
                enabled = isButtonEnabled,
                onClick = {
                    viewModel.addNote(note = com.example.notesmvvm.model.Note(title = title,  subtitle = subtitle)){
                        navController.navigate(NavRoute.Main.route)
                    }
                }
            ) {
                Text(text = com.example.notesmvvm.utils.Constants.Keys.ADD_NOTE)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun prevAddScreen(){
    NotesMVVMTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        AddScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}