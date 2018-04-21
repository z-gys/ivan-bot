package ru.zgys.ivanbot.logic

import org.telegram.telegrambots.api.objects.Update

/**
 * @author U.Goryntsev 21.04.2018.
 */
interface Reaction {
    fun react(update: Update): Action
}

data class Action (val message: String, val count: Int = 1, val hasAction: Boolean = true) {
    companion object {
        fun noopAction() = Action("", 0, false)
    }
}