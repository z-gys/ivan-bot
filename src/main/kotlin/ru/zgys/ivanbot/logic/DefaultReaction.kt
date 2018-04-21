package ru.zgys.ivanbot.logic

import org.telegram.telegrambots.api.objects.Update
import ru.zgys.ivanbot.logic.Action.Companion.noopAction
import java.util.*

/**
 * @author U.Goryntsev 21.04.2018.
 */
class DefaultReaction: Reaction {
    override fun react(update: Update): Action {
        return if (Random().nextInt(100) < 10) Action(message = "Ты зачем это сказал?") else noopAction()
    }
}