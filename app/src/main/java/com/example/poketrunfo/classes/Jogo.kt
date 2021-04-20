package com.example.poketrunfo.classes


class Jogo {

    /**
     * object é como se fosse uma class que não se pode criar instancia (objeto).
     */
    object EstadoRound {
        const val VITORIA_JOGADOR1 = 0 // const val é criado pois recebe um valor que nunca vai ser alterado (constante).
        const val VITORIA_JOGADOR2 = 1
        const val EMPATE = 2
    }

    object EstadoJogo {
        const val VITORIA = 0
        const val DERROTA = 1
        const val ROLANDO = 2
    }

    var listaDeCartas = mutableListOf(
        Pokemon(
            "Bulbasaur",
            300,
            250,
            450,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            "A"
        ),
        Pokemon(
            "Charmander",
            350,
            400,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            "A"
        ),
        Pokemon(
            "Squirtle",
            400,
            450,
            400,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
            "A"
        ),
        Pokemon(
            "Caterpie",

            100,
            50,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png",
            "C"
        ),
        Pokemon(
            "Weedle",
            50,
            15,
            150,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/013.png",
            "C"
        ),
        Pokemon(
            "Pidgey",
            150,
            250,
            350,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/016.png",
            "B"
        ),
        Pokemon(
            "Rattata",
            350,
            200,
            150,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/019.png",
            "D"
        ),
        Pokemon(
            "Spearow",
            400,
            350,
            230,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/021.png",
            "C"
        ),
        Pokemon(
            "Ekans",
            150,
            250,
            100,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/023.png",
            "D"
        ),
        Pokemon(
            "Pikachu",
            490,
            480,
            450,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            "A"
        ),
        Pokemon(
            "Sandshrew",
            300,
            250,
            400,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/027.png",
            "C"
        ),
        Pokemon(
            "Nidoran ♀",
            350,
            300,
            250,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/029.png",
            "C"
        ),
        Pokemon(
            "Nidoran ♂",
            350,
            300,
            250,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/032.png",
            "C"
        ),
        Pokemon(
            "Clefairy",
            150,
            100,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/035.png",
            "C"
        ),
        Pokemon(
            "Vulpix",
            200,
            250,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/037.png",
            "C"
        ),
        Pokemon(
            "Jigglypuff",
            80,
            150,
            50,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/039.png",
            "D"
        ),
        Pokemon(
            "Zubat",
            100,
            80,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/041.png",
            "D"
        ),
        Pokemon(
            "Oddish",
            200,
            100,
            200,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/043.png",
            "D"
        ),
        Pokemon(
            "Paras",
            200,
            90,
            150,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/046.png",
            "D"
        ),
        Pokemon(
            "Mewtwo",
            500,
            500,
            500,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/150.png",
            "S"
        ),
        Pokemon(
            "Venonat",
            250,
            200,
            150,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/048.png",
            "D"
        ),
        Pokemon(
            "Diglett",
            300,
            450,
            250,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/050.png",
            "D"
        ),
        Pokemon(
            "Meowth",
            400,
            350,
            450,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/052.png",
            "B"
        ),
        Pokemon(
            "Psyduck",
            450,
            100,
            150,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/054.png",
            "B"
        ),
        Pokemon(
            "Mankey",
            280,
            350,
            300,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/056.png",
            "B"
        ),
        Pokemon(
            "Growlithe",
            200,
            380,
            250,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/058.png",
            "B"
        ),
//   ?
        Pokemon(
            "Abra",
            490,
            450,
            100,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/063.png",
            "B"
        )
    )

    var jogador1: Jogador? = null
    var jogador2: Jogador? = null

    var guardaCartaJogador1: Pokemon? = null
    var guardaCartaJogador2: Pokemon? = null

    /**
     * Pega o baralho e embaralha e divide o baralho (ex: 28 cartas / 2 = 14 cartas para cada jogador)
     */
    fun sorteiaCarta() {
        listaDeCartas.shuffle() //shuffle - embaralha lista
        val metadeBaralho = listaDeCartas.size / 2
        jogador1?.cartasJogador = listaDeCartas.slice(0 until metadeBaralho).toMutableList() // slice - cortar / dividir
        jogador2?.cartasJogador = listaDeCartas.slice(metadeBaralho until listaDeCartas.size).toMutableList()
    }

    /**
     *  Remove a primeira carta do deck do jogador 1 e guarda ela var guardaCartaJogador1.
     */
    fun pegarCartaJogador1() {
        val carta = jogador1?.cartasJogador?.firstOrNull()
        jogador1?.cartasJogador?.remove(carta)
        guardaCartaJogador1 = carta
    }

    /**
     * Remove a primeira carta do deck do jogador 1 e guarda ela var guardaCartaJogador2.
     */
    fun pegarCartaJogador2() {
        val carta = jogador2?.cartasJogador?.firstOrNull()
        jogador2?.cartasJogador?.remove(carta)
        guardaCartaJogador2 = carta
    }

    /**
     * Pega a carta que está na var guardaCartaJogador1 e  var guardaCartaJogador2 e compara a força entre elas.
     */
    fun comparaForca(): Int {
        val forcaJogador1 = guardaCartaJogador1?.forca ?: 0
        val forcaJogador2 = guardaCartaJogador2?.forca ?: 0
        return comparaAtributos(forcaJogador1, forcaJogador2)
    }

    /**
     * Pega a carta que está na var guardaCartaJogador1 e  var guardaCartaJogador2 e compara a ataque entre elas.
     */
    fun comparaAtaque(): Int {
        val ataqueJogador1 = guardaCartaJogador1?.ataque ?: 0
        val ataqueJogador2 = guardaCartaJogador2?.ataque ?: 0
        return comparaAtributos(ataqueJogador1, ataqueJogador2)
    }

    /**
     * Pega a carta que está na var guardaCartaJogador1 e  var guardaCartaJogador2 e compara a defesa entre elas.
     */
    fun comparaDefesa(): Int {
        val defesaJogador1 = guardaCartaJogador1?.defesa ?: 0
        val defesaJogador2 = guardaCartaJogador2?.defesa ?: 0
        return comparaAtributos(defesaJogador1, defesaJogador2)
    }

    private fun comparaAtributos(atributoJogador1: Int, atributoJogador2: Int): Int {

        val resultado: Int  // val resultado, foi criada para retornar meu resultado.

        if(guardaCartaJogador1?.classe == "S" && guardaCartaJogador2?.classe != "A"){
            jogador1?.cartasJogador?.add(guardaCartaJogador1!!)
            jogador1?.cartasJogador?.add(guardaCartaJogador2!!)
            resultado = EstadoRound.VITORIA_JOGADOR1
            guardaCartaJogador1 = null
            guardaCartaJogador2 = null
            return resultado
        }else if (guardaCartaJogador2?.classe == "S" && guardaCartaJogador1?.classe != "A"){
            jogador2?.cartasJogador?.add(guardaCartaJogador2!!)
            jogador2?.cartasJogador?.add(guardaCartaJogador1!!)
            resultado = EstadoRound.VITORIA_JOGADOR2
            guardaCartaJogador1 = null
            guardaCartaJogador2 = null
            return resultado
        }




        // Se o atributo do jogador1 for maior que do jogador2, pega as cartas que estão em jogo e coloca no deck do jogador1.
        //  A var resultado recebe VITORIA_JOGADOR1.
        if (atributoJogador1 > atributoJogador2) {
            jogador1?.cartasJogador?.add(guardaCartaJogador1!!)
            jogador1?.cartasJogador?.add(guardaCartaJogador2!!)
            resultado = EstadoRound.VITORIA_JOGADOR1

            // Se o atributo do jogador1 for menor que do jogador2, pega as cartas que estão em jogo e coloca no deck do jogador2.
            //  A var resultado recebe VITORIA_JOGADOR2.
        } else if (atributoJogador1 < atributoJogador2) {
            jogador2?.cartasJogador?.add(guardaCartaJogador2!!)
            jogador2?.cartasJogador?.add(guardaCartaJogador1!!)
            resultado = EstadoRound.VITORIA_JOGADOR2

            // Se nenhum dos dois vencer cada um fica com a sua carta e a var resultado recebe EMPATE.
        } else {
            jogador1?.cartasJogador?.add(guardaCartaJogador1!!)
            jogador2?.cartasJogador?.add(guardaCartaJogador2!!)
            resultado = EstadoRound.EMPATE
        }

        // Aqui anula as cartas que estavam em jogo e retorna o resultado.
        guardaCartaJogador1 = null
        guardaCartaJogador2 = null
        return resultado
    }


    fun quantidadeCartasJogador1(): Int {
        // retorna a quantidade de carta que o jogador tem no seu deck ( o elvis operator é se caso o size for null ele recebe 0 ).
        return jogador1?.cartasJogador?.size ?: 0
    }

    fun quantidadeCartasJogador2(): Int {
        // retorna a quantidade de carta que o jogador tem no seu deck ( o elvis operator é se caso o size for null ele recebe 0 ).
        return jogador2?.cartasJogador?.size ?: 0
    }

    /**
     * Verifica a quantidade de cartas que o jogador tem no deck e retorna se é derrota, vitoria ou continua o jogo.
     */
    fun estadoJogo(): Int {

        val qtdJ1 = quantidadeCartasJogador1()
        val qtdJ2 = quantidadeCartasJogador2()

        if (qtdJ1 == 0) {
            return EstadoJogo.DERROTA  // se a quantidade de carta do jogador1 for 0 DERROTA (perdeu).
        } else if (qtdJ2 == 0) {
            return EstadoJogo.VITORIA  // se a quantidade de carta do jogador2 for 0 VITORIA (ganhou).
        } else {
            return EstadoJogo.ROLANDO  // se não o jogo continua.
        }
    }
}


