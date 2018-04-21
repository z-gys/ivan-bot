package ru.zgys.ivanbot

import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import ru.zgys.ivanbot.logic.Action
import ru.zgys.ivanbot.logic.Reaction

/**
 * @author U.Goryntsev 21.04.2018.
 */

class IvanBot(private val secretToken: String, private val reactions: List<Reaction>): TelegramLongPollingBot() {

    override fun getBotToken(): String {
        return secretToken
    }

    override fun getBotUsername() = "IvanScrumBot"

    override fun onUpdateReceived(update: Update?) {
        if (update == null) return

        for (reaction in reactions) {
            val action = reaction.react(update)
            if (action.hasAction) {
                executeAction(action, update.message.chatId)
                break
            }
        }
    }


    fun executeAction(action: Action, chatId: Long) {
        val sendMessage = SendMessage(chatId, action.message)
        try {
            for (i in 0 until action.count)
                execute(sendMessage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}