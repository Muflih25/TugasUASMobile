package com.example.recyclerview
import  AudioListAdapter
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AudioActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_audio)
        recyclerView = findViewById(R.id.recyclerView)

        // Tambahkan ID audio baru ke dalam daftar
        val audioList = listOf(
            R.raw.audio00,
            R.raw.audio01,
            R.raw.audio02,
            R.raw.audio03,
            R.raw.audio04,
            R.raw.audio05,
            R.raw.audio06,
            R.raw.audio07,
            R.raw.audio08,
            R.raw.audio09,
            R.raw.audio10,
            R.raw.audio11,
            R.raw.audio12,
            R.raw.audio13,
            R.raw.audio14
        )

        val adapter = AudioListAdapter(audioList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}
