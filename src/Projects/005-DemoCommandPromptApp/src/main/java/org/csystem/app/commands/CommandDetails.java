package org.csystem.app.commands;

import com.karandev.io.util.console.Console;
import org.csystem.framework.commandprompt.annotation.Command;
import org.csystem.framework.commandprompt.annotation.Commands;
import org.csystem.framework.commandprompt.annotation.ErrorCommand;

public class CommandDetails {
    //...
    @Command("ls")
    @Command("dir")
    @Command
    private void list(String dirName)
    {
        Console.writeLine("List directory:%s", dirName);
    }

    @Commands({@Command("cp"), @Command})
    private void copy(String src, String dest)
    {
        Console.writeLine("copy from %s to %s", src, dest);
    }

    @Command("quit")
    @Command
    private void exit()
    {
        System.out.println("C and System Programmers Association");
        System.exit(0);
    }

    @Command
    private void clear()
    {
        for (var i = 0; i < 20; ++i)
            System.out.println();
    }

    @ErrorCommand
    private void error()
    {
        System.err.println("ERROR OCCURRED");
    }
}
