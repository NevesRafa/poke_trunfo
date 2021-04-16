package com.example.poketrunfo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.poketrunfo.classes.Pokemon
import com.example.poketrunfo.databinding.ActivityTelaJogoBinding
import com.squareup.picasso.Picasso

class TelaJogoActivity : AppCompatActivity() {

    lateinit var presenter: TelaJogoPresenter
    lateinit var telaJogo: ActivityTelaJogoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        telaJogo = ActivityTelaJogoBinding.inflate(layoutInflater)
        setContentView(telaJogo.root)

        presenter = TelaJogoPresenter(this)
        presenter.inciaJogo()

        telaJogo.start.setOnClickListener {
            presenter.jogar(telaJogo.forca.isChecked, telaJogo.ataque.isChecked, telaJogo.defesa.isChecked)
            telaJogo.proximoRound.isEnabled = false
            checkJogador2()
        }

        telaJogo.proximoRound.setOnClickListener {
            presenter.novoRound()
            telaJogo.start.isEnabled = true
            telaJogo.proximoRound.isEnabled = false
            limparAtributos()
        }
    }


    fun mostraCartaJogador1(cartaJogador1: Pokemon?) {

        telaJogo.nomePokemon.text = cartaJogador1?.nome

        val imagemPokemon = telaJogo.imagePokemon
        Picasso.get().load(cartaJogador1?.imagem).into(imagemPokemon)

        telaJogo.forca.text = getString(R.string.atr_forca, cartaJogador1?.forca)
        telaJogo.ataque.text = getString(R.string.atr_ataque, cartaJogador1?.ataque)
        telaJogo.defesa.text = getString(R.string.atr_defesa, cartaJogador1?.defesa)

        telaJogo.nomePokemonJogador2.visibility = View.GONE
        telaJogo.imagePokemonJogador2.visibility = View.GONE
        telaJogo.radioGroupJogador2.visibility = View.GONE

        val cardVerso = ContextCompat.getDrawable(this, R.drawable.back)

        telaJogo.cardJogador2.setImageDrawable(cardVerso)
    }

    fun mostraCartaJogador2(cartaJogador2: Pokemon?) {

        telaJogo.nomePokemonJogador2.visibility = View.VISIBLE
        telaJogo.imagePokemonJogador2.visibility = View.VISIBLE
        telaJogo.radioGroupJogador2.visibility = View.VISIBLE
        telaJogo.nomePokemonJogador2.text = cartaJogador2?.nome

        val imagemPokemon2 = telaJogo.imagePokemonJogador2
        Picasso.get().load(cartaJogador2?.imagem).into(imagemPokemon2)

        telaJogo.forcaJogador2.text = getString(R.string.atr_forca, cartaJogador2?.forca)
        telaJogo.ataqueJogador2.text = getString(R.string.atr_ataque, cartaJogador2?.ataque)
        telaJogo.defesaJogador2.text = getString(R.string.atr_defesa, cartaJogador2?.defesa)

        val cardFrente = ContextCompat.getDrawable(this, R.drawable.basic)

        telaJogo.cardJogador2.setImageDrawable(cardFrente)
    }

    fun mostraResultadoTela(msg: String) {

        val builder = AlertDialog.Builder(this)

        // Titulo da caixa de alerta
        builder.setTitle("Resultado")

        // Mensagem recebida atraves de parametro
        builder.setMessage(msg)

        //botão ok
        builder.setPositiveButton("OK") { _, _ ->
            telaJogo.proximoRound.isEnabled = true
            telaJogo.start.isEnabled = false
        }

        // Cria caixa de alerta
        val alertDialog = builder.create()
        // propriedades da caixa de alerta
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun mensagemErro() {

        Toast.makeText(this, "Selecione um atributo.", Toast.LENGTH_SHORT).show()
    }

    fun limparAtributos() {

        telaJogo.radioGroup.clearCheck()
    }

    fun checkJogador2() {

        telaJogo.forcaJogador2.isChecked = telaJogo.forca.isChecked
        telaJogo.ataqueJogador2.isChecked = telaJogo.ataque.isChecked
        telaJogo.defesaJogador2.isChecked = telaJogo.defesa.isChecked
    }

    fun mostraPlacar(placarJogador1: Int, placarJogador2: Int) {

        if (placarJogador1 <= 1) {
            telaJogo.placarJogador1.text = getString(R.string.player_score, placarJogador1)
        } else {
            telaJogo.placarJogador1.text = getString(R.string.player_scores, placarJogador1)
        }

        if (placarJogador2 <= 1) {
            telaJogo.placarJogador2.text = getString(R.string.computer_score, placarJogador2)
        } else {
            telaJogo.placarJogador2.text = getString(R.string.computer_scores, placarJogador2)
        }

    }

    fun vitoria() {

        val intent = Intent(this, TelaResultadoActivity::class.java)
        intent.putExtra(TelaResultadoActivity.EXTRA_GANHOU, true)
        startActivity(intent)
        finish()
    }

    fun derrota() {

        val intent = Intent(this, TelaResultadoActivity::class.java)
        intent.putExtra(TelaResultadoActivity.EXTRA_GANHOU, false)
        startActivity(intent)
        finish()
    }
}
