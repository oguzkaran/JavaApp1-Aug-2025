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
        throw new UnsupportedOperationException("TODO");
    }
}
