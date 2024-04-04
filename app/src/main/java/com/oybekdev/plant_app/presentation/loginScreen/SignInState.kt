package com.oybekdev.plant_app.presentation.loginScreen

data class SignInState(
    val isLoading:Boolean = false,
    val isSuccess: String = "",
    val isError:String? = ""
)
