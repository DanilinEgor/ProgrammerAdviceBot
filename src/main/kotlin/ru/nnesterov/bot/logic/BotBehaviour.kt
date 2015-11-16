package ru.nnesterov.bot.logic

import ru.nnesterov.bot.api.AdviceProvider

class BotBehaviour(private val adviceProvider: AdviceProvider) {
    private val greetings_text : String = """
    Привет. Я ProgrammerAdviceBot.
    Напиши /advice чтобы получить ценный совет
    """

    private val greetings : () -> String = {greetings_text}
    private val help : () -> String = {greetings_text}
    private val advice : () -> String = { adviceProvider.getNext() }

    private var answers = mapOf("/start" to greetings, "/help" to help, "/advice" to advice)


    public fun getAsnwer(message: String) :String? {
        val answer = answers.get(message) ?: return null
        return answer()
    }

}
