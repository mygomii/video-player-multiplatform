package com.mygomii.video_player

class JSPlatform: Platform {
    override val name: String = "Java"
}

actual fun getPlatform(): Platform = JSPlatform()