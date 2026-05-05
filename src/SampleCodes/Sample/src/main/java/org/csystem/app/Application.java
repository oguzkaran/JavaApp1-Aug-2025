package org.csystem.app;

import lombok.extern.slf4j.Slf4j;
import org.csystem.game.lottery.NumericLottery;
import org.csystem.util.array.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        Random random = new Random();
        Scanner kb = new Scanner(System.in);
        NumericLottery numericLottery = new NumericLottery(random);

        while (true) {
            System.out.print("Input count:");
            int count = Integer.parseInt(kb.nextLine());

            if (count <= 0)
                break;

            ArrayUtil.print(numericLottery.getNumbers(count), 2);
        }
    }
}