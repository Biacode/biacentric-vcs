package com.biacode.biacentric.vcs;

import com.biacode.biacentric.vcs.git.logmessage.GitLogMessageCommandExecutor;
import com.biacode.biacentric.vcs.git.logmessage.GitLogMessageJsonFormatBuilder;

/**
 * Created by Arthur Asatryan.
 * Date: 11/12/17
 * Time: 12:11 PM
 */
public class JavaTests {
    public static void main(String[] args) {
        final String format = new GitLogMessageJsonFormatBuilder().build();
        final String execute1 = GitLogMessageCommandExecutor.INSTANCE.execute(format);
        System.out.println(execute1);
        final String execute2 = GitLogMessageCommandExecutor.INSTANCE.execute(format, "--max-count=1");
        System.out.println(execute2);
    }
}
