package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.annotation.OptionMethods;


@OptionMethods(optionString = "option")
public class InsertMenu {
    //...
    public String option()
    {
        return "insert";
    }

    public String name()
    {
        return "Insert Device";
    }

    public void doOption()
    {
        System.out.println("Insert Device");
    }
}
