package com.biacode.biacentric.vcs

import com.biacode.biacentric.vcs.test.AbstractVcsUnitTest
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Test
import org.zeroturnaround.exec.ProcessExecutor

/**
 * Created by Arthur Asatryan.
 * Date: 11/10/17
 * Time: 6:58 PM
 */
class CommandLineTest : AbstractVcsUnitTest() {

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
        println("Hello, World!")
        verifyAll()
    }

    @Test
    fun `test command line executor`() {
        // test data
        resetAll()
        // expectations
        replayAll()
        // test scenario
        val output = ProcessExecutor()
                .command("git", "log", "--format=format:{\"authorName\": \"%aN\", \"authorEmail\": \"%ae\", \"commiterName\": \"%s\"},")
                .readOutput(true).execute()
                .outputUTF8()
        if (output.isNotEmpty()) {
            val transformOutput = "[${output.subSequence(0, output.length - 1)}]"
            val mapper = ObjectMapper()
            //JSON from String to Object
            val gitLogMessages: List<GitLogMessage> = mapper.readValue(transformOutput, mapper.typeFactory.constructCollectionType(List::class.java, GitLogMessage::class.java))
            println(gitLogMessages)
        }
        verifyAll()
    }
    //endregion

    //region Data classes
    data class GitLogMessage(
            @JsonProperty("authorName")
            val authorName: String,
            @JsonProperty("authorEmail")
            val authorEmail: String,
            @JsonProperty("commiterName")
            val commiterName: String
    )
    //endregion

}