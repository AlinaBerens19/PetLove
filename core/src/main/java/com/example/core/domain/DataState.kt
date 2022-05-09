package com.example.core.domain

import javax.swing.plaf.ProgressBarUI


sealed class DataState<T> {

    //Add some component with title and description - data class
    data class Response<T>(
        val uiComponent: UIComponent
    ): DataState<T>()

    data class Data<T>(
        val data: T? = null
    ): DataState<T>()

    data class Loading<T>(
        val progressBarState: ProgressBarState = ProgressBarState.Idle
    ): DataState<T>()


}
