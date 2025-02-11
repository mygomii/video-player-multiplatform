package com.mygomii.video_player

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform