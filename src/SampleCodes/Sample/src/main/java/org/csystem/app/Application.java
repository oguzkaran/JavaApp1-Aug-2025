package org.csystem.app;

import com.karandev.io.util.console.Console;

class Application {
    public static void run(String[] args)
    {
        var a = new A();
        var b = a.new B();

        b.foo();
    }
}

class A {
    public class B {
        //...

        public void foo()
        {
            Console.writeLine("A.B.foo");
        }

        public static void bar()
        {
            Console.writeLine("A.B.bar");
        }
    }
}