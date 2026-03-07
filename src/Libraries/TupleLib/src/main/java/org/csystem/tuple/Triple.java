package org.csystem.tuple;

public class Triple<F, S, T> {
    public final F first;
    public final S second;
    public final T third;

    public static <F, S, T> Triple<F, S, T> of(F first, S second, T third)
    {
        return new Triple<>(first, second, third);
    }

    public Triple(F first, S second, T third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof Triple<?, ?, ?> t && this.first.equals(t.first) && this.second.equals(t.second)
                && this.third.equals(t.third);
    }

    @Override
    public String toString()
    {
        return "(%s, %s, %s)".formatted(first, second, third);
    }
    //...
}
