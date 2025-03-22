package com.mygomii.video_player.presentation.secreens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mygomii.video_player.data.model.Video
import com.mygomii.video_player.data.model.VideoPlayerState
import com.mygomii.video_player.presentation.secreens.player.MiniPlayer
import com.mygomii.video_player.presentation.secreens.player.VideoPlayerScreen

@Composable
fun MainScreen(videos: List<Video>) {
    var showPlayer by remember { mutableStateOf(false) }
    var isPlayerMinimized by remember { mutableStateOf(false) }
    var selectedVideo by remember { mutableStateOf<Video?>(null) }
    val videoPlayerState = remember { VideoPlayerState() }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        VideoListScreen(videos, onclick = { video ->
            selectedVideo = video
            showPlayer = true
            isPlayerMinimized = false
            videoPlayerState.loadVideo(video, showPlayer, isPlayerMinimized)
            println("###### Box $video, $showPlayer, $isPlayerMinimized")
        })

        if (showPlayer) {
            when (isPlayerMinimized) {
                true -> {
                    MiniPlayer(
                        playerState = videoPlayerState,
                        onShowPlayer = {
                            isPlayerMinimized = false
                        },
                        onClose = {
                            showPlayer = false
                        }
                    )
                }

                false -> {
                    VideoPlayerScreen(
                        playerState = videoPlayerState,
                        onBack = {
                            isPlayerMinimized = true
                        }
                    )
                }
            }
        }
    }
}