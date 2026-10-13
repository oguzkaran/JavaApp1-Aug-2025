package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.StudentFactory;
import org.csystem.util.datasource.student.Score;
import org.csystem.util.datasource.student.StudentInfo;

import java.io.IOException;
import java.nio.file.Path;
import java.util.TreeMap;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Slf4j
class Application {
    private static Score groupingByKeyCallback(StudentInfo studentInfo)
    {
        var grade = studentInfo.getMidtermGrade() * 0.4 + studentInfo.getFinalGrade() * 0.6;

        return Score.findScoreByGrade(grade);
    }

    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var factory = StudentFactory.loadFromTextFile(Path.of(args[0]));
            var studentMap = factory.STUDENTS.stream()
                            .collect(groupingBy(Application::groupingByKeyCallback, TreeMap::new, counting()));

            studentMap.forEach((sc, c) -> Console.writeLine("%s: %s", sc, c));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}