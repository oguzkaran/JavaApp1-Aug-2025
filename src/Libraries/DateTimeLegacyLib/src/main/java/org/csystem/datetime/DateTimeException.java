package org.csystem.datetime;

@Deprecated(forRemoval = true, since = "2.0.0")
public class DateTimeException extends RuntimeException  {
    public DateTimeException()
    {}

    public DateTimeException(String msg)
    {
        super(msg);
    }
}
