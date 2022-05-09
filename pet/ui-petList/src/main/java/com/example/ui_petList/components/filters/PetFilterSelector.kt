package com.example.ui_petList.components.filters

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PetFilterSelector(
    filterOnPet: () -> Unit,
    isEnabled: Boolean,
    text: String,

    ) {

    Column(modifier = Modifier
        .fillMaxWidth()
        //.verticalScroll(rememberScrollState())
    ) {
        RowWithCheckbox(
            filterOnPet = {
                filterOnPet()
            },
            isEnabled = isEnabled,
            text = text,
        )
    }
}


@Composable
fun RowWithCheckbox(
    filterOnPet: () -> Unit,
    isEnabled: Boolean,
    text: String
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 12.dp)
        .clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            enabled = true,
            onClick = {
                filterOnPet()
            }
        )
    ) {
        Checkbox(
            modifier = Modifier
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically),
            checked = isEnabled,
            onCheckedChange = {
                filterOnPet()
            },
            colors = CheckboxDefaults.colors(MaterialTheme.colors.primary))

        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = text,
            style = MaterialTheme.typography.h6)
    }
}
