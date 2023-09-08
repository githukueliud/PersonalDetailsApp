package com.example.personaldetailsapp.ui.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.personaldetailsapp.R

@Composable
fun GithubScreenShown() {
    var githubScreenIsShown = remember {
        mutableStateOf(false)
    }
    if(githubScreenIsShown != githubScreenIsShown){
        GithubWebViewComponent()
    } else {
        HomeScreen()
    }
}

//Composable to display the image
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var githubScreenIsShown by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
        ){
        Text(text = "")
        Card(
            modifier = Modifier.height(400.dp),
            border = BorderStroke(0.3.dp, Color(245, 245, 245)),
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.user_name),
                    fontSize = 35.sp,
                    modifier = Modifier
                        .padding(20.dp),
                    textAlign = TextAlign.Start
                )
                Image(
                    painter = painterResource(id = R.drawable.eliud_githuku),
                    contentDescription = stringResource(id = R.string.user_name),
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .size(200.dp)
                        .clip(RoundedCornerShape(50)),
                    contentScale = ContentScale.Crop,
                )
                Button(onClick = { githubScreenIsShown = true }) {
                    Text(text = stringResource(R.string.open_github))
                }
            }
        }
        Text(text = "")
    }

    if (githubScreenIsShown) {
        GithubWebViewComponent()
    }
}



//This is the Navigation routes
//This is the WebView component
@Composable
fun GithubWebViewComponent() {
    val githubUrl = "https://github.com/githukueliud"

    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(githubUrl)
        }
    }, update = {
        it.loadUrl(githubUrl)
    }
    )
}



enum class PersonalDetailsScreens() {
    HomeScreen,
    GithubScreen
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}