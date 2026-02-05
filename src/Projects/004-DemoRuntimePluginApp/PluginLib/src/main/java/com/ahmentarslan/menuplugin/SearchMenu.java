package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.plugin.IMenu;

public class SearchMenu implements IMenu {
    //...
    @Override
    public int order()
    {
        return 2;
    }

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
