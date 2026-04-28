package org.csystem.app;

import com.karandev.io.util.console.Console;
import lombok.extern.slf4j.Slf4j;
import org.csystem.device.DeviceData;
import org.csystem.device.DeviceDataSource;

import java.util.ArrayDeque;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        var threshold = Console.readInt("Input threshold:");
        var arrayDeque = new ArrayDeque<DeviceData>();
        var deviceDataSource = new DeviceDataSource();

        while (true) {
            var name = Console.read("Input name:");

            if ("quit".equals(name))
                break;

            var device = deviceDataSource.fetchIntDeviceData(name);

            if ((int)device.getData() < threshold)
                arrayDeque.addFirst(device);
            else
                arrayDeque.addLast(device);

            Console.writeLine("Device:%s", device);
        }

        Console.writeLine("All devices:");
        arrayDeque.forEach(Console::writeLine);
    }
}