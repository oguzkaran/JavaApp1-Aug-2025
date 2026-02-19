package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.annotation.OptionMethods;

@OptionMethods(doOption = "exit", name = "exitMenuName")
public class ExitMenu {
    //...
    public String optionString()
    {
        return "exit";
    }

    public String exitMenuName()
    {
        return "Exit";
    }

    public void exit()
    {
        System.out.println("Exit application");
        System.exit(0);
    }
}
