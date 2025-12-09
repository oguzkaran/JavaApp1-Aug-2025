package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var value = Console.readInt("Input a number:");
        var addOp1 = new AddOperator(value);

        Console.writeLine(Util.doOperation(10, 20, addOp1));

        var addOp2 = new IIntBinaryOperator() {
            public int applyAsInt(int a, int b)
            {
                return a * b * value;
            }
        };

        Console.writeLine(Util.doOperation(10, 20, addOp2));

        Console.writeLine(Util.doOperation(10, 20, (a, b) -> a + b + value));
    }
}

class AddOperator implements IIntBinaryOperator {
    private final int m_value;

    public AddOperator(int value)
    {
        m_value = value;
    }

    public int applyAsInt(int a, int b)
    {
        return a + b + m_value;
    }
}

class Util {
    public static int doOperation(int a, int b, IIntBinaryOperator binaryOperator)
    {
        Console.writeLine("%d, %d", a, b);

        return binaryOperator.applyAsInt(a, b);
    }
}

interface IIntBinaryOperator {
    int applyAsInt(int a, int b);

}

interface IIntSupplier {
    int get();
}

interface IIntUnaryConsumer {
    void accept(int a);
}

interface IIntUnaryPredicate {
    boolean test(int a);
}