package org.csystem.app.menu;

import lombok.extern.slf4j.Slf4j;
import org.csystem.framework.menu.CSDMenuFramework;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "usage: java -jar DemoMenuApp-1.0.0.jar <dir path>");

            var menu = CSDMenuFramework.builder()
                    .dirPath(args[0])
                    .invalidOptionText("Invalid Option. Be careful!...")
                    .refreshMenuOptionString("ref")
                    //.refreshMenuName("yenile")
                    .build();

            menu.run();
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

