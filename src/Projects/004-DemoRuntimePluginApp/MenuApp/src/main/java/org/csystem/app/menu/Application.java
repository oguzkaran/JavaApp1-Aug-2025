package org.csystem.app.menu;

import lombok.extern.slf4j.Slf4j;
import org.csystem.framework.menu.Menu;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "usage: java -jar DemoMenuApp-1.0.0.jar <dir path>");

            var menu = new Menu(args[0]);

            menu.run();
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

