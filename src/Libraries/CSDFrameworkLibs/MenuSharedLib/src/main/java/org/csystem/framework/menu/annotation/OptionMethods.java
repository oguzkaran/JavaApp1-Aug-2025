package org.csystem.framework.menu.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionMethods {
    String optionString() default "optionString";
    String name() default "name";
    String doOption() default "doOption";
}
