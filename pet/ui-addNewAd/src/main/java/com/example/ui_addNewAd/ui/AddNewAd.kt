package com.example.ui_addNewAd.ui

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import java.lang.reflect.Modifier


@Composable
fun AddNewAd(
    viewModel: AddNewAdViewModel
) {

    val focusManager = LocalFocusManager.current

    viewModel.state.value.name?.let {
        AppTextField(
        text = it,
        placeholder = "Your pet name",
        onChange = {
            viewModel.state.value.name = it
        },
        imeAction = ImeAction.Next,
        keyboardType = KeyboardType.Text,
        keyBoardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        )
        )
     }

    viewModel.state.value.ownerName?.let {
        AppTextField(
            text = it,
            placeholder = "Your name",
            onChange = {
                viewModel.state.value.ownerName = it
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            )
        )
    }

    viewModel.state.value.phone?.let { number ->
        AppTextField(
            text = number.toString(),
            placeholder = "Your phone number",
            onChange = {
                viewModel.state.value.phone = number
            },
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone,
            keyBoardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            leadingIcon = {
                viewModel.state.value.phone.let {

                }
            },

        )
    }


}