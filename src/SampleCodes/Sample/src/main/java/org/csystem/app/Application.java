package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.string.StringUtil;
import org.csystem.util.thread.ThreadUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void createThreadCallback(int i, String pathBase, long count, int min, int max)
    {
        var tg = new TextGenerator("%s-%d".formatted(pathBase, i + 1), new Random(), count, min, max);
        var t = new Thread(tg);

        //t.setDaemon(true);
        t.start();
    }

    public static void run(String[] args)
    {
        try {
            var self = Thread.currentThread();

            Console.writeLine("'%s' thread is %s", self.getName(), self.isDaemon() ? "daemon" : "non-daemon");
            checkLengthEquals(args.length, 5, "Wrong number of arguments");
            var numberOfFiles = Integer.parseInt(args[1]);
            var count = Long.parseLong(args[2]);
            var min = Integer.parseInt(args[3]);
            var max = Integer.parseInt(args[4]);

            IntStream.range(0, numberOfFiles)
                    .forEach(i -> createThreadCallback(i, args[0], count, min, max));

            ThreadUtil.sleep(10000);

            Console.writeLine("run ends!...");
        }
        catch (NumberFormatException ignore) {
            Console.Error.writeLine("Invalid values!...");
        }
        catch (UncheckedIOException e) {
            Console.Error.writeLine("IO Error occurred :%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}

class TextGenerator implements Runnable {
    private final String m_path;
    private final RandomGenerator m_randomGenerator;
    private final long m_count;
    private final int m_min;
    private final int m_max;

    private void generateCallback(BufferedWriter bw)
    {
        try {
            bw.write("%s\r\n".formatted(StringUtil.randomTextTR(m_randomGenerator, m_randomGenerator.nextInt(m_min, m_max + 1))));
        }
        catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public TextGenerator(String path, RandomGenerator randomGenerator, long count, int min, int max)
    {
        m_path = path;
        m_randomGenerator = randomGenerator;
        m_count = count;
        m_min = min;
        m_max = max;
    }

    @Override
    public void run()
    {
        var self = Thread.currentThread();

        self.setDaemon(true);
        Console.writeLine("'%s' thread is %s", self.getName(), self.isDaemon() ? "daemon" : "non-daemon");
        try (var bw = Files.newBufferedWriter(Path.of(m_path), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            LongStream.rangeClosed(0, m_count)
                    .forEach(i -> generateCallback(bw));
        }
        catch (IOException e) {
            throw new UncheckedIOException(e.getMessage(), e);
        }
    }
}