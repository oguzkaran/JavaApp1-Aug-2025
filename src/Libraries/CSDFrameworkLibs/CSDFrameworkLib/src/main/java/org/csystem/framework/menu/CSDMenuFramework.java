package org.csystem.framework.menu;

import com.karandev.io.util.console.Console;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.Accessors;
import org.csystem.util.reflect.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(prefix = "m_")
public class CSDMenuFramework {
    private static final String NAME_METHOD_NAME = "name";
    private static final String OPTION_STRING_METHOD_NAME = "optionString";
    private static final String DO_OPTION_METHOD_NAME = "doOption";

    private final String m_dirPath;
    private final List<MenuInfo> m_menuInfoList = new ArrayList<>();

    @Builder.Default
    private String m_refreshMenuOptionString = "refresh";
    @Builder.Default
    private String m_refreshMenuName = "Refresh";
    @Builder.Default
    private String m_optionText = "Option";
    @Builder.Default
    private String m_invalidOptionText = "Invalid Option!...";
    @Builder.Default
    private String m_refreshMenuExceptionMessagePrefix = "Exception occurred in refresh menu";
    @Builder.Default
    private String m_runExceptionMessagePrefix = "Exception occurred";
    @Builder.Default
    private boolean m_sorted = true;
    @Builder.Default
    private String m_menuPrefix = "- ";

    @AllArgsConstructor
    private static class MenuInfo {
        Object singleton;
        Method nameMethod;
        Method optionStringMethod;
        Method doOptionMethod;
    }

    private class RefreshMenu implements IMenu {
        @Override
        public String optionString()
        {
            return m_refreshMenuOptionString;
        }

        @Override
        public String name()
        {
            return m_refreshMenuName;
        }

        @Override
        public void doOption()
        {
            refreshMenu();
        }
    }

    private void displayMenu() throws IllegalAccessException, InvocationTargetException
    {
        for (var menuInfo : m_menuInfoList)
            Console.writeLine("%s%s",  m_menuPrefix, menuInfo.nameMethod.invoke(menuInfo.singleton));

        Console.write("%s:", m_optionText);
    }

    private static int compareCallback(MenuInfo mi1, MenuInfo mi2)
    {
        try {
            var nameMethod1 = mi1.nameMethod;
            var nameMethod2 = mi2.nameMethod;

            return nameMethod1.invoke(mi1.singleton).toString().compareTo(nameMethod2.invoke(mi2.singleton).toString());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void doOption(String option) throws  IllegalAccessException, InvocationTargetException
    {
        for (var menuInfo : m_menuInfoList) {
            var object = menuInfo.singleton;
            var optionStringMethod = menuInfo.optionStringMethod;

            if (optionStringMethod.invoke(object).toString().equals(option)) {
                var doOptionMethod = menuInfo.doOptionMethod;

                doOptionMethod.invoke(object);
                return;
            }
        }

        Console.writeLine(m_invalidOptionText);
    }

    private static MenuInfo createMenuInfo(Object object, Class<?> cls) throws NoSuchMethodException
    {
        var nameMethod = cls.getDeclaredMethod(NAME_METHOD_NAME);
        var optionStringMethod = cls.getDeclaredMethod(OPTION_STRING_METHOD_NAME);
        var doOptionMethod = cls.getDeclaredMethod(DO_OPTION_METHOD_NAME);

        return new MenuInfo(object, nameMethod, optionStringMethod, doOptionMethod);
    }

    private void createMenuInfoList(List<Class<?>> menuClsList) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        m_menuInfoList.clear();
        for (var cls : menuClsList)
            m_menuInfoList.add(createMenuInfo(cls.getDeclaredConstructor().newInstance(), cls));

        m_menuInfoList.add(createMenuInfo(new RefreshMenu(), RefreshMenu.class));
    }

    private void refreshMenu()
    {
        try {
            createMenuInfoList(ReflectionUtil.getImplementedClassesByJars(m_dirPath, IMenu.class));
            if (m_sorted)
                m_menuInfoList.sort(CSDMenuFramework::compareCallback);
        }
        catch (Exception e) {
            Console.Error.writeLine("%s:%s, %s", m_refreshMenuExceptionMessagePrefix, e.getClass().getName(), e.getMessage());
        }
    }

    public void run()
    {
        try {
            refreshMenu();
            while (true) {


                displayMenu();
                var option = Console.readLine();

                doOption(option);
            }
        }
        catch (Exception e) {
            Console.Error.writeLine("%s:%s, %s", m_runExceptionMessagePrefix, e.getClass().getName(), e.getMessage());
        }
    }
}
