package com.biacode.biacentric.vcs.git.logmessage;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 2:38 PM
 */
public class GitLogMessageTemplateJavaTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitLogMessageTemplateJavaTest.class);

    @Test
    public void testDefaultTemplate() {
        final GitLogMessageTemplate template = new GitLogMessageTemplate();
        assertThat(template.getPlaceholders()).isNotNull().isNotEmpty().containsExactly(
                GitLogMessagePlaceholder.COMMIT_HASH,
                GitLogMessagePlaceholder.AUTHOR_NAME,
                GitLogMessagePlaceholder.AUTHOR_DATE,
                GitLogMessagePlaceholder.SUBJECT
        );
        LOGGER.info("Placeholders - {}", template.getPlaceholders());
    }

    @Test
    public void testCustomTemplate() {
        final GitLogMessageTemplate template = new GitLogMessageTemplate();
        final Set<GitLogMessagePlaceholder> placeholders = Collections.singleton(GitLogMessagePlaceholder.SUBJECT);
        template.setPlaceholders(placeholders);
        assertThat(template.getPlaceholders()).isNotNull().isNotEmpty().containsExactly(
                GitLogMessagePlaceholder.SUBJECT
        );
        LOGGER.info("Placeholders - {}", template.getPlaceholders());
    }
}
