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
import com.example.notesmvvm.utils.Constants

sealed class NavRoute(val route: String){
    object Start: NavRoute(Constants.Screens.START_SCREEN)
    object Main: NavRoute(Constants.Screens.MAIN_SCREEN)
    object Add: NavRoute(Constants.Screens.ADD_SCREEN)
    object Note: NavRoute(Constants.Screens.NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mViewModel: MainViewModel, navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavRoute.Start.route){
        composable(NavRoute.Start.route) { StartScreen(navController = navController, viewModel = mViewModel)}
        composable(NavRoute.Main.route) { MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.route) { AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.route + "/{${Constants.Keys.ID}}") { backStackEntry ->
            NoteScreen(navController = navController, viewModel = mViewModel, noteId = backStackEntry.arguments?.getString(Constants.Keys.ID)) }
    }
}