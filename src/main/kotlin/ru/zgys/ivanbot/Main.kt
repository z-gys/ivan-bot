package ru.zgys.ivanbot

import org.reflections.Reflections
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi
import ru.zgys.ivanbot.logic.Reaction
import kotlin.streams.toList

/**
 * Entry point of Ivan Bot application
 *
 * @author U.Goryntsev 20.04.2018.
 */

fun main(args: Array<String>) {
    val secretToken = System.getProperty("telegram.token") ?: if (args.isNotEmpty()) args[0] else ""

    if (secretToken.isEmpty()) {
        print("No secret token :(")
        System.exit(-1)
    }

    ApiContextInitializer.init()
    val botApi = TelegramBotsApi()

    try {
        val reactions = findReactions()
        val bot = IvanBot(secretToken, reactions)
        botApi.registerBot(bot)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun findReactions(): List<Reaction> {
    val scanner = Reflections("ru.zgys.ivanbot.logic")
    return scanner.getSubTypesOf(Reaction::class.java).stream()
            .map { it.newInstance() }.toList()
}




