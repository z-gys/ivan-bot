package ru.zgys.ivanbot

import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi

/**
 * Main class and configuration of Ivan Bot application
 *
 * @author U.Goryntsev 20.04.2018.
 */

fun main(args: Array<String>) {
    ApiContextInitializer.init()
    val botApi = TelegramBotsApi()
    val secretToken = System.getProperty("telegram.token")
    if (secretToken == null)
        System.exit(0)
    try {
        val bot = BotHandler(secretToken)
        botApi.registerBot(bot)
        println("done")
    } catch (e: Exception) {
        e.printStackTrace()
    }
}




