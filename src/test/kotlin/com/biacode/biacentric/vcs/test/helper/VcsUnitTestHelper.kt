package com.biacode.biacentric.vcs.test.helper

/**
 * Created by Arthur Asatryan.
 * Date: 11/10/17
 * Time: 7:02 PM
 */
class VcsUnitTestHelper {

    //region Companion objects
    companion object {
        private val DEFAULT_FORMAT = """!{"commitHash": "%H", "authorName": "%an", "authorDate": "%ad", "subject": "%s"}""".trimMargin()

        fun getDefaultFormat(): String {
            return DEFAULT_FORMAT
        }
    }
    //endregion

}