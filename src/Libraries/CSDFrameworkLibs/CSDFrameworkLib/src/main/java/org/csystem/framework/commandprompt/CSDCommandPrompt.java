package org.csystem.framework.commandprompt;

import com.karandev.io.util.console.Console;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.Accessors;
import org.csystem.framework.commandprompt.annotation.Command;
import org.csystem.framework.commandprompt.annotation.ErrorCommand;
import org.csystem.util.reflect.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Accessors(prefix = "m_")
public class CSDCommandPrompt {
    private Object m_registerObject;
    private final ArrayList<CommandInfo> m_commands = new ArrayList<>();
    private final ArrayList<Method> m_errorCommands = new ArrayList<>();

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
    @Builder
    private static class CommandInfo {
        String commandText;
        Method method;
        int argsCount;
    }

    private static boolean areAllString(Parameter [] parameters)
    {
        return ReflectionUtil.areAllSameTyped(parameters, String.class);
    }

    private void runCommand(String [] cmdInfo) throws InvocationTargetException, IllegalAccessException //ls -la /dev
    {
        var params = Arrays.copyOfRange(cmdInfo, 1, cmdInfo.length);
        var commandFound = false;
        var argsValid = false;

        for (var commandInfo : m_commands) {
            if (commandInfo.commandText.equals(cmdInfo[0])) {
                commandFound = true;
                argsValid = true;

                if (commandInfo.argsCount != params.length) {
                    argsValid = false;
                    continue;
                }

                commandInfo.method.invoke(m_registerObject, (Object []) params);
                break;
            }
        }

        if (!commandFound) {
            if (!m_errorCommands.isEmpty()) {
                for (var method: m_errorCommands)
                    method.invoke(m_registerObject);
            }
            else
                Console.Error.writeLine(m_invalidCommand);
        }
        else if (!argsValid) {
            Console.Error.writeLine(m_wrongNumberOfArgumentMessage);
        }
    }

    private void registerCommands(Command [] commands, Method method)
    {
        method.setAccessible(true);
        for (var command : commands) {
            var value = command.value();
            var commandText = value.isBlank() ? method.getName() : value;
            var parameters = method.getParameters();

            if (!areAllString(parameters))
                throw new IllegalArgumentException(m_paramStringErrorMessage);

            var commandInfo = CommandInfo.builder()
                    .commandText(commandText)
                    .method(method)
                    .argsCount(parameters.length)
                    .build();

            m_commands.add(commandInfo);
        }
    }

    private void registerObject()
    {
        var clsRegObject = m_registerObject.getClass();
        var methods = clsRegObject.getDeclaredMethods();

        for (var method : methods) {
            if (Modifier.isStatic(method.getModifiers()))
                continue;

            var commands = method.getDeclaredAnnotationsByType(Command.class);

            if (commands.length == 0) {
                if (method.getDeclaredAnnotation(ErrorCommand.class) != null && method.getTypeParameters().length == 0) {
                    method.setAccessible(true);
                    m_errorCommands.add(method);
                }
            }
            else
                registerCommands(commands, method);
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

                runCommand(cmd.split("[ \t]+"));
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}


