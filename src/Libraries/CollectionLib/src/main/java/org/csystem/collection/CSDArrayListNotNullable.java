package org.csystem.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CSDArrayListNotNullable<E> extends ArrayList<E> {
    public CSDArrayListNotNullable()
    {

    }

    public CSDArrayListNotNullable(int initialCapacity)
    {
        super(initialCapacity);
    }

    public CSDArrayListNotNullable(Collection<? extends E> c)
    {
        throw new UnsupportedOperationException("TODO:");
    }

    @Override
    public boolean add(E e)
    {
        //...

        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        //...
        return super.addAll(c);
    }

    //...
}
