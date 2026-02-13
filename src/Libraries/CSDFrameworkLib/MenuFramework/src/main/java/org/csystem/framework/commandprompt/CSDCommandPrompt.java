package org.csystem.framework.commandprompt;

import com.karandev.io.util.console.Console;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.Accessors;
import org.csystem.framework.commandprompt.annotation.Command;
import org.csystem.util.reflect.ReflectionUtil;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Accessors(prefix = "m_")
public class CSDCommandPrompt {
    private Object m_registerObject;
    private final ArrayList<CommandInfo> m_commands = new ArrayList<>();
    private Method m_errorCommandMethod;

    @Builder.Default
    private String m_prompt = "csd";

    @Builder.Default
    private String m_suffix = "$";

    @Builder.Default
    private String m_invalidCommand = "Invalid Command!...";

    @Builder.Default
    private String m_paramStringErrorMessage = "Argument parameters must be String...";

    @Builder.Default
    private String m_wrongNumberOfArgumentMessage = "Wrong number of arguments!";

    @AllArgsConstructor(access = AccessLevel.PACKAGE)
    private static class CommandInfo {
        String commandText;
        Method method;
        int argsCount;
    }

    private static boolean areAllString(Parameter [] parameters)
    {
        return ReflectionUtil.areAllSameTyped(parameters, String.class);
    }

    private void runCommand(String [] cmdInfo)
    {
        //...
    }

    private void registerObject()
    {
        //...
        var clsRegObject = m_registerObject.getClass();
        var methods = clsRegObject.getDeclaredMethods();

        for (var method : methods) {
            if (Modifier.isStatic(method.getModifiers()))
                continue;

            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                //Not annotated
                continue;
            }

            //Annotated
        }

    }

    public void run()
    {
        try {
            registerObject();

            while (true) {
                var cmd = Console.read(m_prompt + m_suffix);

                if (cmd.isBlank())
                    continue;

                runCommand(cmd.split("[ \t]+")); //ls -la /dev
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

}


