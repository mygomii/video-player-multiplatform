package com.mygomii.video_player

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1

@Composable
fun App2() {
    H1 { "Hello, Compose for Web!" }
}

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport("root") {
//        App()
        Div {
//            App()
            Test()
        }
//        Test()
    }
}

@Composable
fun Test() {
    Text("안녕 ")
}
