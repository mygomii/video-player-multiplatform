package com.mygomii.video_player

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mygomii.video_player.data.model.Video
import com.mygomii.video_player.data.model.sampleVideos
import com.mygomii.video_player.presentation.secreens.home.VideoListScreen
import com.mygomii.video_player.presentation.secreens.player.VideoPlayerScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class Screen {
    VideoList, VideoPlayer
}

class NavigationState {
    var currentScreen by mutableStateOf(Screen.VideoList)
    var selectedVideo: Video? by mutableStateOf(null)

    fun navigateToPlayer(video: Video) {
        selectedVideo = video
        currentScreen = Screen.VideoPlayer
    }

    fun navigateToList() {
        currentScreen = Screen.VideoList
    }
}


@Composable
@Preview
fun App(navigationState: NavigationState = NavigationState()) {
    MaterialTheme {
        when (navigationState.currentScreen) {
            Screen.VideoList -> VideoListScreen(navigationState, sampleVideos)
            Screen.VideoPlayer -> VideoPlayerScreen(navigationState)
        }
    }
}

