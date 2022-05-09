package com.example.ui_petDetail.ui

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.components.DefaultScreenUI
import com.example.petslove.ui_petDetail.R
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun DetailPet(
    state: DetailPetState,
) {

    state.pet.let {
        LazyColumn() {
            item {
                Column(modifier = Modifier.fillMaxSize()) {
                    if(state.pet?.image != null) {
                        GlideImage(
                            imageModel = Uri.parse(it!!.image),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentScale = ContentScale.Crop,
                        )
                    }
                    else {
                        Image(
                            painter = painterResource(R.drawable.pet),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentScale = ContentScale.Crop,
                            contentDescription = null // decorative element
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {

                    Row {
                        if (it != null) {
                            Text(
                                text = it.name,
                                modifier = Modifier.align(Alignment.CenterVertically),
                                style = MaterialTheme.typography.h5
                            )
                            //TODO need interactor for control likes. After the person log in. Add state
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    Icons.Filled.Favorite,
                                    contentDescription = "Like",
                                    tint = Color.LightGray,
                                    modifier = Modifier.size(30.dp)
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Column(modifier = Modifier.align(Alignment.Start)) {

                        DefaultRow(state = state, text = "Age", description = it!!.age.toString())

                        Spacer(modifier = Modifier.height(16.dp))

                        DefaultRow(state = state, text = "Breed", description = it.breed)

                        Spacer(modifier = Modifier.height(16.dp))

                        DefaultRow(state = state, text = "My mom's/daddy's calls", description = it.ownerName)

                        Spacer(modifier = Modifier.height(16.dp))

                        DefaultRow(state = state, text = "Contact my mom/daddy", description = it.ownerPhone.toString())

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        if (it != null) {
                            Text(
                                text = it.aboutPetInfo,
                                style = MaterialTheme.typography.body1
                                )
                            }
                        }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        if (it != null) {
                            Text(
                                text = "I have ${ it.likes.toString()} likes",
                                style = MaterialTheme.typography.h6
                            )
                        }
                    }

                    }
                }
            }
        }
    }


@Composable
fun DefaultRow(
    state: DetailPetState,
    description: String,
    text: String) {
    Row() {
        if (state.pet != null) {
            Text(
                text = text,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 36.dp),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = description,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.body1
            )

        }
    }
}