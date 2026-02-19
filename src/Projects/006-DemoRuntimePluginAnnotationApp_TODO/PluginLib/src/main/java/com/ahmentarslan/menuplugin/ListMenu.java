package com.ahmentarslan.menuplugin;


import org.csystem.framework.menu.annotation.OptionMethods;

@OptionMethods
public class ListMenu  {
    //...
    public String optionString()
    {
        return "list";
    }

    public String name()
    {
        return "List Devices";
    }

    public void doOption()
    {
        System.out.println("List Devices");
    }
}
