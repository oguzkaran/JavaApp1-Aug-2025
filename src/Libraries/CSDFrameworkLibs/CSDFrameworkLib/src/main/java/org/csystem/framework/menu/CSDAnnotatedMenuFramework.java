package org.csystem.framework.menu;

import com.karandev.io.util.console.Console;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.Accessors;

import java.lang.reflect.InvocationTargetException;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Accessors(prefix = "m_")
public class CSDAnnotatedMenuFramework {

    private final String m_dirPath;

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

    //...

    private void displayMenu() throws IllegalAccessException, InvocationTargetException
    {
        throw new UnsupportedOperationException("TODO: Not yet implemented");
    }

    private void doOption(String option) throws  IllegalAccessException, InvocationTargetException
    {
        throw new UnsupportedOperationException("TODO: Not yet implemented");
    }


    private void refreshMenu()
    {
        throw new UnsupportedOperationException("TODO: Not yet implemented");
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
