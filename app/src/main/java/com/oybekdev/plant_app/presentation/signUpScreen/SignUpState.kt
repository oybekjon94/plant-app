package com.oybekdev.plant_app.presentation.signUpScreen

data class SignUpState(
    val isloading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = "",
)
