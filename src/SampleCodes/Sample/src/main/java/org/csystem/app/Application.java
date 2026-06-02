package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
class Application {
    private static void carInfoListCallback(String plate, ArrayList<CarInfo> carInfoList)
    {
        Console.write("%s -> ", plate);
        carInfoList.forEach(c -> Console.write("%s ", c.getDate()));
        Console.writeLine();
    }

    public static void run(String[] args)
    {
        HashMap<String, ArrayList<CarInfo>> carMap = new HashMap<>();

        while (true) {
            String plate = Console.read("Input plate:");

            if (plate.equals("exit"))
                break;

            if (carMap.containsKey(plate)) {
                carMap.get(plate).add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
            }
            else {
                ArrayList<CarInfo> list = new ArrayList<>();

                list.add(CarInfo.builder().plate(plate).date(LocalDateTime.now()).build());
                carMap.put(plate, list);
            }
        }

        carMap.keySet().forEach(p -> carInfoListCallback(p, carMap.get(p)));
    }
}

@Getter
@Setter
@Accessors(prefix = "m_")
@Builder
class CarInfo {
    private String m_plate;
    private LocalDateTime m_date;
    //...
}