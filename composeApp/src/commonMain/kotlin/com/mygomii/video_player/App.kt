package com.mygomii.video_player

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.mygomii.video_player.data.model.sampleVideos
import com.mygomii.video_player.presentation.secreens.main.MainScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainScreen(sampleVideos)
    }
}

