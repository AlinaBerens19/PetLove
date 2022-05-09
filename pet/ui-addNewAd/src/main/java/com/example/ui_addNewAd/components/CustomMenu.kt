package com.example.ui_addNewAd.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.petslove.ui_addNewAd.R


@Composable
fun CustomMenu(
    value: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
   // modifier: Modifier
) {
    DropdownMenu(
        expanded = value,
        onDismissRequest = onDismissRequest,
        modifier = Modifier
            .background(Color.White)
            .shadow(elevation = 2.dp)
            .border(3.dp, colorResource(R.color.primary_buttons_color), RectangleShape)
            .width(150.dp),
        content = content
    )
}
















