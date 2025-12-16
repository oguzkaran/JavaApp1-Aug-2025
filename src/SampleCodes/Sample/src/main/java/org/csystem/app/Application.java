package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var value = Console.readInt("Input a number:");

        Console.writeLine(Util.doOperation(10, 20, (int a, int b) -> a + b + value));
        Console.writeLine(Util.doOperation(10, 20, (double a, double b) -> a + b + value));
    }
}

class Util {
    public static int doOperation(int a, int b, IIntBinaryOperator binaryOperator)
    {
        Console.writeLine("int -> %d, %d", a, b);

        return binaryOperator.applyAsInt(a, b);
    }

    public static double doOperation(double a, double b, IDoubleBinaryOperator binaryOperator)
    {
        Console.writeLine("double -> %f, %f", a, b);

        return binaryOperator.applyAsDouble(a, b);
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);
}

interface IDoubleBinaryOperator {
    double applyAsDouble(double a, double b);
}

