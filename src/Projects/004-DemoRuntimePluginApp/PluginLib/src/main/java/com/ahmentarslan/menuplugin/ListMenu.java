package com.ahmentarslan.menuplugin;

import org.csystem.plugin.IMenu;

public class ListMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 5;
    }

    @Override
    public String optionString()
    {
        return "list";
    }

    @Override
    public String name()
    {
        return "List Devices";
    }

    @Override
    public void doOption()
    {
        System.out.println("List Devices");
    }
}
