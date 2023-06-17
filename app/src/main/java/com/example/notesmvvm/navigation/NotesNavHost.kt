package com.example.notesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notesmvvm.MainViewModel
import com.example.notesmvvm.Screens.AddScreen
import com.example.notesmvvm.Screens.MainScreen
import com.example.notesmvvm.Screens.NoteScreen
import com.example.notesmvvm.Screens.StartScreen

sealed class NavRoute(val route: String){
    object Start: NavRoute(com.example.notesmvvm.utils.Constants.Screens.START_SCREEN)
    object Main: NavRoute(com.example.notesmvvm.utils.Constants.Screens.MAIN_SCREEN)
    object Add: NavRoute(com.example.notesmvvm.utils.Constants.Screens.ADD_SCREEN)
    object Note: NavRoute(com.example.notesmvvm.utils.Constants.Screens.NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel, navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel)}
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${com.example.notesmvvm.utils.Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(com.example.notesmvvm.utils.Constants.Keys.ID)) }
    }
}