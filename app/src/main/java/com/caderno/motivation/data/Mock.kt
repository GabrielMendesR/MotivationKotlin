package com.caderno.motivation.data

import com.caderno.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryID: Int) {

}
class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val emoji = MotivationConstants.FILTER.EMOJI
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não Sabendo Que Era Impossível, Foi Lá e Fez!", sunny),
        Phrase("O Jogo Não Acaba Quando Você Perde, Ele Acaba Quando Você Desiste!", sunny),
        Phrase("É Justamente Quando Esta Escuro Conseguimos Ver Mais Estrelas No Céu", sunny),
        Phrase("O Maior Risco De Todos é Não Correr Riscos!", sunny),
        Phrase("Não Pare Quando Estiver Cansado, Para Quando Tiver Terminado!", emoji),
        Phrase("Se Você Não Sabe Onde Ir, Continue Andando", emoji),
        Phrase("A Melhor Forma de Prever o Futuro é Inventá-lo", emoji),
        Phrase("Não Se Apegue Apenas Ao Resultado, Aproveite o Processo", emoji),
    )

    fun getPhrase(cat: Int): String {

        val filtered = mListPhrase.filter { it.categoryID == cat || cat == all}

        return filtered[Random.nextInt(filtered.size)].description
    }

}