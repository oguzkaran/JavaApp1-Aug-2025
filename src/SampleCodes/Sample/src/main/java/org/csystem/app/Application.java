package org.csystem.app;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        try {
            var cls = Singleton.class;
            var ctor = cls.getDeclaredConstructor();

            ctor.setAccessible(true);
            var s = ctor.newInstance();
            ctor.setAccessible(false);

            s.setValue(10);

            log.info("Value:{}", s.getValue());
        }
        catch (NoSuchMethodException e) {
            log.error("No such constructor");
        }
        catch (InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException e) {
            log.error("Exception occurred:{}, Message:{}{}", e.getClass().getSimpleName(), e.getMessage(), e.getCause() != null ? "Cause Message: " + e.getCause().getMessage() : "");
        }
    }
}

enum Singleton {
    INSTANCE;
    private int m_value;

    public int getValue()
    {
        return m_value;
    }

    public void setValue(int value)
    {
        m_value = value;
    }
}