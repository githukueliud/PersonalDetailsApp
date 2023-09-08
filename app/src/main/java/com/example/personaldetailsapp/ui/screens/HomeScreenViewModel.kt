package com.example.personaldetailsapp.ui.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel: ViewModel() {
    //View model to hold the ui data so as to withstand reconfiguration
    private val _githubScreenIsShown = MutableStateFlow(false)
    val githubScreenIsShown: StateFlow<Boolean> = _githubScreenIsShown

    fun showGitHubScreen() {
        viewModelScope.launch {
            _githubScreenIsShown.value = true
        }
    }

    fun hideGitHubScreen() {
        viewModelScope.launch {
            _githubScreenIsShown.value = false
        }
    }

}

