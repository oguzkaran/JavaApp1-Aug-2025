package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.plugin.IMenu;

public class ExitMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 6;
    }

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
