package com.biacode.biacentric.vcs.git.logmessage

import com.biacode.biacentric.vcs.commons.git.Format
import org.zeroturnaround.exec.ProcessExecutor

/**
 * Created by Arthur Asatryan.
 * Date: 11/11/17
 * Time: 4:29 PM
 */
object GitLogMessageCommandExecutor {

    //region Public methods
    /**
     * Executes git log command.
     *
     * @param format The git log message json format.
     * @param commands The git log specific commands like HEAD, --log-size etc...
     * @return the command execution output string.
     */
    fun execute(format: String = Format.gitLogMessageDefaultFormat, vararg commands: String = arrayOf()): String {
        return processExecution(format, *commands)
    }
    //endregion

    //region Utility methods
    private fun processExecution(format: String, vararg commands: String = arrayOf()): String {
        val output = ProcessExecutor()
                .command("git", "log", *commands, "--format=format:$format,")
                .readOutput(true).execute()
                .outputUTF8()
        return "[${output.dropLast(1)}]"
    }
    //endregion
}