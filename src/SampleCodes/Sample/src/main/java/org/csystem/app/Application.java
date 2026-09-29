package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
class Application {
    private static int continueOptionGeneratorCallback()
    {
        return IntStream.generate(() -> Console.readInt("Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz]"))
                .filter(o -> o ==  0 || o == 1)
                .findFirst().orElse(0);
    }

    private static boolean notValidFlow()
    {
        Console.writeLine("Geçersiz değer girdiniz!...Yeni bir değer giriniz:");

        return false;
    }

    private static boolean obtainValidValueCallback(int v)
    {
        return (0 <= v) && (v <= 100) || notValidFlow();
    }

    private static int obtainValueCallback()
    {
        return IntStream.generate(() -> Console.readInt("Bir tamsayı giriniz:"))
                .filter(Application::obtainValidValueCallback)
                .findFirst().orElse(0);
    }

    public static void run(String[] args)
    {
        var statistics = IntStream.generate(Application::continueOptionGeneratorCallback)
                .takeWhile(o -> o == 1)
                .map(ign -> obtainValueCallback())
                .summaryStatistics();

        var count = statistics.getCount();

        Console.writeLine("Toplam %d değer girildi", count);
        if (count > 0)
            Console.writeLine("Max:%d%nMin:%d%nOrtalama:%.6f", statistics.getMax(), statistics.getMin(), statistics.getAverage());
    }
}