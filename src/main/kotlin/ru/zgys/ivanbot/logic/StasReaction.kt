package ru.zgys.ivanbot.logic

import org.telegram.telegrambots.api.objects.Update
import java.util.*

class StasReaction : Reaction {
    override fun react(update: Update): Action {
        return if (update.message?.from?.userName == "sprodan" && Random().nextInt(100) < 50)
            Action("Стас!", Random().nextInt(7))
        else
            Action.noopAction()
    }
}