package ru.zgys.ivanbot

import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot

/**
 * @author U.Goryntsev 21.04.2018.
 */

class BotHandler(private val secretToken: String): TelegramLongPollingBot() {

    override fun getBotToken(): String {
        return secretToken
    }

    override fun getBotUsername() = "IvanScrumBot"

    override fun onUpdateReceived(update: Update?) {
        val answer = solve(update?.message?.text?:"")
        val sendMessage = SendMessage(update?.message?.chatId, answer)

        try {
            execute(sendMessage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun solve (message: String): String = if (message == "/start") "Зачем ты это сказал?" else "o_O"
}