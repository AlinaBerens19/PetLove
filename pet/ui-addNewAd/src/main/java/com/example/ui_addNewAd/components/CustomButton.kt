package com.example.ui_addNewAd.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun CustomButton(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Text(
        text = value,
        style = MaterialTheme.typography.body1.copy(color = Color.White),
        modifier = modifier
            .padding(12.dp)
            .clickable(onClick = {})
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color.DarkGray)
            .padding(12.dp)
            .clickable {
                onClick()
            }
    )
}