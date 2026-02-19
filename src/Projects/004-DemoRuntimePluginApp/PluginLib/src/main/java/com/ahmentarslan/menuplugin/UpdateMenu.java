package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.IMenu;

public class UpdateMenu implements IMenu {
    //...
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
