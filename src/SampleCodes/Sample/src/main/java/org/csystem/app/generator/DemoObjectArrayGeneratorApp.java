package org.csystem.app.generator;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.math.Complex;
import org.csystem.math.geometry.Circle;
import org.csystem.math.geometry.Point;

import java.util.Random;
import java.util.random.RandomGenerator;

@Slf4j
public class DemoObjectArrayGeneratorApp {
    public  static void run()
    {
        var count = Console.readInt("Input count:");

        var generator = new ObjectArrayGenerator();

        for (var o : generator.createObjectArray(count)) {
            log.info("----------------------------------------------------");
            log.info("Dynamic type: {}", o.getClass().getName());

            switch (o) {
                case Point p -> log.info("Distance to origin of {} is {}", p.toString(), p.euclideanDistance());
                case Complex c -> log.info("Norm of {} is {}", c.toString(), c.getNorm());
                case Circle c -> log.info("Radius:{}, Area:{}", c.getRadius(), c.getArea());
                case String s -> log.info("Text:{}, Upper:{}", s, s.toUpperCase());
                case Integer i -> {int a = i; log.info("{} * {} = {}", a, a, a * a);}
                case Character c -> {char ch = c; log.info("ch = {}, lower: {}", ch, Character.toLowerCase(ch));}
                case Double d -> {double a = d; log.info("{} + {} = {}", a, a, a + a);}
                case Boolean b -> {boolean flag = b; log.info("flag = {}, !flag = {}", flag, !flag);}
                default -> {RandomGenerator orandomGenerator = (Random) o; log.info("Random number:{}", orandomGenerator.nextInt()); }
            }

            log.info("----------------------------------------------------");
        }
    }
}
