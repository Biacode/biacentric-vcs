package com.biacode.biacentric.vcs.git.logmessage

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 4:29 PM
 */
data class GitLogMessageTemplate(
        var placeholders: Set<GitLogMessagePlaceholder> = setOf(
                GitLogMessagePlaceholder.COMMIT_HASH,
                GitLogMessagePlaceholder.AUTHOR_NAME,
                GitLogMessagePlaceholder.AUTHOR_DATE,
                GitLogMessagePlaceholder.SUBJECT
        )
)