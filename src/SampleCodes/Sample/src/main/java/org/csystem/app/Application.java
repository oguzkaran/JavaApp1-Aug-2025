package org.csystem.app;

import lombok.extern.slf4j.Slf4j;
import org.csystem.reflect.ReflectionUtil;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Slf4j
class Application {
    private static void methodCallback(Method method)
    {
        var commands = method.getDeclaredAnnotationsByType(Command.class);

        if (commands.length != 0) {
            log.info("{} method annotated with @Command", method.getName());
            for (var command : commands)
                log.info("value:{}", command.value());
        }
        else
            log.info("{} method not annotated with @Command", method.getName());
    }

    public static void run(String[] args)
    {
        var clsSample = Sample.class;

        log.info("All annotations:");

        for (Annotation annotation : clsSample.getDeclaredAnnotations())
            log.info(annotation.getClass().getTypeName());

        MyAnnotation [] myAnnotations = clsSample.getDeclaredAnnotationsByType(MyAnnotation.class);

        log.info("@MyAnnotation status:");
        if (myAnnotations.length != 0)
            for (MyAnnotation myAnnotation : myAnnotations)
                log.info("value:{}, message:{}", myAnnotation.value(), myAnnotation.message());
        else
            log.info("Not annotated with @MyAnnotation");

        ReflectionUtil.doWithDeclaredMethods(clsSample, Application::methodCallback);
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    int value() default 0;
    String message() default "default message";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotations {
    MyAnnotation[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface YourAnnotation {
    //...
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@MyAnnotation(value = 45, message = "Manisa")
@interface TheirAnnotation {
    //...
}

@MyAnnotation(67)
@MyAnnotation(value = 34, message = "istanbul")
@YourAnnotation
@TheirAnnotation
@Slf4j
class Sample {
    @Command("test")
    @Command
    @Command("foo")
    public void foo()
    {
        //...
    }

    @Commands({@Command, @Command("mest")})
    public void bar()
    {
        //...
    }

    public void tar()
    {
        //...
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(Commands.class)
@interface Command {
    String value() default "";
}
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@interface Commands {
    Command [] value();
}