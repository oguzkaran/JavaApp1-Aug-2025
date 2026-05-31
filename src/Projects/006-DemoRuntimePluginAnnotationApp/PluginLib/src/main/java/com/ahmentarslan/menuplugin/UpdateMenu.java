package com.ahmentarslan.menuplugin;

import org.csystem.framework.menu.annotation.OptionMethods;

@OptionMethods(optionString = "option", name = "updateName", doOption = "update")
public class UpdateMenu {
    //...
    public String option()
    {
        return "update";
    }

    public String updateName()
    {
        return "Update Device";
    }

    public void update()
    {
        System.out.println("Update Device");
    }
}
