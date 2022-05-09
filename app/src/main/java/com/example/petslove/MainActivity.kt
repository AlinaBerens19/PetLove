package com.example.petslove




import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxWithConstraints

import androidx.compose.material.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.datastore.AWSDataStorePlugin

import com.amplifyframework.datastore.generated.model.Pet.builder
import com.amplifyframework.datastore.generated.model.PetModel
import com.example.pet_domain.Pet
import com.example.petslove.navigation.Screen
import com.example.petslove.ui.theme.PetsLoveTheme
import com.example.ui_addNewAd.ui.AddNewAdViewModel
import com.example.ui_addNewAd.ui.CreateNewAd
import com.example.ui_petDetail.ui.DetailPet
import com.example.ui_petDetail.ui.DetailPetViewModel
import com.example.ui_petList.ui.PetList
import com.example.ui_petList.ui.PetListViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    fun create() {
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)
            Log.i("Tutorial", "Initialized Amplify")
        } catch (failure: AmplifyException) {
            Log.e("Tutorial", "Could not initialize Amplify", failure)
        }
        Amplify.DataStore.observe(PetModel::class.java,
            { Log.i("Tutorial", "Observation began.") },
            { Log.i("Tutorial", it.item().toString()) },
            { Log.e("Tutorial", "Observation failed.", it) },
            { Log.i("Tutorial", "Observation complete.") }
        )
    }

    fun query() {
        Amplify.DataStore.query(
            PetModel::class.java,
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Queried item: " + item.name + item.id)
                }
            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )
    }

    suspend fun queryById(): PetModel = suspendCoroutine { cont ->
        Amplify.DataStore.query(
            PetModel::class.java,
            Where.id("811d7524-0403-4487-ba67-4eb0a587a517"),
            { items ->
                while (items.hasNext()) {
                    val item = items.next()
                    Log.i("Amplify", "Queried item: " + item.name + item.id)
                    cont.resume(item)
                }
            },
            { failure -> Log.e("Tutorial", "Could not query DataStore", failure) }
        )
    }

    suspend fun update() {
        val pet = withContext(CoroutineScope(IO).coroutineContext) {
            queryById()
        }
        val updatePet = pet.copyOfBuilder()
            .name(pet.name + " [UPDATED]")
            .build()

        Amplify.DataStore.save(
            updatePet,
            { success -> Log.i("Amplify", "Updated item: " + success.item().name) },
            { error -> Log.e("Amplify", "Could not save item to DataStore", error) }
        )
    }

    @OptIn(ExperimentalAnimationApi::class,
        androidx.compose.foundation.ExperimentalFoundationApi::class,
        androidx.compose.material.ExperimentalMaterialApi::class,
        kotlinx.coroutines.ExperimentalCoroutinesApi::class
    )
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        create()
        query()

        setContent {
            PetsLoveTheme {

            val navController = rememberAnimatedNavController()
            Surface {
                BoxWithConstraints {
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = Screen.PetList.route,
                        builder = {
                            addPetList(
                                width = constraints.maxWidth / 2,
                                navController = navController
                            )
                            addDetailPet(
                                width = constraints.maxWidth / 2,
                            )
                            addNewAd(
                                navController = navController,
                                width = constraints.maxWidth / 2,
                            )
                        })
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addDetailPet(
    width: Int
) {
    composable(
        route = Screen.DetailPet.route  + "/{petId}",
        arguments = Screen.DetailPet.argument,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },

    ) {
        val viewModel: DetailPetViewModel = hiltViewModel()
        DetailPet(state = viewModel.state.value)
    }

}


@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addPetList(
    navController: NavController,
    width: Int
    ) {
        composable(
            route = Screen.PetList.route,
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeOut(animationSpec = tween(300))
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -width },
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = FastOutSlowInEasing
                    )
                ) + fadeIn(animationSpec = tween(300))
            },
        ) {
            val viewModel: PetListViewModel = hiltViewModel()
            PetList(
                state = viewModel.state.value,
                //event = viewModel::onTriggerEvent,
                navigateToDetailScreen = { petId ->
                    Log.d("TAG", "addPetList: $petId")
                    navController.navigate("${Screen.DetailPet.route}/$petId")
                },
                navigateToAdScreen = {
                    Log.d("TAG", "ad screen")
                    navController.navigate(Screen.NewAd.route)
                },
                events = viewModel::onTriggerEvent,
            )
        }

}



@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addNewAd(
    navController: NavController,
    width: Int
) {
    composable(
        route = Screen.NewAd.route,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeOut(animationSpec = tween(300))
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -width },
                animationSpec = tween(
                    durationMillis = 300,
                    easing = FastOutSlowInEasing
                )
            ) + fadeIn(animationSpec = tween(300))
        },
    ) {
    val viewModel: AddNewAdViewModel = hiltViewModel()
        CreateNewAd(
            state = viewModel.state.value,
            events = viewModel::onTriggerEvent,
            navigateToListScreen = {
                Log.d("TAG", "ad screen")
                navController.navigate(Screen.PetList.route)
            },
            viewModel = viewModel
    )
    }

}





















