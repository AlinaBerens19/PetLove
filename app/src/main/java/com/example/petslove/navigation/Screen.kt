package com.example.petslove.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class Screen(
    val route: String,
    val argument: List<NamedNavArgument>
)
{
    object PetList: Screen(
        route = "petList",
        argument = emptyList()
    )

    object NewAd: Screen(
        route = "newAd",
        argument = emptyList()
    )

    object DetailPet: Screen(
        route = "detailPet",
        argument = listOf(
            navArgument("petId") {
                type = NavType.StringType
            }
        )
    )

}
