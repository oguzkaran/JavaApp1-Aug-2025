package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.annotation.OptionMethods;

@OptionMethods
public class DeleteMenu {
    //...
    public String optionString()
    {
        return "delete";
    }

    public String name()
    {
        return "Delete Device";
    }

    public void doOption()
    {
        System.out.println("Delete Device");
    }
}
