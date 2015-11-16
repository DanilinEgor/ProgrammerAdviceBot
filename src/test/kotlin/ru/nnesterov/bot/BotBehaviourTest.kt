package ru.nnesterov.bot

import org.junit.Test
import ru.nnesterov.bot.api.AdviceProvider
import ru.nnesterov.bot.logic.BotBehaviour
import kotlin.test.assertTrue


class BotBehaviourTest {
    private val botBehaviour = BotBehaviour(AdviceProviderMock())

    @Test
    fun testNotEmpty() {
        assertTrue {
            botBehaviour.getAsnwer("/start")?.isNotEmpty() ?: false
            botBehaviour.getAsnwer("/help")?.isNotEmpty() ?: false
            botBehaviour.getAsnwer("/advice")?.isNotEmpty() ?: false
        }
    }

    @Test
    fun testEmpty() {
        assertTrue {
            botBehaviour.getAsnwer("/unsupported_command") == null
        }
    }

    private class AdviceProviderMock : AdviceProvider {
        override fun getNext(): String {
            return "Some advice here"
        }
    }
}

