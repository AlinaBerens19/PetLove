package com.example.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun CustomButtonUI(
    value: String,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Box(modifier = modifier
        .border(3.dp, Color.Gray)
        .background(color = colorResource(R.color.primary_buttons_color))) {
        Text(
            text = value,
            style = MaterialTheme.typography.body1.copy(color = Color.White),
            modifier = modifier

                .align(Alignment.Center)
                .clickable(onClick = {})
                .clip(RoundedCornerShape(4.dp))
                .padding(12.dp)
                .clickable {
                    onClick()
                },
            color = Color.White,
            fontWeight = FontWeight.Medium,

        )
    }
}