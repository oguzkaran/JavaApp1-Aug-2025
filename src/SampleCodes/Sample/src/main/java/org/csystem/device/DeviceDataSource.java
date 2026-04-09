package org.csystem.device;

import org.csystem.util.string.StringUtil;

import java.util.Random;
import java.util.random.RandomGenerator;

public class DeviceDataSource {
    private final RandomGenerator m_randomGenerator = new Random();

    private String getHost()
    {
        return "%d.%d.%d.%d".formatted(m_randomGenerator.nextInt(0, 256),
                m_randomGenerator.nextInt(0, 256), m_randomGenerator.nextInt(0, 256),  m_randomGenerator.nextInt(0, 256));
    }

    private Object getOptionalData()
    {
        return m_randomGenerator.nextBoolean() ? StringUtil.randomText(m_randomGenerator, m_randomGenerator.nextInt(4, 6), "_?:=)_") : null;
    }

    private Object getData()
    {
        return m_randomGenerator.nextInt(-1000, 1000);
    }

    public DeviceData fecthDeviceData()
    {
        return DeviceData.builder()
                .name(StringUtil.randomTextEN(m_randomGenerator, m_randomGenerator.nextInt(5, 15)))
                .host(getHost())
                .port(m_randomGenerator.nextInt(1024, 65536))
                .data(getData())
                .build();
    }
}
