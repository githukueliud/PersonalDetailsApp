package com.example.personaldetailsapp.ui.screens

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.personaldetailsapp.R

@Composable
fun HomeScreen() {
    ProfileName()
    ProfileImage()
    GithubWebViewComponent()
}

//Composable to display Slack user name
@Composable
fun ProfileName(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.user_name),
        fontSize = 30.sp
    )
}

//Composable to display the image
@Composable
fun ProfileImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.eliud_githuku),
        contentDescription = stringResource(id = R.string.user_name)
    )
}

//Image that redirects to github profile
@Composable
fun WebViewButton(modifier: Modifier = Modifier) {
    Button(onClick = {  }) {
        Text(text = stringResource(R.string.open_github))
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

//@Preview(showBackground = true)
//@Composable
//fun ProfileNamePreview() {
//    ProfileName()
//}