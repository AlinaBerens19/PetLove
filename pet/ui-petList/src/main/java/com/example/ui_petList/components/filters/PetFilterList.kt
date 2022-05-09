package com.example.ui_petList.components


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pet_domain.*
import com.example.ui_petList.components.filters.EmptyRow
import com.example.ui_petList.components.filters.PetFilterSelector


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PetListFilter(
    petFilter: PetFilter,
    petBreeds: PetKinds,
    petGender: PetGender,
    catBreed: CatBreeds? = null,
    dogBreed: DogBreeds? = null,
    horseBreeds: HorseBreeds? = null,
    onUpdatePetFilter: (PetFilter) -> Unit,
    onUpdatePetKind: (PetKinds) -> Unit,
    onUpdatePetBreed: (String) -> Unit,
    onUpdatePetGender: (PetGender) -> Unit,
    onCloseDialog: () -> Unit,

    ) {
    var isExpanded by remember {
        mutableStateOf(true)
    }

    var isExpandedBreed by remember {
        mutableStateOf(false)
    }

    AlertDialog(
        modifier = Modifier.padding(16.dp),
        onDismissRequest = {
            onCloseDialog()
        },
        title = {
            Text(
                text = "Filter",
                style = MaterialTheme.typography.h5)
        },
        text = {
            LazyColumn {
                item {
                    Column(modifier = Modifier
                        .fillMaxWidth()) {

                        EmptyRow()

                        PetFilterSelector(
                            filterOnPet = {
                                onUpdatePetFilter(PetFilter.Kind())
                                isExpanded = true
                            },
                            isEnabled = petFilter is PetFilter.Kind,
                            text = PetFilter.Kind().uiValue,

                            )

                        if(isExpanded) {
                            FilterSelector(
                                isEnabled = petFilter is PetFilter.Kind && petBreeds is PetKinds.Cat,
                                text = PetKind.Cat.uiValue,
                                onUpdate = {
                                    onUpdatePetKind(PetKinds.Cat())
                                }
                            )
                            //}
                            FilterSelector(
                                isEnabled = petFilter is PetFilter.Kind && petBreeds is PetKinds.Dog,
                                text = PetKind.Dog.uiValue,
                                onUpdate = {
                                    onUpdatePetKind(PetKinds.Dog())
                                }
                            )
                            FilterSelector(
                                isEnabled = petFilter is PetFilter.Kind && petBreeds is PetKinds.Horse,
                                text = PetKind.Horse.uiValue,
                                onUpdate = {
                                    onUpdatePetKind(PetKinds.Horse())
                                }
                            )
                        }

                        //Pet Breeds filter
                        PetFilterSelector(
                            filterOnPet = {
                                onUpdatePetFilter(PetFilter.Breed())
                                isExpanded = false
                                isExpandedBreed = true
                            },
                            isEnabled = petFilter is PetFilter.Breed,
                            text = PetFilter.Breed().uiValue,
                        )

                        if(isExpandedBreed) {
                            if(petBreeds is PetKinds.Cat) {
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && catBreed is CatBreeds.Persian,
                                    text = CatBreeds.Persian.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(CatBreeds.Persian.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && catBreed is CatBreeds.British,
                                    text = CatBreeds.British.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(CatBreeds.British.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && catBreed is CatBreeds.MaineCoon,
                                    text = CatBreeds.MaineCoon.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(CatBreeds.MaineCoon.uiValue)
                                    }
                                )

                            }
                            else if (petBreeds is PetKinds.Dog) {
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && dogBreed is DogBreeds.Akita,
                                    text = DogBreeds.Akita.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(DogBreeds.Akita.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && dogBreed is DogBreeds.Bulldog,
                                    text = DogBreeds.Bulldog.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(DogBreeds.Bulldog.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && dogBreed is DogBreeds.Collie,
                                    text = DogBreeds.Collie.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(DogBreeds.Collie.uiValue)
                                    }
                                )
                            }
                            else if (petBreeds is PetKinds.Horse) {
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && horseBreeds is HorseBreeds.ArabianHorse,
                                    text = HorseBreeds.ArabianHorse.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(HorseBreeds.ArabianHorse.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && horseBreeds is HorseBreeds.Morgan,
                                    text = HorseBreeds.Morgan.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(HorseBreeds.Morgan.uiValue)
                                    }
                                )
                                FilterSelector(
                                    isEnabled = petFilter is PetFilter.Breed && horseBreeds is HorseBreeds.Ponies,
                                    text = HorseBreeds.Ponies.uiValue,
                                    onUpdate = {
                                        onUpdatePetBreed(HorseBreeds.Ponies.uiValue)
                                    }
                                )
                            }
                        }

                        //Pet gender filter
                        PetFilterSelector(
                            filterOnPet = {
                                onUpdatePetFilter(PetFilter.Gender())
                                isExpanded = false
                                isExpandedBreed = false
                            },
                            isEnabled = petFilter is PetFilter.Gender,
                            text = PetFilter.Gender().uiValue,

                            )

                        //pet gender checkboxes
                        FilterSelector(
                            isEnabled = petFilter is PetFilter.Gender && petGender is PetGender.Mail,
                            text = PetGender.Mail.value,
                            onUpdate = {
                                onUpdatePetGender(PetGender.Mail)
                            }
                        )

                        FilterSelector(
                            isEnabled = petFilter is PetFilter.Gender && petGender is PetGender.Femail,
                            text = PetGender.Femail.value,
                            onUpdate = {
                                onUpdatePetGender(PetGender.Femail)
                            }
                        )
                    }
                }
            }
        },
        buttons = {
            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {
                            onCloseDialog()
                        }
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(10.dp),
                        imageVector = Icons.Default.Check,
                        contentDescription = "Done",
                        tint = Color(0xFF009a34)
                    )
                }
            }
        }
    )
}















