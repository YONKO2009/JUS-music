package com.jusmusic.player

import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.jusmusic.api.models.Track

class JUSPlayerController(context: Context) {

    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()

    private val _queue = MutableStateFlow<List<Track>>(emptyList())
    val queue: StateFlow<List<Track>> = _queue.asStateFlow()

    fun addToQueue(track: Track) {
        _queue.value = _queue.value + track
    }

    fun removeAt(index: Int) {
        val updated = _queue.value.toMutableList()
        if (index in updated.indices) {
            updated.removeAt(index)
            _queue.value = updated
        }
    }
    val currentTrack: StateFlow<String?> = _currentTrack.asStateFlow()

    private val _playbackProgress = MutableStateFlow(0L)
    val playbackProgress: StateFlow<Long> = _playbackProgress.asStateFlow()

    init {
        exoPlayer.addListener(object : Player.Listener {
            override fun onIsPlayingChanged(isPlaying: Boolean) {
                _isPlaying.value = isPlaying
            }

            override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                _currentTrack.value = mediaItem?.mediaId
            }

            override fun onPositionDiscontinuity(oldPosition: Player.PositionInfo, newPosition: Player.PositionInfo, reason: Int) {
                _playbackProgress.value = newPosition.positionMs
            }
        })
    }

    fun play() {
        exoPlayer.playWhenReady = true
        exoPlayer.prepare()
    }

    fun pause() {
        exoPlayer.playWhenReady = false
    }

    fun seekTo(position: Long) {
        exoPlayer.seekTo(position)
        _playbackProgress.value = position
    }

    fun loadTrack(track: String) {
        val mediaItem = MediaItem.fromUri(track)
        exoPlayer.setMediaItem(mediaItem)
        _currentTrack.value = track
        exoPlayer.prepare()
    }
}
