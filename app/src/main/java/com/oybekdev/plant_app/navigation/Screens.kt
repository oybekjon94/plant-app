package com.oybekdev.plant_app.navigation

sealed class Screens(val route:String){
    object SignInScreen : Screens(route = "SignIn_Screen")
    object SignUpScreen : Screens(route = "SignUp_Screen")
}
