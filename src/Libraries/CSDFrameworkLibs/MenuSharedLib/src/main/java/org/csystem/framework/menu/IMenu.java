package org.csystem.framework.menu;

public interface IMenu {
    int order();
    String optionString();
    String name();
    void doOption();
}
