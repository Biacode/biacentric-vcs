package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 7:35 PM
 */
class GitLogMessageCommandExecutorTest : AbstractVcsUnitTest() {

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
    fun `execute without commands`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageCommandExecutor.execute()).isNotNull().isNotBlank()
        verifyAll()
    }

    @Test
    fun `execute with some commands`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageCommandExecutor.execute(commands = "--log-size"))
                .isNotNull().isNotBlank()
        verifyAll()
    }

    @Test
    fun `execute with custom format`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageCommandExecutor.execute(
                """|{"authorName: "%an""}""".trimMargin(),
                "--max-count=1"
        )).isNotNull().isNotBlank()
        verifyAll()
    }
    //endregion

}