package com.mygomii.video_player.presentation.secreens.player

import VideoPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.mygomii.video_player.data.model.VideoPlayerState
import kotlin.math.roundToInt

@Composable
fun MiniPlayer(
    modifier: Modifier = Modifier,
    playerState: VideoPlayerState,
    onShowPlayer: () -> Unit = {},
    onClose: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val density = LocalDensity.current
        val parentWidthPx = with(density) { maxWidth.toPx() }
        val parentHeightPx = with(density) { maxHeight.toPx() }
        val miniPlayerWidthPx = with(density) { 200.dp.toPx() }
        val miniPlayerHeightPx = with(density) { 120.dp.toPx() }
        var offset by remember { mutableStateOf(Offset.Zero) }

        Box(
            modifier = modifier
                .offset { IntOffset(offset.x.roundToInt(), offset.y.roundToInt()) }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        val newOffset = offset + dragAmount
                        offset = Offset(
                            x = newOffset.x.coerceIn(0f, parentWidthPx - miniPlayerWidthPx),
                            y = newOffset.y.coerceIn(0f, parentHeightPx - miniPlayerHeightPx)
                        )
                    }
                }
                .size(200.dp, 120.dp)
                .background(Color.Black)

        ) {
            VideoPlayer(
                modifier = Modifier.fillMaxSize(),
                url = playerState.currentVideo!!.videoUrl,
                autoPlay = playerState.isPlaying,
                showControls = true,
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)

            ) {
                IconButton(
                    onClick = { onShowPlayer() },
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = "영상보기",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { onClose() },
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "닫기",
                        tint = Color.White
                    )
                }
            }

        }
    }
}