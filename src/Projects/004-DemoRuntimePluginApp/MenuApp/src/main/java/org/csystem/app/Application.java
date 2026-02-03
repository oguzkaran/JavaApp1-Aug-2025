package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.plugin.IMenu;
import org.csystem.reflect.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static org.csystem.app.constant.Constant.*;

class Application {
    private static void displayMenu(List<Class<?>> menuClsList) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        for (var cls : menuClsList) {
            var object = cls.getConstructor().newInstance();
            var orderMethod = cls.getDeclaredMethod(ORDER_METHOD_NAME);
            var nameMethod = cls.getDeclaredMethod(NAME_METHOD_NAME);

            Console.writeLine("%s-%s", orderMethod.invoke(object), nameMethod.invoke(object));
        }

        //TODO (Oğuz):Add refresh menu
        Console.write("Option:");
    }

    private static int compareCallback(Class<?> cls1, Class<?> cls2)
    {
        try {
            var object1 = cls1.getConstructor().newInstance();
            var object2 = cls2.getConstructor().newInstance();
            var orderMethod1 = cls1.getDeclaredMethod(ORDER_METHOD_NAME);
            var orderMethod2 = cls2.getDeclaredMethod(ORDER_METHOD_NAME);

            return (int)orderMethod1.invoke(object1) - (int)orderMethod2.invoke(object2);
        }
        catch (Exception e) {
            System.err.printf("Error while comparing: %s\n", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private static void doOption(List<Class<?>> clsList, String option) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        for (var cls : clsList) {
            var object = cls.getConstructor().newInstance();
            var optionStringMethod = cls.getDeclaredMethod(OPTION_STRING_METHOD_NAME);

            if (option.length() >= 3 && optionStringMethod.invoke(object).toString().startsWith(option)) {
                var doOptionMethod = cls.getDeclaredMethod(DO_OPTION_METHOD_NAME);

                doOptionMethod.invoke(object);
                return;
            }
        }

        Console.writeLine("Invalid option!...");
    }

    public static void run(String[] args)
    {
        checkLengthEquals(args.length, 1, "usage: java -jar DemoMenuApp-1.0.0.jar <dir path>");

        try {
            while (true) {
                var clsList = ReflectionUtil.getImplementedClassesByJars(args[0], IMenu.class);

                //TODO (Oğuz): All classes should be singleton

                clsList.sort(Application::compareCallback);

                displayMenu(clsList);
                var option = Console.readLine();

                doOption(clsList, option);
            }
        }
        catch (Exception e) {
            System.err.printf("Exception occurred:%s%n", e.getMessage());
        }
    }
}

