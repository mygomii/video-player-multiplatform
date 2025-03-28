package com.mygomii.video_player.presentation.secreens.player

import VideoPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mygomii.video_player.data.model.VideoPlayerState
import io.ktor.websocket.Frame

@Composable
fun VideoPlayerScreen(
    playerState: VideoPlayerState,
    onBack: () -> Unit
) {
    println("##### VideoPlayerScreen ${playerState.currentVideo}")
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                contentColor = Color.White,
                title = { Frame.Text("비디오 플레이어") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            println("###### currentVideoUrl ${playerState.currentVideo}")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                VideoPlayer(
                    modifier = Modifier
                        .fillMaxSize()
                        .height(340.dp),
                    url = playerState.currentVideo!!.videoUrl,
                    autoPlay = true,
                    showControls = true,
                )
            }
            Text(
                text = playerState.currentVideo!!.title,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}