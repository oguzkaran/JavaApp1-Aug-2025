package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        A.B.bar();
    }
}

class A {
    public static void bar()
    {
        Console.writeLine("A.bar");
    }

    public static class B {
        //...
        public static void bar()
        {
            Console.writeLine("A.B.bar");
            A.bar(); //***
        }
    }
}

