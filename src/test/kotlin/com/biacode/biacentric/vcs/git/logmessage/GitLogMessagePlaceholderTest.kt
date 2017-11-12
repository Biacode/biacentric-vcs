package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 7:31 PM
 */
class GitLogMessagePlaceholderTest : AbstractVcsUnitTest() {

    //region Test methods
    @Test
    fun `it works`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        verifyAll()
    }

    @Test
    fun `test get property name`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessagePlaceholder.AUTHOR_EMAIL.propertyName).isEqualTo("authorEmail")
        verifyAll()
    }

    @Test
    fun `test get placeholder`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessagePlaceholder.AUTHOR_EMAIL.placeholder).isEqualTo("%ae")
        verifyAll()
    }

    @Test
    fun `test get description`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessagePlaceholder.AUTHOR_EMAIL.description).isEqualTo("author email")
        verifyAll()
    }
    //endregion

}