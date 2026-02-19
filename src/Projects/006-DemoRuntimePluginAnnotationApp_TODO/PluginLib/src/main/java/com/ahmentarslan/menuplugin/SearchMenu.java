package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.IMenu;
import org.csystem.framework.menu.annotation.OptionMethods;

@OptionMethods
public class SearchMenu {
    public String optionString()
    {
        return "search";
    }

    public String name()
    {
        return "Search Device";
    }

    public void doOption()
    {
        System.out.println("Search Device");
    }
}
