package com.mygomii.video_player.data.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class VideoPlayerState {
    var currentVideo by mutableStateOf<Video?>(null)
    var currentPosition by mutableStateOf(0L)
    var isPlaying by mutableStateOf(false)
    var isPlayerMinimized by mutableStateOf(false)
    var showPlayer by mutableStateOf(false)

    fun loadVideo(video: Video?, isPlayerMinimized: Boolean, showPlayer: Boolean) {
        currentVideo = video
        currentPosition = 0L
        isPlaying = true
        this.isPlayerMinimized = isPlayerMinimized
        this.showPlayer = showPlayer
    }
}
