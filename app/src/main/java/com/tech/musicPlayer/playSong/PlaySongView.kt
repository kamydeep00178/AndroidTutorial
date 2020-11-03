package com.tech.musicPlayer.playSong

import com.tech.musicPlayer.BaseView
import com.tech.musicPlayer.model.Song


interface PlaySongView : BaseView {
    fun updateSongState(song: Song, isPlaying: Boolean, progress: Int)

    fun showRepeat(isRepeat: Boolean)

    fun showRandom(isRandom: Boolean)
}