package org.csystem.app;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
class Application {
    public static void run(String[] args)
    {
        Object [] objects = {"ankara", 10, 2.3, new Random()};

        A<String> a = new A<>(objects);

        for (int i = 0; i < a.size(); ++i)
            log.info("a[{}] = {}", i, a.get(i).toUpperCase());
    }
}

class A<T> {
    private final T [] m_t;
    private int m_index;

    public A(Object [] objects)
    {
        m_t = (T []) objects;
    }

    public int size()
    {
        return m_t.length;
    }

    public boolean add(T t)
    {
        if (m_index == m_t.length)
            return false;

        m_t[m_index++] = t;

        return true;
    }

    public T get(int index)
    {
        //...
        return m_t[index];
    }
}


class B<T> {
    private final T [] m_t;
    private int m_index;

    @SuppressWarnings("unchecked")
    public B(int size)
    {
        m_t = (T []) new Object[size];
    }

    public int size()
    {
        return m_t.length;
    }

    public boolean add(T t)
    {
        if (m_index == m_t.length)
            return false;

        m_t[m_index++] = t;

        return true;
    }

    public T get(int index)
    {
        //...
        return m_t[index];
    }
}
