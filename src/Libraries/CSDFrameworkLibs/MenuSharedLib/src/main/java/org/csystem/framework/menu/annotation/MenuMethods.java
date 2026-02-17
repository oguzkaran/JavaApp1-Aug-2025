package org.csystem.framework.menu.annotation;

public @interface MenuMethods {
    String menuName() default "";
    String optionString() default "";
    String doOOption() default "";
}
