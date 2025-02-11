package com.mygomii.video_player

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.renderComposable

@Composable
fun App2() {
    H1 {  "Hello, Compose for Web!" }
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
fun Test()  {
    Text("안녕 ")
}
//@OptIn(ExperimentalComposeUiApi::class)
//fun main() {
//    renderComposable(rootElementId = "root") {
//        App2()
//    }
//}
//
//@Composable
//fun App2() {
//    Div {
//        H1 {
//            // 제목
//            "Hello, Compose for Web!"
//        }
//        P {
//            // 본문 내용
//            "이것은 Compose Multiplatform을 사용한 웹 애플리케이션 예제입니다."
//        }
//    }
//}