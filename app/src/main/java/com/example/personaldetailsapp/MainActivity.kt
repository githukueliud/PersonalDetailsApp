package com.example.personaldetailsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personaldetailsapp.ui.screens.HomeScreen
import com.example.personaldetailsapp.ui.screens.HomeScreenViewModel
import com.example.personaldetailsapp.ui.theme.PersonalDetailsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalDetailsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val homeScreenViewModel: HomeScreenViewModel = viewModel()
                    HomeScreen(homeScreenViewModel)
                }
            }
        }
    }
}

