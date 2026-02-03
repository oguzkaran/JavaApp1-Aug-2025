package com.ahmentarslan.menuplugin;

import org.csystem.plugin.IMenu;

public class InsertMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 1;
    }

    @Override
    public String optionString()
    {
        return "insert";
    }

    @Override
    public String name()
    {
        return "Insert Device";
    }

    @Override
    public void doOption()
    {
        System.out.println("Insert Device");
    }
}
