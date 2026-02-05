package org.csystem.framework.menu;

import com.karandev.io.util.console.Console;
import lombok.AllArgsConstructor;
import org.csystem.framework.menu.plugin.IMenu;
import org.csystem.reflect.ReflectionUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private static final String NAME_METHOD_NAME = "name";
    private static final String ORDER_METHOD_NAME = "order";
    private static final String OPTION_STRING_METHOD_NAME = "optionString";
    private static final String DO_OPTION_METHOD_NAME = "doOption";
    private final String m_dirPath;
    private final List<MenuInfo> m_menuInfoList = new ArrayList<>();

    @AllArgsConstructor
    private static class MenuInfo {
        Object singleton;
        Method orderMethod;
        Method nameMethod;
        Method optionStringMethod;
        Method doOptionMethod;
    }

    private void displayMenu() throws IllegalAccessException, InvocationTargetException
    {
        for (var menuInfo : m_menuInfoList)
            Console.writeLine("%s-%s", menuInfo.orderMethod.invoke(menuInfo.singleton), menuInfo.nameMethod.invoke(menuInfo.singleton));

        //TODO (Oğuz):Add refresh menu
        Console.write("Option:");
    }

    private static int compareCallback(MenuInfo mi1, MenuInfo mi2)
    {
        try {
            var orderMethod1 = mi1.orderMethod;
            var orderMethod2 = mi2.orderMethod;

            return (int)orderMethod1.invoke(mi1.singleton) - (int)orderMethod2.invoke(mi2.singleton);
        }
        catch (Exception e) {
            System.err.printf("Error while comparing: %s\n", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void doOption(String option) throws  IllegalAccessException, InvocationTargetException
    {
        for (var menuInfo : m_menuInfoList) {
            var object = menuInfo.singleton;
            var optionStringMethod = menuInfo.optionStringMethod;

            if (option.length() >= 3 && optionStringMethod.invoke(object).toString().startsWith(option)) {
                var doOptionMethod = menuInfo.doOptionMethod;

                doOptionMethod.invoke(object);
                return;
            }
        }

        Console.writeLine("Invalid option!...");
    }

    private void createMenuInfoList(List<Class<?>> menuClsList) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        m_menuInfoList.clear();
        for (var cls : menuClsList) {
            var object = cls.getDeclaredConstructor().newInstance();
            var orderMethod = cls.getDeclaredMethod(ORDER_METHOD_NAME);
            var nameMethod = cls.getDeclaredMethod(NAME_METHOD_NAME);
            var optionStringMethod = cls.getDeclaredMethod(OPTION_STRING_METHOD_NAME);
            var doOptionMethod = cls.getDeclaredMethod(DO_OPTION_METHOD_NAME);

            m_menuInfoList.add(new MenuInfo(object, orderMethod, nameMethod, optionStringMethod, doOptionMethod));
        }
    }

    private void refreshMenu() throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
    {
        createMenuInfoList(ReflectionUtil.getImplementedClassesByJars(m_dirPath, IMenu.class));
    }

    public Menu(String dirPath)
    {
        m_dirPath = dirPath;
    }

    public void run()
    {
        try {
            while (true) {
                refreshMenu();
                m_menuInfoList.sort(Menu::compareCallback);

                displayMenu();
                var option = Console.readLine();

                doOption(option);
            }
        }
        catch (Exception e) {
            Console.Error.writeLine("Exception occurred:%s, %s", e.getClass().getName(), e.getMessage());
        }
    }
}
