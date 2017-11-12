package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 4:29 PM
 */
class GitLogMessageTemplateTest : AbstractVcsUnitTest() {

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
    fun `default git log message template`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageTemplate().placeholders).isNotNull.containsExactly(
                GitLogMessagePlaceholder.COMMIT_HASH,
                GitLogMessagePlaceholder.AUTHOR_NAME,
                GitLogMessagePlaceholder.AUTHOR_DATE,
                GitLogMessagePlaceholder.SUBJECT
        )
        verifyAll()
    }

    @Test
    fun `custom git log message template`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(GitLogMessageTemplate(setOf(
                GitLogMessagePlaceholder.AUTHOR_DATE_ISO
        )).placeholders).isNotNull.containsExactly(
                GitLogMessagePlaceholder.AUTHOR_DATE_ISO
        )
        verifyAll()
    }
    //endregion
}

