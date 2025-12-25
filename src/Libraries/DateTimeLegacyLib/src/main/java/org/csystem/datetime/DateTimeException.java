package org.csystem.datetime;

@Deprecated(forRemoval = true, since = "8")
public class DateTimeException extends RuntimeException  {
    public DateTimeException()
    {}

    public DateTimeException(String msg)
    {
        super(msg);
    }
}
