package com.biacode.biacentric.vcs.git.logmessage;

import com.biacode.biacentric.vcs.commons.git.Format;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 2:49 PM
 */
public class GitLogMessageJsonFormatBuilderJavaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitLogMessageJsonFormatBuilderJavaTest.class);

    @Test
    public void testDefaultBuilder() {
        final String format = new GitLogMessageJsonFormatBuilder().build();
        // default format is {"commitHash": "%H", "authorName": "%an", "authorDate": "%ad", "subject": "%s"}
        assertThat(format).isNotNull().isNotBlank().isEqualTo(Format.INSTANCE.getGitLogMessageDefaultFormat());
        LOGGER.info("Format - {}", format);
    }

    @Test
    public void testCustomBuilder() {
        final List<GitLogMessagePlaceholder> placeholders = new ArrayList<>(Arrays.asList(GitLogMessagePlaceholder.AUTHOR_NAME, GitLogMessagePlaceholder.SUBJECT));
        final String format = new GitLogMessageJsonFormatBuilder()
                .fromTemplate(new GitLogMessageTemplate(placeholders))
                .build();
        assertThat(format).isNotNull().isNotBlank().isEqualTo("{\"authorName\": \"%an\", \"subject\": \"%s\"}");
        // custom format is {"authorName": "%an", "subject": "%s"}
        LOGGER.info("Format - {}", format);
    }
}