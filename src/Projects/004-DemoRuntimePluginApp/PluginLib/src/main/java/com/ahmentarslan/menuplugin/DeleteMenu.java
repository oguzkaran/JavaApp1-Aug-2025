package com.ahmentarslan.menuplugin;


import org.csystem.framework.menu.plugin.IMenu;

public class DeleteMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 4;
    }

    @Override
    public String optionString()
    {
        return "delete";
    }

    @Override
    public String name()
    {
        return "Delete Device";
    }

    @Override
    public void doOption()
    {
        System.out.println("Delete Device");
    }
}
