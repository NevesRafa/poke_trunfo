package com.example.poketrunfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.poketrunfo.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {

    lateinit var telaInicial: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        telaInicial = ActivityTelaInicialBinding.inflate(layoutInflater)
        setContentView(telaInicial.root)

        telaInicial.botaoJogar.setOnClickListener {

            val intent = Intent(this, TelaJogoActivity::class.java)
            startActivity(intent)
        }
    }


}