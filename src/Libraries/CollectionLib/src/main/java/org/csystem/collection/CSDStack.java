package org.csystem.collection;

import java.util.ArrayList;
import java.util.List;

public class CSDStack<E> {
    private final List<E> m_list = new ArrayList<>();

    public CSDStack()
    {
    }

    public E peek()
    {
        return this.m_list.get(this.m_list.size() - 1);
    }

    public E pop()
    {
        return m_list.remove(m_list.size() - 1);
    }

    public E push(E item)
    {
        m_list.add(item);

        return item;
    }

    public int search(E item)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
