package org.csystem.framework.commandprompt.annotation;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Commands {
    Command [] value();
}
