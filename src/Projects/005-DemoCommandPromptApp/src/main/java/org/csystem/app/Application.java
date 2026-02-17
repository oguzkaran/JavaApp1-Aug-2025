package org.csystem.app;

import lombok.extern.slf4j.Slf4j;
import org.csystem.app.commands.CommandDetails;
import org.csystem.framework.commandprompt.CSDCommandPrompt;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        CSDCommandPrompt.builder()
                .prompt("CSD")
                //.suffix(">")
                .invalidCommand("INVALID COMMAND!...")
                .registerObject(new CommandDetails())
                .build()
                .run();
    }
}
