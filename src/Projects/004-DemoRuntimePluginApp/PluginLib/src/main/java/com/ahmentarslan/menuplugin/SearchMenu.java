package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.IMenu;

public class SearchMenu implements IMenu {
    @Override
    public String optionString()
    {
        return "search";
    }

    @Override
    public String name()
    {
        return "Search Device";
    }

    @Override
    public void doOption()
    {
        System.out.println("Search Device");
    }
}
