package com.example.poketrunfo

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.poketrunfo.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    lateinit var telaInicial: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        telaInicial = ActivityTelaInicialBinding.inflate(layoutInflater)
        setContentView(telaInicial.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.musica_abertura)

        telaInicial.botaoJogar.setOnClickListener {

            val intent = Intent(this, TelaJogoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.seekTo(2000)
        mediaPlayer.start()
    }

    override fun onPause() {
        mediaPlayer.pause()
        super.onPause()
    }

    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
    }


}