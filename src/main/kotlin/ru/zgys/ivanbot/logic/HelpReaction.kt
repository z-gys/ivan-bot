package ru.zgys.ivanbot.logic

import org.telegram.telegrambots.api.objects.Update

class HelpReaction : Reaction {
    override fun react(update: Update): Action {
        return if (update.message?.text == "/help")
            Action(message = "Да ничего я не умею. Только /start и /help")
        else
            Action.noopAction()
    }
}