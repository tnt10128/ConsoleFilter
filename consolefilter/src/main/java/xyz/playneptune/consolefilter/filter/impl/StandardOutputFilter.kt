package xyz.playneptune.consolefilter.filter.impl

import xyz.playneptune.consolefilter.filter.LogFilter
import java.io.PrintStream

class StandardOutputFilter : PrintStream(System.out, true), LogFilter {

    override fun println(toPrint: String) {
        if (shouldPermitMessage(toPrint)) {
            super.println(toPrint)
        }
    }

    override fun initialize() = System.setOut(this)

}