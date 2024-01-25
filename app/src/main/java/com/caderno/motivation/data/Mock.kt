package com.caderno.motivation.data

import com.caderno.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryID: Int, val lang: String) {}

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val emoji = MotivationConstants.FILTER.EMOJI
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val pt = MotivationConstants.LANGUAGES.PORTUGUESE
    private val en = MotivationConstants.LANGUAGES.ENGLISH

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não Sabendo Que Era Impossível, Foi Lá e Fez!", sunny, pt),
        Phrase("O Jogo Não Acaba Quando Você Perde, Ele Acaba Quando Você Desiste!", sunny, pt),
        Phrase("É Justamente Quando Esta Escuro Conseguimos Ver Mais Estrelas No Céu", sunny, pt),
        Phrase("O Maior Risco De Todos é Não Correr Riscos!", sunny, pt),
        Phrase("Não Pare Quando Estiver Cansado, Para Quando Tiver Terminado!", emoji, pt),
        Phrase("Se Você Não Sabe Onde Ir, Continue Andando", emoji, pt),
        Phrase("A Melhor Forma de Prever o Futuro é Inventá-lo", emoji, pt),
        Phrase("Não Se Apegue Apenas Ao Resultado, Aproveite o Processo", emoji, pt),

        Phrase("Not knowing that it was impossible, he went there and did it!", sunny, en),
        Phrase("The game doesn't end when you lose, it ends when you give up!!", sunny, en),
        Phrase("It's Just When It's Dark We Can See More Stars in the Sky", sunny, en),
        Phrase("The Biggest Risk Of All Is Not Taking Risks!", sunny, en),
        Phrase("Don't Stop When You're Tired, Stop When You're Done", emoji, en),
        Phrase("If You Don't Know Where to Go, Keep Walking", emoji, en),
        Phrase("The Best Way to Predict the Future is to Invent it", emoji, en),
        Phrase("Don't Just Get Attached to the Result, Enjoy the Process", emoji, en),
    )

    fun getPhrase(cat: Int, lan: String): String {

        val filtered = mListPhrase.filter { (it.categoryID == cat || cat == all) && it.lang == lan }

        return filtered[Random.nextInt(filtered.size)].description
    }

}