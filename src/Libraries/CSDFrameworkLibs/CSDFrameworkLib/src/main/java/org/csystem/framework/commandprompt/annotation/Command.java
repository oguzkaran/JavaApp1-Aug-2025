package org.csystem.framework.commandprompt.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Commands.class)
public @interface Command {
    String value() default "";
}

