package com.biacode.biacentric.vcs.commons.json

import com.biacode.biacentric.vcs.git.logmessage.GitLogMessageCommandExecutor
import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import com.fasterxml.jackson.annotation.JsonProperty
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 7:16 PM
 */
class JsonDeserializerTest : AbstractVcsUnitTest() {

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
    fun `deserialize list with Any type`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(JsonDeserializer.deserializeList(GitLogMessageCommandExecutor.execute(), Any::class.java)).isNotNull
        verifyAll()
    }

    @Test
    fun `deserialize list with the given DTO`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        assertThat(JsonDeserializer.deserializeList(GitLogMessageCommandExecutor.execute(), GitLogMessageTestDto::class.java)).isNotNull
        verifyAll()
    }
    //endregion

    data class GitLogMessageTestDto(
            @JsonProperty("commitHash")
            val commitHash: String,
            @JsonProperty("authorName")
            val authorName: String,
            @JsonProperty("authorDate")
            val authorDate: String,
            @JsonProperty("subject")
            val subject: String
    )

}