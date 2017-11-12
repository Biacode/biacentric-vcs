package com.biacode.biacentric.vcs.commons

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 4:29 PM
 */
object Assertions {

    //region Public methods
    fun assertTrue(expression: Boolean, message: String = "This expression should be true") {
        if (!expression) throwException(message)
    }

    fun assertNotEmpty(iterable: Iterable<*>, message: String = "This iterable should not be empty") {
        if (iterable.count() == 0) throwException(message)
    }

    private fun throwException(message: String) {
        throw IllegalArgumentException(message)
    }
    //endregion
}