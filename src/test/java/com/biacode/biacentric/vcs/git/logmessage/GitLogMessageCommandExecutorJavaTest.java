package com.biacode.biacentric.vcs.git.logmessage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 12:11 PM
 */
public class GitLogMessageCommandExecutorJavaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitLogMessageCommandExecutorJavaTest.class);

    @Test
    public void testExecuteDefaultFormat() {
        // {"commitHash": "%H", "authorName": "%an", "authorDate": "%ad", "subject": "%s"}
        final String output = GitLogMessageCommandExecutor.INSTANCE.execute();
        assertThat(output).isNotNull().isNotBlank();
        LOGGER.info("Output - {}", output);
    }

    @Test
    public void testExecuteCustomFormatAndCommands() {
        final List<GitLogMessagePlaceholder> placeholders = new ArrayList<>(Arrays.asList(
                GitLogMessagePlaceholder.AUTHOR_DATE,
                GitLogMessagePlaceholder.ABBREVIATED_TREE_HASH,
                GitLogMessagePlaceholder.SUBJECT
        ));
        final String output = GitLogMessageCommandExecutor.INSTANCE.execute(
                new GitLogMessageJsonFormatBuilder()
                        .fromTemplate(new GitLogMessageTemplate(placeholders))
                        .build(),
                "--max-count=3"
        );
        assertThat(output).isNotNull().isNotBlank();
        LOGGER.info("Output - {}", output);
    }
}
