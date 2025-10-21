package org.csystem.app;

import java.util.Scanner;

class Application {
    public static void run(String[] args)
    {
        var kb = new Scanner(System.in);

        System.out.print("Input values until zero:");
        var total = 0;
        int val;

        while ((val = kb.nextInt()) != 0)
            total += val;


        System.err.printf("%nError -> Total = %d%n", total);
        System.out.printf("Output -> Total = %d%n", total);
    }
}

