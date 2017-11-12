package com.biacode.biacentric.vcs.commons.format

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 3:05 PM
 */
object GitFormats {
    val gitLogMessageDefaultFormat = """|{"commitHash": "%H", "authorName": "%an", "authorDate": "%ad", "subject": "%s"}""".trimMargin()
}