package com.example.ui_addNewAd.ui




import android.net.Uri
import android.util.Log
import android.widget.NumberPicker

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.components.DefaultScreenUI
import com.example.pet_domain.Pet
import com.example.petslove.ui_addNewAd.R
import com.example.ui_addNewAd.components.*
import com.skydoves.landscapist.glide.GlideImage
import java.util.stream.DoubleStream.builder
import java.util.stream.IntStream.builder

import kotlin.reflect.KFunction1




//TODO check duplicates
//TODO need dialog to show what when wrong during creating ad
//TODO optimise TextFields
//TODO add menu with kinds&breeds **in domain can be two sealed classes like matreshka with pet's breeds
//https://rrtutors.com/tutorials/How-do-u-create-Android-Dropdown-menu-with-jetpack-compose
//@Preview
@Composable
fun CreateNewAd(
    state: NewAdState,
    events: KFunction1<NewAdEvent, Unit>,
    navigateToListScreen: () -> Unit,
    viewModel: AddNewAdViewModel
) {

    val scrollState = rememberScrollState()

    val galleryLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()) {
        viewModel.state.value.uri = it
    }

    //to controll drop down menu
    var expanded1 = remember { mutableStateOf(false) }
    var selectedGender = remember { mutableStateOf(false)}

    DefaultScreenUI(
        progressBarState = state.progressBarState
    )
    {
        Column(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp)
                .verticalScroll(scrollState)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,

            ) {

            Text(
                text = "Create new ad",
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 30.dp),
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(20.dp))

                CustomTextField(
                    keyboardType = KeyboardType.Text,
                    label = "Your pet name",
                    value = viewModel.state.value.name
                ) { value ->
                    viewModel.state.value = viewModel.state.value.copy(name = value)
                }


            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                    keyboardType = KeyboardType.Text,
                    label = "Your name",
                    value = viewModel.state.value.ownerName
                ) { value ->
                    viewModel.state.value = viewModel.state.value.copy(ownerName = value)
                }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Choose your pet gender",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.align(CenterHorizontally),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "mail",
                    style = MaterialTheme.typography.subtitle2
                )

                Spacer(modifier = Modifier.width(10.dp))

                RadioButton(
                    selected = !selectedGender.value,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorResource(R.color.primary_buttons_color)
                    ),
                    onClick = {
                        //selectedGender.value = false
                        viewModel.state.value = viewModel.state.value.copy(sex = 1)
                    })
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "femail",
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.width(10.dp))
                RadioButton(
                    selected = selectedGender.value,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = colorResource(R.color.primary_buttons_color)
                    ),
                    onClick = {
                       // selectedGender.value = true
                        viewModel.state.value = viewModel.state.value.copy(sex = 0)
                    })
            }


            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.align(CenterHorizontally)) {

                Box(modifier = Modifier
                    .background(Color.White)
                    .border(3.dp, Color.DarkGray, RectangleShape)
                    .size(300.dp, 50.dp)
                    .align(CenterHorizontally)
                    .clickable {
                        expanded1.value = true
                    }) {
                    Row {
                        Text(
                            text = viewModel.state.value.breed,
                            modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        //TODO: Add arrowDown Icon. It's invisible
                        IconButton(
                            onClick = { expanded1.value = true }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow),
                                contentDescription = null // decorative element
                            )
                        }
                    }

                    CustomMenu(
                        value = expanded1.value,
                        onDismissRequest = { expanded1.value = false },
                        content = { CustomMenuContent(state = viewModel.state.value) },
                        //modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            var pickerValue by remember { mutableStateOf(0) }

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Choose your pet age")
            }
            //Spacer(modifier = Modifier.width(20.dp))
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {

                NumberPicker(
                    value = pickerValue,
                    range = 0..10,
                    onValueChange = {
                        pickerValue = it
                    },
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            CustomTextField(
                keyboardType = KeyboardType.Number,
                label = "Your phone",
                value = viewModel.state.value.phone.toString()
            ) { value ->
                viewModel.state.value = viewModel.state.value.copy(phone = value)
            }

            Spacer(modifier = Modifier.height(16.dp))


                CustomTextField(
                    keyboardType = KeyboardType.Email,
                    label = "Your email",
                    value = viewModel.state.value.email
                ) { value ->
                    viewModel.state.value = viewModel.state.value.copy(email = value)
                }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Upload pictures",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(4.dp))

            CustomButton(
                value = "From Gallery",
                modifier = Modifier.align(CenterHorizontally),
                onClick = {
                    galleryLauncher.launch("image/*")
                    Log.d("TAG", "Show uri: ${state.uri}",)
                })

            //TODO add fun giving access to gallery
            CustomButton(
                value = "Take Picture",
                modifier = Modifier.align(CenterHorizontally),
                onClick = {

                })
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    GlideImage(
                        imageModel = viewModel.state.value.uri,
                        modifier = Modifier
                            .size(130.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Choose your location",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))


                CustomTextField(
                    keyboardType = KeyboardType.Text,
                    label = "Your place",
                    value = viewModel.state.value.place
                ) { value ->
                    viewModel.state.value = viewModel.state.value.copy(place = value)
                }


            Spacer(modifier = Modifier.height(16.dp))

            Icon(
                modifier = Modifier
                    .align(CenterHorizontally)
                    .size(50.dp),
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Choose your pet breed"
            )

            Spacer(modifier = Modifier.height(20.dp))

            //TODO provide size with geometry reader
            CustomTextField(
                keyboardType = KeyboardType.Text,
                label = "Tell more about your pet",
                value = viewModel.state.value.info
            ) { value ->
                viewModel.state.value = viewModel.state.value.copy(info = value)
            }

            Spacer(modifier = Modifier.height(20.dp))

            CustomButton(
                value = "Let's continue",
                modifier = Modifier.align(CenterHorizontally),
                onClick = {
                    val pet = validateNewAd(
                        name = viewModel.state.value.name,
                        ownerName = viewModel.state.value.ownerName,
                        email = viewModel.state.value.email,
                        age = viewModel.state.value.age,
                        kind = viewModel.state.value.kind,
                        breed = viewModel.state.value.breed,
                        phone = viewModel.state.value.phone.toLong(),
                        place = viewModel.state.value.place,
                        info = viewModel.state.value.info,
                        sex = viewModel.state.value.sex,
                        image = viewModel.state.value.uri
                    )

                    if (pet != null) {
                        events(
                            NewAdEvent.InsertNewAdToCache(pet)
                        )
                        navigateToListScreen()
                    }
                })

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                value = "Show all pets",
                modifier = Modifier.align(CenterHorizontally),
                onClick = {
                    Log.w("TAG", "Show uri: ${viewModel.state}",)
                })

            Spacer(modifier = Modifier.height(100.dp))

            //TODO add gif pic with cats
        }
    }
}


//--------------------------------------------------------------------------------------------------



















