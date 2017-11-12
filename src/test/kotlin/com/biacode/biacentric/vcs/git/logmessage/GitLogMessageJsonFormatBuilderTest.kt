package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.commons.git.Format
import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 7:15 PM
 */
class GitLogMessageJsonFormatBuilderTest : AbstractVcsUnitTest() {

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
    fun `test from template method`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(
                GitLogMessageJsonFormatBuilder().fromTemplate(
                        GitLogMessageTemplate(setOf(
                                GitLogMessagePlaceholder.ABBREVIATED_COMMIT_HASH,
                                GitLogMessagePlaceholder.AUTHOR_DATE)
                        ))
        ).isNotNull().isInstanceOf(GitLogMessageJsonFormatBuilder::class.java)
        verifyAll()
    }

    @Test
    fun `test default build method (without custom template)`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageJsonFormatBuilder().build()).isEqualTo(Format.gitLogMessageDefaultFormat)
        verifyAll()
    }

    @Test
    fun `test build method`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageJsonFormatBuilder()
                .fromTemplate(
                        GitLogMessageTemplate(setOf(
                                GitLogMessagePlaceholder.COMMIT_HASH,
                                GitLogMessagePlaceholder.AUTHOR_EMAIL
                        ))
                )
                .build()
        ).isEqualTo("""|{"commitHash": "%H", "authorEmail": "%ae"}""".trimMargin())
        verifyAll()
    }
    //endregion

}