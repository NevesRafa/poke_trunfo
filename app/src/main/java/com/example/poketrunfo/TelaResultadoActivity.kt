package com.example.poketrunfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.poketrunfo.databinding.ActivityTelaResultadoBinding

class TelaResultadoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GANHOU = "ganhou"
    }

    private lateinit var telaResultado: ActivityTelaResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        telaResultado = ActivityTelaResultadoBinding.inflate(layoutInflater)
        setContentView(telaResultado.root)

        val ganhou = intent.getBooleanExtra(EXTRA_GANHOU, false)
        buscaImagem(ganhou)

        telaResultado.novoJogo.setOnClickListener {

            val intent = Intent(this, TelaJogoActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun buscaImagem(ganhou: Boolean) {

        if (ganhou == true) {
            val vitoria = ContextCompat.getDrawable(this, R.drawable.vitoria)
            telaResultado.tela.setImageDrawable(vitoria)
        } else {
            val derrota = ContextCompat.getDrawable(this, R.drawable.derrota)
            telaResultado.tela.setImageDrawable(derrota)
        }
    }
}