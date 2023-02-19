package xyz.playneptune.consolefilter.filter.impl

import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Marker
import org.apache.logging.log4j.core.Filter
import org.apache.logging.log4j.core.LifeCycle
import org.apache.logging.log4j.core.LogEvent
import org.apache.logging.log4j.core.Logger
import org.apache.logging.log4j.message.Message
import xyz.playneptune.consolefilter.filter.LogFilter

class Log4jFilter : Filter, LogFilter {

    private fun getFilterResult(toCheck: String): Filter.Result =
        if (shouldPermitMessage(toCheck)) Filter.Result.ACCEPT else Filter.Result.DENY

    override fun getState(): LifeCycle.State? = null

    override fun initialize() {
        val rootLogger = LogManager.getRootLogger() as Logger
        rootLogger.addFilter(this)
    }

    override fun start() {}

    override fun stop() {}

    override fun isStarted(): Boolean = true

    override fun isStopped(): Boolean = false

    override fun getOnMismatch(): Filter.Result? = null

    override fun getOnMatch(): Filter.Result? = null

    override fun filter(
        logger: Logger,
        level: Level,
        marker: Marker,
        msg: String,
        vararg params: Any
    ): Filter.Result = getFilterResult(msg)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?,
        p8: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?,
        p8: Any?,
        p9: Any?
    ): Filter.Result = getFilterResult(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        msg: Any?,
        t: Throwable?
    ): Filter.Result = getFilterResult(msg.toString())

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        msg: Message,
        t: Throwable?
    ): Filter.Result = getFilterResult(msg.toString())

    override fun filter(event: LogEvent): Filter.Result = getFilterResult(event.message.formattedMessage)

}