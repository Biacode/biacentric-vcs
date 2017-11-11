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

    //region Test subject and mocks
    //endregion

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
                GitLogMessagePlaceholder.AUTHOR_DATE
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

data class GitLogMessageTemplate(
        val placeholders: Set<GitLogMessagePlaceholder> = setOf(
                GitLogMessagePlaceholder.COMMIT_HASH,
                GitLogMessagePlaceholder.AUTHOR_NAME,
                GitLogMessagePlaceholder.AUTHOR_DATE
        )
)

enum class GitLogMessagePlaceholder(val propertyName: String, val placeholder: String, val description: String) {
    COMMIT_HASH("commitHash", "%H", "commit hash"),
    ABBREVIATED_COMMIT_HASH("abbreviatedCommitHash", "%h", "abbreviated commit hash"),
    TREE_HASH("treeHash", "%T", "tree hash"),
    ABBREVIATED_TREE_HASH("abbreviatedTreeHash", "%T", "tree abbreviated tree hash"),
    PARENT_HASHES("parentHashes", "%P", "parent hashes"),
    ABBREVIATED_PARENT_HASHES("abbreviatedParentHashes", "%p", "abbreviated parent hashes"),
    AUTHOR_NAME("authorName", "%an", "author name"),
    AUTHOR_EMAIL("authorEmail", "%ae", "author email"),
    AUTHOR_DATE("authorDate", "%ad", "author date (format respects --date= option)"),
    AUTHOR_DATE_RFC("authorDateRfc", "%aD", "author date, RFC2822 style"),
    AUTHOR_DATE_RELATIVE("authorDateRelative", "%ar", "author date, relative"),
    AUTHOR_DATE_UNIX("authorDateUnix", "%at", "author date, UNIX timestamp"),
    AUTHOR_DATE_ISO("authorDateIso", "%ai", "author date, ISO 8601-like format"),
    AUTHOR_DATE_ISO_STRICT("authorDateIsoStrict", "%aI", "author date, strict ISO 8601 format"),
    COMMIT_NAME("commitName", "%cn", "committer name"),
    COMMITTER_EMAIL("committerEmail", "%ce", "committer email"),
    COMMITTER_DATE("committerDate", "%cd", "committer date (format respects --date= option)"),
    COMMITTER_DATE_RFC("committerDateRfc", "%cD", "committer date, RFC2822 style"),
    COMMITTER_DATE_RELATIVE("committerDateRelative", "%cr", "committer date, relative"),
    COMMITTER_DATE_UNIX("committerDateUnix", "%ct", "committer date, UNIX timestamp"),
    COMMITTER_DATE_ISO("committerDateIso", "%ci", "committer date, ISO 8601-like format"),
    COMMITTER_DATE_ISO_STRICT("committerDateIsoStrict", "%cI", "committer date, strict ISO 8601 format"),
    REF_NAMES("refNames", "%d", "ref names, like the --decorate option of git-log[1]"),
    REF_NAMES_UNWRAPPED("refNamesUnwrapped", "%D", "ref names without the \" (\", \")\" wrapping."),
    ENCODING("encoding", "%e", "encoding"),
    SUBJECT("subject", "%s", "subject"),
    SUBJECT_SANITIZED("subjectSanitized", "%f", "sanitized subject line, suitable for a filename"),
    BODY("body", "%b", "body"),
    BODY_RAW("bodyRaw", "%B", "raw body (unwrapped subject and body)"),
    COMMIT_NOTES("commitNotes", "%N", "commit notes")
    // the list is not complete
}