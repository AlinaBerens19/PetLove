package com.example.ui_petList.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.components.CustomButtonUI
import com.example.components.DefaultScreenUI
import com.example.components.R
import com.example.core.domain.UIComponentState
import com.example.ui_petList.components.PetListFilter
import com.example.ui_petList.components.PetListItem
import com.example.ui_petList.components.SearchToolbar


//@Preview
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PetList(
    state: PetListState,
    events: (ListStateEvent) -> Unit,
    navigateToDetailScreen: (String) -> Unit,
    navigateToAdScreen: () -> Unit,
) {

    DefaultScreenUI(
        progressBarState = state.progressBarState
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(bottom = 10.dp)
        ) {
            //Sign in/out toolbar --------------------------------------
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            ) {
                Text(text = "Hello")
                //Spacer(modifier = Modifier.width(250.dp))
                IconButton(
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = { navigateToAdScreen() }) {
                    Icon(Icons.TwoTone.Add, "Add new ad")
                }
            }


            //Search in/out toolbar --------------------------------------
            SearchToolbar(
                state.petName,
                onPetNameChange = { petName ->
                    events(ListStateEvent.UpdatePetName(petName))
                    Log.d("Found", "Pet: $petName")
                },
                onExecuteSearch = {
                    events(ListStateEvent.FilteredPets)
                },
                onShowFilterDialog = {
                    events(ListStateEvent.UpdateFilterDialogState(UIComponentState.Show))
                }
            )

            Spacer(Modifier.height(20.dp))

            //Header --------------------------------------
            Text(
                text = "Looking for soulmate:",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(CenterHorizontally),
                color = Color.Gray
            )

            //List of items --------------------------------------


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(state.filteredPets) {
                    PetListItem(
                        id = com.example.petslove.ui_petList.R.drawable.bulldog,
                        name = it.name,
                        breed = it.breed,
                        image = it.image,
                        likes = it.likes,
                        id_ = it.id,
                        onDetailScreenNavigate = { petId ->
                            navigateToDetailScreen(petId)
                        }
                    )
                }
            }
            //ShowMore --------------------------------------
            CustomButtonUI(
                modifier = Modifier.align(Alignment.End),
                value = "Show more",
                onClick = { navigateToAdScreen() },
            )

            if (state.filterDialogState is UIComponentState.Show) {
                PetListFilter(
                    petFilter = state.petFilter,
                    onUpdatePetFilter = { petFilter ->
                        events(ListStateEvent.UpdatePetFilter(petFilter))
                    },
                    onCloseDialog = {
                        events(ListStateEvent.UpdateFilterDialogState(UIComponentState.Hide))
                    },
                    onUpdatePetKind = {
                        events(ListStateEvent.UpdateFilterKindsAttributeState(it))
                    },
                    petBreeds = state.primaryAttributeKinds,
                    petGender = state.primaryAttributeGender,
                    onUpdatePetGender = {
                        events(ListStateEvent.UpdateFilterGenderAttributeState(it))
                    },
                    onUpdatePetBreed = {
                        events(ListStateEvent.UpdateFilterBreedsAttributeState(it))
                    }
                )
            }
        }
    }
}