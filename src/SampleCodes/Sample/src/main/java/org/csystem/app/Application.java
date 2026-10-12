package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.util.datasource.factory.PersonFactory;
import org.csystem.util.datasource.people.MaritalStatus;
import org.csystem.util.datasource.people.Person;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static com.karandev.io.util.console.CommandLineArgs.checkLengthEquals;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            checkLengthEquals(args.length, 1, "Wrong number of arguments");
            var factory = PersonFactory.loadFromTextFile(args[0]);
            var peopleMap = factory.PEOPLE.stream().collect(Collectors.groupingBy(Person::getMaritalStatus,
                    () -> new TreeMap<>(Comparator.comparing(MaritalStatus::toString)), Collectors.toUnmodifiableSet()));

            peopleMap.forEach((ms, pl) -> pl.forEach(p -> Console.writeLine("%s->%s", p.getName(), ms)));
        }
        catch (IOException e) {
            Console.Error.writeLine("IO error occurred:%s", e.getMessage());
        }
        catch (Exception e) {
            Console.Error.writeLine("Error occurred :%s", e.getMessage());
        }
    }
}