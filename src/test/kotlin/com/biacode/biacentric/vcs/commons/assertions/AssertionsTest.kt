package com.biacode.biacentric.vcs.commons.assertions

import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import org.junit.Assert.fail
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 11:58 AM
 */
class AssertionsTest : AbstractVcsUnitTest() {
    //region Test methods

    //region assertTrue
    @Test
    fun `test assert true when fails`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        try {
            Assertions.assertTrue(false)
            fail()
        } catch (ignore: IllegalArgumentException) {
        }
        verifyAll()
    }

    @Test
    fun `test assert true when not fails`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        Assertions.assertTrue(true)
        verifyAll()
    }
    //endregion

    //region assertNotEmpty
    @Test
    fun `test assert not empty when fails`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        try {
            Assertions.assertNotEmpty(emptyList<String>())
            fail()
        } catch (ignore: IllegalArgumentException) {
        }
        verifyAll()
    }

    @Test
    fun `test assert not empty when not fails`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        Assertions.assertNotEmpty(listOf("Hello", "World"))
        verifyAll()
    }
    //endregion

    //endregion
}