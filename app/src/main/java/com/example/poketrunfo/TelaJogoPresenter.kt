package com.example.poketrunfo

import com.example.poketrunfo.classes.Jogador
import com.example.poketrunfo.classes.Jogo

class TelaJogoPresenter(val telaJogoActivity: TelaJogoActivity) {

    lateinit var jogo: Jogo // criando difinicao para meu objeto

    fun inciaJogo() {

        jogo = Jogo() // iniciando objeto
        jogo.jogador1 = Jogador() // iniciando jogador 1
        jogo.jogador2 = Jogador()  // iniciando jogador 2

        jogo.sorteiaCarta()

        novoRound()
    }

    fun novoRound() {

        val estadoJogo = jogo.estadoJogo()

        if (estadoJogo == Jogo.EstadoJogo.VITORIA) {
            telaJogoActivity.vitoria()
            return
        } else if (estadoJogo == Jogo.EstadoJogo.DERROTA) {
            telaJogoActivity.derrota()
            return
        }

        jogo.pegarCartaJogador1()
        val cartaJogador1 = jogo.guardaCartaJogador1
        telaJogoActivity.mostraCartaJogador1(cartaJogador1)

        jogo.pegarCartaJogador2()
        atualizaPlacar()
    }

    fun jogar(forca: Boolean, ataque: Boolean, defesa: Boolean) {

        val resultado: Int?
        val cartaJogador2 = jogo.guardaCartaJogador2

        if (forca == true) {
            resultado = jogo.comparaForca()
        } else if (ataque == true) {
            resultado = jogo.comparaAtaque()
        } else if (defesa == true) {
            resultado = jogo.comparaDefesa()
        } else {
            telaJogoActivity.mensagemErro()
            return
        }

        telaJogoActivity.mostraCartaJogador2(cartaJogador2)

        if (resultado == Jogo.EstadoRound.VITORIA_JOGADOR1) {
            telaJogoActivity.mostraResultadoTela("Parabéns você ganhou!!!")
        } else if (resultado == Jogo.EstadoRound.VITORIA_JOGADOR2) {
            telaJogoActivity.mostraResultadoTela("Você Perdeu!!!")
        } else if (resultado == Jogo.EstadoRound.EMPATE) {
            telaJogoActivity.mostraResultadoTela("Empatou!!")
        }
    }

    fun atualizaPlacar() {
        val placarJogador1 = jogo.quantidadeCartasJogador1()
        val placarJogador2 = jogo.quantidadeCartasJogador2()

        telaJogoActivity.mostraPlacar(placarJogador1, placarJogador2)
    }
}
