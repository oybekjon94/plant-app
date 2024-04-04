package com.oybekdev.plant_app.data

import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.oybekdev.plant_app.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email:String,password:String): Flow<Resource<AuthResult>>
    fun registerUser(email: String,password: String):Flow<Resource<AuthResult>>
    fun googleSignIn(credential:AuthCredential):Flow<Resource<AuthResult>> //credential - ishonch
}