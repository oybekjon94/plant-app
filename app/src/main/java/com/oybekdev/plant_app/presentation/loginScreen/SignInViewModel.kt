package com.oybekdev.plant_app.presentation.loginScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthCredential
import com.oybekdev.plant_app.data.AuthRepository
import com.oybekdev.plant_app.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: AuthRepository
):ViewModel(){

    val _signInState = Channel<SignInState>()
    val signInState = _signInState.receiveAsFlow()

    val _googleState = mutableStateOf(GoogleSignInState())
    val googleState: State<GoogleSignInState> = _googleState

    fun googleSignIn(credential:AuthCredential) = viewModelScope.launch {
        repository.googleSignIn(credential).collect{result ->
            when(result){
                is Resource.Error -> {
                    _googleState.value = GoogleSignInState(error = result.message!!)
                }
                is Resource.Loading -> {
                    _googleState.value = GoogleSignInState(loading = true)
                }
                is Resource.Success -> {
                    _googleState.value = GoogleSignInState(success = result.data)
                }
            }
        }
    }

    fun loginUser(email:String,password:String) = viewModelScope.launch {
        repository.loginUser(email,password).collect{result ->
            when(result){
                is Resource.Error -> {
                    _signInState.send(SignInState(isError = result.message))
                }
                is Resource.Loading -> {
                    _signInState.send(SignInState(isLoading = true))
                }
                is Resource.Success -> {
                    _signInState.send(SignInState(isSuccess = "Sign in Success"))
                }
            }
        }
    }
}