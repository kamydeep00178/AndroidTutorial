package com.tech.musicPlayer.songList

import com.tech.musicPlayer.BaseView
import com.tech.musicPlayer.model.Song


interface SongListView : BaseView {
    fun showLoading()

    fun stopLoading()

    fun updateSongState(song: Song, isPlaying: Boolean)

    fun onSongClick()
}