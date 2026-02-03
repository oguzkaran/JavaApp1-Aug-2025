package org.csystem.plugin;

public interface IMenu {
    int order();

    String optionString();

    String name();

    void doOption();
}
