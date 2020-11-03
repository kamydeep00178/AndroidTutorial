package com.tech.musicPlayer.playSong

import com.tech.musicPlayer.BasePresenter
import com.tech.musicPlayer.player.PlayerService


class PlaySongPresenter(private val view: PlaySongView) : BasePresenter<PlaySongView>(view) {
    private lateinit var player: PlayerService

    fun setPlayerManager(player: PlayerService) {
        this.player = player

        fetchSongState()
    }

    fun fetchSongState() {
        val song = player.getSong() ?: return
        view.updateSongState(song, player.isPlaying(), player.getProgress())

        view.showRepeat(player.isRepeat)
        view.showRandom(player.isRandom)
    }

    fun updateRepeat(): Boolean {
        player.isRepeat = !player.isRepeat
        return player.isRepeat
    }

    fun updateRandom(): Boolean {
        player.isRandom = !player.isRandom
        return player.isRandom
    }

    fun onSongPlay() {
        if (!player.isPlaying()) {
            player.play()
        } else {
            player.pause()
        }
    }

    fun skipToNext() = player.skipToNext()

    fun skipToPrevious() = player.skipToPrevious()

    fun seekTo(duration: Int) = player.seekTo(duration)
}