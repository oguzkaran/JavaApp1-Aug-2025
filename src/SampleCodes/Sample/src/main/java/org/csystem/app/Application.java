package org.csystem.app;

import com.karandev.io.util.console.Console;
import org.csystem.util.thread.ThreadUtil;

import java.util.Random;

//App.jar -> uses XLib, ALib, BLib, CLib
class Application {
    public static void run(String[] args)
    {
        var factory = new XFactory();
        var random = new Random();

        while (true) {
            Console.writeLine("------------------------------------");
            var ix = factory.create();
            Console.writeLine("Dynamic type:%s", ix.getClass().getName());
            var a = random.nextInt(-10, 10);
            var b = random.nextInt(-10, 10);
            ix.foo(a, b);
            Console.writeLine("------------------------------------");
            ThreadUtil.sleep(1000);
        }
    }
}


//Alib.jar uses XLib
class A extends X {
    @Override
    public void foo(int a, long b)
    {
        Console.writeLine("A -> a = %d, b = %d", a, b);
    }
}

//Clib.jar uses XLib
class C extends X {
    @Override
    public void foo(int a, long b)
    {
        Console.writeLine("C -> a = %d, b = %d", a, b);
    }
}

//Blib.jar uses XLib
class B extends X {
    @Override
    public void foo(int a, long b)
    {
        Console.writeLine("B -> a = %d, b = %d", a, b);
    }
}

//Xlib.jar
class XFactory {
    private final Random m_random = new Random();

    public X create()
    {
        return switch (m_random.nextInt(1, 4)) {
            case 1 -> new A();
            case 2 -> new B();
            default -> new C();
        };
    }
}

class X {
    public void foo(int a, long b)
    {
        Console.writeLine("X -> a = %d, b = %d", a, b);
    }
    //...
}

