package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.IMenu;

public class InsertMenu implements IMenu {
    //...
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
