package org.csystem.app;

import org.csystem.prompt.Prompt;

class Application {
    public static void run(String[] args)
    {
        while (true) {
            var prompt = Prompt.Builder.builder()
                    .setTitle("Alert")
                    .setMessage("Save?")
                    .setPositiveOption("Yes")
                    .setNegativeOption("No")
                    .setNeutralOption("Cancel")
                    .build();

            var option = prompt.show();

            if (option == 'i')
                break;
        }
    }
}

