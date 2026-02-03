package com.ahmentarslan.menuplugin;

import org.csystem.plugin.IMenu;

public class UpdateMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 3;
    }

    @Override
    public String optionString()
    {
        return "update";
    }

    @Override
    public String name()
    {
        return "Update Device";
    }

    @Override
    public void doOption()
    {
        System.out.println("Update Device");
    }
}
