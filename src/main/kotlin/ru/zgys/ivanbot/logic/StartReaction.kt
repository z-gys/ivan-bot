package ru.zgys.ivanbot.logic

import org.telegram.telegrambots.api.objects.Update

class StartReaction : Reaction {
    override fun react(update: Update): Action {
        return if (update.message?.text == "/start")
            Action("Я здесь чтобы помочь вам развиваться")
        else
            Action.noopAction()
    }
}