package com.ahmentarslan.menuplugin;


import org.csystem.framework.menu.IMenu;

public class DeleteMenu implements IMenu {
    //...
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
