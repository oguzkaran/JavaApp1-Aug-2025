package org.csystem.tuple;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public static <F, S> Pair<F, S> of(F first, S second)
    {
        return new Pair<>(first, second);
    }

    public Pair(F first, S second)
    {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object other)
    {
        return other instanceof Pair<?, ?> p && this.first.equals(p.first) && this.second.equals(p.second);
    }

    public String toString()
    {
        return "(%s, %s)".formatted(first, second);
    }
    //...
}
