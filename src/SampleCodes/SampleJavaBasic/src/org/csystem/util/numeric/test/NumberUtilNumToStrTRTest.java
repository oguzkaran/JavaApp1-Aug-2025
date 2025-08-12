package org.csystem.util.numeric.test;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.numeric.NumberUtil.numToStrTR;

public class NumberUtilNumToStrTRTest {
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Bir sayı giriniz:");
        int n = kb.nextInt();

        for (int i = 0; i < n; ++i) {
            long val = r.nextLong();

            System.out.printf("%d -> ", val);
            System.out.printf("(%s)%n", numToStrTR(val));
        }
        long a = 0;
        System.out.printf("%d -> ", 0);
        System.out.printf("(%s)%n", numToStrTR(0));

        a = -109;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));

        a = 1923;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));
        a = 3923;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));

        a = -1;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));

        a = 1_000_001;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));

        a = 1_001;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));

        a = 1_000_000_000_001L;
        System.out.printf("%d -> ", a);
        System.out.printf("(%s)%n", numToStrTR(a));
    }

    public static void main(String[] args)
    {
        run();
    }
}
