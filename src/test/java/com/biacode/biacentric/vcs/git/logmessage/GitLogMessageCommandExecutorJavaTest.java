package com.biacode.biacentric.vcs.git.logmessage;

import com.biacode.biacentric.vcs.commons.git.Format;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        // {"authorName": "%an", "authorDate": "%ad", "subject": "%s"}
        final String output = GitLogMessageCommandExecutor.INSTANCE.execute(Format.INSTANCE.getGitLogMessageDefaultFormat());
        assertThat(output).isNotNull().isNotBlank();
        LOGGER.info("Output - {}", output);
    }

    @Test
    public void testExecuteCustomFormatAndCommands() {
        final Set<GitLogMessagePlaceholder> placeholders = new HashSet<>(Arrays.asList(
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