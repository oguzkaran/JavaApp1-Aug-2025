package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.IMenu;

public class ExitMenu implements IMenu {
    //...
    @Override
    public String optionString()
    {
        return "exit";
    }

    @Override
    public String name()
    {
        return "Exit";
    }

    @Override
    public void doOption()
    {
        System.out.println("Exit application");
        System.exit(0);
    }
}
