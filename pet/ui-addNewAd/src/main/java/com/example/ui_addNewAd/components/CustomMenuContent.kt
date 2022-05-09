package com.example.ui_addNewAd.components

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petslove.ui_addNewAd.R
import com.example.ui_addNewAd.ui.NewAdState

val EMPTY_IMAGE_URI: Uri = Uri.parse("file://dev/null")
val items = listOf("Cat", "Dog", "Horse", "Bird", "Other")
val itemsCatBreed = listOf("persian", "angora", "british", "maine coon", "other")
val itemsDogBreed = listOf("afador", "akita", "bulldog", "retriver", "shitzu")
val itemsHorseBreed = listOf("arabian horse", "colorado Ranger", "boerperd", "campolina", "azteca horse")
val itemsBirdBreed = listOf("parrot", "other",)
val itemsOtherBreed = listOf("other",)

//@Preview
@Composable
fun CustomMenuContent(
    state: NewAdState,
)
{
    Column {
        Text(
            text = "Kind of pet:",
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 10.dp, start = 5.dp, end = 5.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            color = colorResource(R.color.primary_buttons_color))

        PetKindItem(
            id = R.drawable.horse,
            description = "Horse",
            breeds = itemsHorseBreed,
            state = state)

        PetKindItem(
            id = R.drawable.dog,
            description = "Dog",
            breeds = itemsDogBreed,
            state = state)

        PetKindItem(
            id = R.drawable.cat,
            description = "Cat",
            breeds = itemsCatBreed,
            state = state)

        PetKindItem(
            id = R.drawable.bird,
            description = "Bird",
            breeds = itemsBirdBreed,
            state = state)

        PetKindItem(
            id = R.drawable.others,
            description = "Others",
            breeds = itemsOtherBreed,
            state = state)
    }
    
}

//TODO align items in row by centers
@Composable
fun PetKindItem(
    id: Int,
    description: String,
    breeds: List<String>,
    state: NewAdState,
) {
    var expanded = remember { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 20.dp)
                .clickable {
                    expanded.value = true
                    state.kind = description
                },
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painter = painterResource(id = id),
                contentDescription = description,
                tint = colorResource(R.color.primary_buttons_color),
                modifier = Modifier
                    .size(30.dp)
                    .padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.width(25.dp))
            Text(
                text = description,
                color = Color.DarkGray,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(end = 10.dp)
            )
        }
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier.align(Alignment.End)) {
            breeds.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    state.breed = breeds[index]
                    expanded.value = false
                }) {
                    Text(text = s)
                }
            }
        }
    }
}
