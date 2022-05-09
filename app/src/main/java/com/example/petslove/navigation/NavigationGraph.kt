package com.example.petslove.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petslove.presentation.HomeScreen
import com.example.ui_petList.ui.PetList


@Composable
fun NavigationGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = BottomNavItem.Home.screen_Route) {
        composable(BottomNavItem.Home.screen_Route) {

        }
        composable(BottomNavItem.NewAd.screen_Route) {

        }

    }
}