package com.example.petslove.navigation

import com.example.petslove.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_Route: String) {

    object Home: BottomNavItem("Home", R.drawable.ic_home, "home")
    object NewAd: BottomNavItem("NewAd", R.drawable.ic_post, "newAd")

}
