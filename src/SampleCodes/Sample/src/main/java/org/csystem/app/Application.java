package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        while (true) {
            try {
                var clsName = Console.read("Input class name:");
                if ("exit".equals(clsName))
                    break;
                var cls = Class.forName(clsName);

                log.info("Name: {}", cls.getName());
            } catch (ClassNotFoundException e) {
                log.error("Class not found:{}", e.getMessage());
            }
        }
    }
}