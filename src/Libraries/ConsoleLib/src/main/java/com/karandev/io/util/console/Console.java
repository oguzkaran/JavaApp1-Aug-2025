package com.karandev.io.util.console;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Utility class for standard input, standard output and standard error operations.
 *
 * <p>Provides static methods for reading and writing various data types
 * (primitive types, {@link String}, {@link BigDecimal}, {@link BigInteger})
 * from/to standard input, output, and error streams.
 * Includes error handling and formatting support.
 *
 * <p>Copyleft (c) 1993 by C and System Programmers Association (CSD)
 * All Rights Free
 *
 * @author CSD Development Group
 */
public final class Console {
    private static final Scanner ms_kb;

    static {
        ms_kb = new Scanner(System.in);
    }

    private Console()
    {
    }

    /**
     * Nested class for writing various data types and formatted output to
     * the standard error stream.
     *
     * <p>Provides static methods to print various data types (primitive types,
     * {@link String}, {@link Object}), and their bit representations
     * to {@code System.err}, with support for formatting and writing newlines.
     */
    public static final class Error {
        private Error()
        {
        }

        /**
         * Writes a boolean value to standard error.
         *
         * @param b the boolean value to be written to standard error
         */
        public static void write(boolean b)
        {
            write("%b", b);
        }

        /**
         * Writes an int value to standard error.
         *
         * @param val the int value to be written to standard error
         */
        public static void write(int val)
        {
            write("%d", val);
        }

        /**
         * Writes an int value in the specified radix to standard error.
         *
         * @param val the int value to be written to standard error
         * @param radix the number base to use for conversion
         */
        public static void write(int val, int radix)
        {
            write("%s", Integer.toString(val, radix));
        }

        /**
         * Writes a long value to standard error.
         *
         * @param val the long value to be written to standard error
         */
        public static void write(long val)
        {
            write("%d", val);
        }

        /**
         * Writes a long value in the specified radix to standard error.
         *
         * @param val the long value to be written
         * @param radix the number base to use for conversion
         */
        public static void write(long val, int radix)
        {
            write("%s", Long.toString(val, radix));
        }

        /**
         * Writes a char to standard error.
         *
         * @param ch the char to be written to standard error
         */
        public static void write(char ch)
        {
            write("%c", ch);
        }

        /**
         * Writes a double value to standard error.
         *
         * @param val the double value to be written to standard error
         */
        public static void write(double val)
        {
            write("%f", val);
        }

        /**
         * Writes a float value to standard error.
         *
         * @param val the float value to be written to standard error
         */
        public static void write(float val)
        {
            write("%f", val);
        }

        /**
         * Writes a string to the standard error stream.
         *
         * @param s the string to be written to standard error
         */
        public static void write(String s)
        {
            write("%s", s);
        }

        /**
         * Writes each char in the specified array to the standard error stream.
         *
         * @param c the array of char to be written to standard error
         */
        public static void write(char [] c)
        {
            for (char ch : c)
                write(ch);
        }

        /**
         * Writes the string representation of the specified {@link Object} to the standard error stream.
         *
         * @param obj the {@link Object} to be written to standard error
         */
        public static void write(Object obj)
        {
            write("%s", obj);
        }

        /**
         * Writes a formatted {@link Object} arguments to the standard error stream.
         *
         * @param fmt the format string
         * @param objects the arguments referenced by the format specifiers in the format string
         */
        public static void write(String fmt, Object...objects)
        {
            System.err.printf(fmt, objects);
        }

        /**
         * Writes a newline to standard error.
         */
        public static void writeLine()
        {
            write("\n");
        }

        /**
         * Writes a boolean value followed by a newline to standard error.
         *
         * @param b the boolean value to be written to standard error
         */
        public static void writeLine(boolean b)
        {
            writeLine("%b", b);
        }

        /**
         * Writes an int value followed by a newline to standard error.
         *
         * @param val the int value to be written to standard error
         */
        public static void writeLine(int val)
        {
            writeLine("%d", val);
        }

        /**
         * Writes a long value followed by a newline to standard error.
         *
         * @param val the long value to be written to standard error
         */
        public static void writeLine(long val)
        {
            writeLine("%d", val);
        }

        /**
         * Writes a char followed by a newline to standard error.
         *
         * @param ch the char to be written to standard error
         */
        public static void writeLine(char ch)
        {
            writeLine("%c", ch);
        }

        /**
         * Writes a double value followed by a newline to standard error.
         *
         * @param val the double value to be written to standard error
         */
        public static void writeLine(double val)
        {
            writeLine("%f", val);
        }

        /**
         * Writes a float value followed by a newline to standard error.
         *
         * @param val the float value to be written to standard error
         */
        public static void writeLine(float val)
        {
            writeLine("%f", val);
        }

        /**
         * Writes a {@link String} followed by a newline to standard error.
         *
         * @param s the {@link String} to be written to standard error
         */
        public static void writeLine(String s)
        {
            writeLine("%s", s);
        }

        /**
         * Writes a char array followed by a newline to standard error.
         *
         * @param c the array of char to be written to standard error
         */
        public static void writeLine(char [] c)
        {
            for (char ch : c)
                writeLine(ch);
        }

        /**
         * Writes an {@link Object} followed by a newline to standard error.
         *
         * @param obj the {@link Object} to be written to standard error
         */
        public static void writeLine(Object obj)
        {
            writeLine("%s", obj);
        }

        /**
         * Writes a formatted {@link Object} arguments followed by a newline to standard error.
         *
         * @param fmt the format string
         * @param objects the arguments referenced by the format specifiers in the format string
         */
        public static void writeLine(String fmt, Object...objects)
        {
            write(fmt + "\n", objects);
        }

        /**
         * Writes the bit representation of a char value to standard error.
         *
         * @param val the char value whose bits will be written
         */
        public static void writeBits(char val)
        {
            for (int k = 15; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        /**
         * Writes the bit representation of a byte value to standard error.
         *
         * @param val the byte value whose bits will be written
         */
        public static void writeBits(byte val)
        {
            for (int k = 7; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        /**
         * Writes the bit representation of a short value to standard error.
         *
         * @param val the short value whose bits will be written
         */
        public static void writeBits(short val)
        {
            for (int k = 15; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        /**
         * Writes the bit representation of an int value to standard error.
         *
         * @param val the int value whose bits will be written
         */
        public static void writeBits(int val)
        {
            for (int k = 31; k >= 0; --k)
                write((val & 1 << k) != 0 ? 1 : 0);

            writeLine();
        }

        /**
         * Writes the bit representation of a long value to standard error.
         *
         * @param val the long value whose bits will be written
         */
        public static void writeBits(long val)
        {
            for (int k = 63; k >= 0; --k)
                write((val & 1L << k) != 0 ? 1 : 0);

            writeLine();
        }
    }

    /**
     * Reads a byte value from standard input.
     *
     * @return the byte value read
     */
    public static byte readByte()
    {
        return readByte("");
    }

    /**
     * Reads a byte value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the byte value read
     */
    public static byte readByte(String msg)
    {
        return readByte(msg, "");
    }

    /**
     * Reads a byte value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the byte value read
     */
    public static byte readByte(String msg, String errMsg)
    {
        return readByte(msg, 10, errMsg);
    }

    /**
     * Reads a byte value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the byte value read
     */
    public static byte readByteLine(String msg)
    {
        return readByte(msg + "\n", "");
    }

    /**
     * Reads a byte value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the byte value read
     */
    public static byte readByteLine(String msg, String errMsg)
    {
        return readByte(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a byte value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the byte value read
     */
    public static byte readByte(int radix)
    {
        return readByte("", radix);
    }

    /**
     * Reads a byte value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the byte value read
     */
    public static byte readByte(String msg, int radix)
    {
        return readByte(msg, radix, "");
    }

    /**
     * Reads a byte value from standard input with prompt, radix, and error messages.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the byte value read
     */
    public static byte readByte(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Byte.parseByte(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a byte value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the byte value read
     */
    public static byte readByteLine(String msg, int radix)
    {
        return readByte(msg + "\n", radix, "");
    }

    /**
     * Reads a byte value from standard input with prompt, radix, and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the byte value read
     */
    public static byte readByteLine(String msg, int radix, String errMsg)
    {
        return readByte(msg + "\n", radix, errMsg + "\n");
    }

    /**
     * Reads a short value from standard input.
     *
     * @return the short value read
     */
    public static short readShort()
    {
        return readShort("");
    }

    /**
     * Reads a short value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the short value read
     */
    public static short readShort(String msg)
    {
        return readShort(msg, "");
    }

    /**
     * Reads a short value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the short value read
     */
    public static short readShort(String msg, String errMsg)
    {
        return readShort(msg, 10, errMsg);
    }

    /**
     * Reads a short value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the short value read
     */
    public static short readShortLine(String msg)
    {
        return readShort(msg + "\n", "");
    }

    /**
     * Reads a short value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the short value read
     */
    public static short readShortLine(String msg, String errMsg)
    {
        return readShort(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a short value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the short value read
     */
    public static short readShort(int radix)
    {
        return readShort("", radix);
    }

    /**
     * Reads a short value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the short value read
     */
    public static short readShort(String msg, int radix)
    {
        return readShort(msg, radix, "");
    }

    /**
     * Reads a short value from standard input with prompt, radix, and error messages.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the short value read
     */
    public static short readShort(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Short.parseShort(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a short value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the short value read
     */
    public static short readShortLine(String msg, int radix)
    {
        return readShort(msg + "\n", radix, "");
    }

    /**
     * Reads a short value from standard input with prompt, radix, and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the short value read
     */
    public static short readShortLine(String msg, int radix, String errMsg)
    {
        return readShort(msg + "\n", radix, errMsg + "\n");
    }

    /**
     * Reads an int value from standard input.
     *
     * @return the int value read
     */
    public static int readInt()
    {
        return readInt("");
    }

    /**
     * Reads an int value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the int value read
     */
    public static int readInt(String msg)
    {
        return readInt(msg, "");
    }

    /**
     * Reads an int value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the int value read
     */
    public static int readInt(String msg, String errMsg)
    {
        return readInt(msg, 10, errMsg);
    }

    /**
     * Reads an int value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the int value read
     */
    public static int readIntLine(String msg)
    {
        return readInt(msg + "\n", "");
    }

    /**
     * Reads an int value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the int value read
     */
    public static int readIntLine(String msg, String errMsg)
    {
        return readInt(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads an int value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the int value read
     */
    public static int readInt(int radix)
    {
        return readInt("", radix);
    }

    /**
     * Reads an int value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the int value read
     */
    public static int readInt(String msg, int radix)
    {
        return readInt(msg, radix, "");
    }

    /**
     * Reads an int value from standard input with prompt, radix, and error messages.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the int value read
     */
    public static int readInt(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseInt(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads an int value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the int value read
     */
    public static int readIntLine(String msg, int radix)
    {
        return readInt(msg + "\n", radix, "");
    }

    /**
     * Reads an int value from standard input with prompt, radix, and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the int value read
     */
    public static int readIntLine(String msg, int radix, String errMsg)
    {
        return readInt(msg + "\n", radix, errMsg + "\n");
    }

    /**
     * Reads an unsigned int value from standard input.
     *
     * @return the unsigned int value read
     */
    public static int readUInt()
    {
        return readUInt("");
    }

    /**
     * Reads an unsigned int value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the unsigned int value read
     */
    public static int readUInt(String msg)
    {
        return readUInt(msg, "");
    }

    /**
     * Reads an unsigned int value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the unsigned int value read
     */
    public static int readUInt(String msg, String errMsg)
    {
        return readUInt(msg, 10, errMsg);
    }

    /**
     * Reads an unsigned int value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the unsigned int value read
     */
    public static int readUIntLine(String msg)
    {
        return readUInt(msg + "\n", "");
    }

    /**
     * Reads an unsigned int value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the unsigned int value read
     */
    public static int readUIntLine(String msg, String errMsg)
    {
        return readUInt(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads an unsigned int value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the unsigned int value read
     */
    public static int readUInt(int radix)
    {
        return readUInt("", radix);
    }

    /**
     * Reads an unsigned int value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the unsigned int value read
     */
    public static int readUInt(String msg, int radix)
    {
        return readUInt(msg, radix, "");
    }

    /**
     * Reads an unsigned int value from standard input with prompt, radix, and error messages.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the unsigned int value read
     */
    public static int readUInt(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Integer.parseUnsignedInt(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads an unsigned int value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the unsigned int value read
     */
    public static int readUIntLine(String msg, int radix)
    {
        return readUInt(msg + "\n", radix, "");
    }

    /**
     * Reads an unsigned int value from standard input with prompt, radix, and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the unsigned int value read
     */
    public static int readUIntLine(String msg, int radix, String errMsg)
    {
        return readUInt(msg + "\n", radix, errMsg + "\n");
    }

    /**
     * Reads a long value from standard input.
     *
     * @return the long value read
     */
    public static long readLong()
    {
        return readLong("");
    }

    /**
     * Reads a long value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the long value read
     */
    public static long readLong(String msg)
    {
        return readLong(msg, "");
    }

    /**
     * Reads a long value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the long value read
     */
    public static long readLong(String msg, String errMsg)
    {
        return readLong(msg, 10, errMsg);
    }

    /**
     * Reads a long value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the long value read
     */
    public static long readLongLine(String msg)
    {
        return readLong(msg + "\n", "");
    }

    /**
     * Reads a long value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the long value read
     */
    public static long readLongLine(String msg, String errMsg)
    {
        return readLong(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a long value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the long value read
     */
    public static long readLong(int radix)
    {
        return readLong("", radix);
    }

    /**
     * Reads a long value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the long value read
     */
    public static long readLong(String msg, int radix)
    {
        return readLong(msg, radix, "");
    }

    /**
     * Reads a long value from standard input with prompt, radix, and error messages.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the long value read
     */
    public static long readLong(String msg, int radix, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseLong(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a long value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the long value read
     */
    public static long readLongLine(String msg, int radix)
    {
        return readLong(msg + "\n", radix, "");
    }

    /**
     * Reads a long value from standard input with prompt, radix, and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @param errMsg error message
     * @return the long value read
     */
    public static long readLongLine(String msg, int radix, String errMsg)
    {
        return readLong(msg + "\n", radix, errMsg + "\n");
    }

    /**
     * Reads an unsigned long value from standard input.
     *
     * @return the unsigned long value read
     */
    public static long readULong()
    {
        return readULong("");
    }

    /**
     * Reads an unsigned long value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the unsigned long value read
     */
    public static long readULong(String msg)
    {
        return readULong(msg, "");
    }

    /**
     * Reads an unsigned long value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the unsigned long value read
     */
    public static long readULong(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Long.parseUnsignedLong(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads an unsigned long value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the unsigned long value read
     */
    public static long readULongLine(String msg)
    {
        return readULong(msg + "\n", "");
    }

    /**
     * Reads an unsigned long value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the unsigned long value read
     */
    public static long readULongLine(String msg, String errMsg)
    {
        return readULong(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a double value from standard input.
     *
     * @return the double value read
     */
    public static double readDouble()
    {
        return readDouble("");
    }

    /**
     * Reads a double value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the double value read
     */
    public static double readDouble(String msg)
    {
        return readDouble(msg, "");
    }

    /**
     * Reads a double value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the double value read
     */
    public static double readDouble(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Double.parseDouble(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a double value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the double value read
     */
    public static double readDoubleLine(String msg)
    {
        return readDouble(msg + "\n", "");
    }

    /**
     * Reads a double value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the double value read
     */
    public static double readDoubleLine(String msg, String errMsg)
    {
        return readDouble(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a float value from standard input.
     *
     * @return the float value read
     */
    public static float readFloat()
    {
        return readFloat("");
    }

    /**
     * Reads a float value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the float value read
     */
    public static float readFloat(String msg)
    {
        return readFloat(msg, "");
    }

    /**
     * Reads a float value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the float value read
     */
    public static float readFloat(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return Float.parseFloat(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a float value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the float value read
     */
    public static float readFloatLine(String msg)
    {
        return readFloat(msg + "\n", "");
    }

    /**
     * Reads a float value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the float value read
     */
    public static float readFloatLine(String msg, String errMsg)
    {
        return readFloat(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a char from standard input.
     *
     * @return the char read
     */
    public static char readChar()
    {
        return readChar("");
    }

    /**
     * Reads a char from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the char read
     */
    public static char readChar(String msg)
    {
        return readChar(msg, "");
    }

    /**
     * Reads a char from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the char read
     */
    public static char readChar(String msg, String errMsg)
    {
        for (;;) {
            write(msg);
            var str = ms_kb.nextLine();

            if (str.isEmpty())
                return '\n';

            if (str.length() == 1)
                return str.charAt(0);

            write(errMsg);
        }
    }

    /**
     * Reads a char from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the char read
     */
    public static char readCharLine(String msg)
    {
        return readChar(msg + "\n", "");
    }

    /**
     * Reads a char from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the char read
     */
    public static char readCharLine(String msg, String errMsg)
    {
        return readChar(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a string from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the {@link String} read
     */
    public static String read(String msg)
    {
        System.out.print(msg);

        return ms_kb.nextLine();
    }

    /**
     * Reads a line from standard input.
     *
     * @return the {@link String} read
     */
    public static String readLine()
    {
        return read("");
    }

    /**
     * Reads a line from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the {@link String} read
     */
    public static String readLine(String msg)
    {
        return read(msg + "\n");
    }

    /**
     * Reads a {@link BigDecimal} value from standard input.
     *
     * @return the {@link BigDecimal} value read
     */
    public static BigDecimal readBigDecimal()
    {
        return readBigDecimal("");
    }

    /**
     * Reads a {@link BigDecimal} value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the {@link BigDecimal} value read
     */
    public static BigDecimal readBigDecimal(String msg)
    {
        return readBigDecimal(msg, "");
    }

    /**
     * Reads a {@link BigDecimal} value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the {@link BigDecimal} value read
     */
    public static BigDecimal readBigDecimal(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigDecimal(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a {@link BigDecimal} value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the {@link BigDecimal} value read
     */
    public static BigDecimal readBigDecimalLine(String msg)
    {
        return readBigDecimal(msg + "\n", "");
    }

    /**
     * Reads a {@link BigDecimal} value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the {@link BigDecimal} value read
     */
    public static BigDecimal readBigDecimalLine(String msg, String errMsg)
    {
        return readBigDecimal(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a {@link BigInteger} value from standard input.
     *
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger()
    {
        return readBigInteger("");
    }

    /**
     * Reads a {@link BigInteger} value from standard input with a prompt message.
     *
     * @param msg prompt message
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger(String msg)
    {
        return readBigInteger(msg, "");
    }

    /**
     * Reads a {@link BigInteger} value from standard input with prompt and error messages.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger(String msg, String errMsg)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigInteger(ms_kb.nextLine());
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a {@link BigInteger} value from standard input with a prompt message, ending with a newline.
     *
     * @param msg prompt message
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigIntegerLine(String msg)
    {
        return readBigInteger(msg + "\n", "");
    }

    /**
     * Reads a {@link BigInteger} value from standard input with prompt and error messages, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigIntegerLine(String msg, String errMsg)
    {
        return readBigInteger(msg + "\n", errMsg + "\n");
    }

    /**
     * Reads a {@link BigInteger} value from standard input with the specified radix.
     *
     * @param radix number base
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger(int radix)
    {
        return readBigInteger("", radix);
    }

    /**
     * Reads a {@link BigInteger} value from standard input with a prompt message and specified radix.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger(String msg, int radix)
    {
        return readBigInteger(msg, "", radix);
    }

    /**
     * Reads a {@link BigInteger} value from standard input with prompt, error message, and radix.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @param radix number base
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigInteger(String msg, String errMsg, int radix)
    {
        for (;;) {
            try {
                System.out.print(msg);

                return new BigInteger(ms_kb.nextLine(), radix);
            }
            catch (NumberFormatException ex) {
                System.out.print(errMsg);
            }
        }
    }

    /**
     * Reads a {@link BigInteger} value from standard input with prompt and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param radix number base
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigIntegerLine(String msg, int radix)
    {
        return readBigInteger(msg + "\n", "", radix);
    }

    /**
     * Reads a {@link BigInteger} value from standard input with prompt, error message, and radix, ending with a newline.
     *
     * @param msg prompt message
     * @param errMsg error message
     * @param radix number base
     * @return the {@link BigInteger} value read
     */
    public static BigInteger readBigIntegerLine(String msg, String errMsg, int radix)
    {
        return readBigInteger(msg + "\n", errMsg + "\n", radix);
    }

    /**
     * Writes a boolean value to standard output.
     *
     * @param b the boolean value to be written
     */
    public static void write(boolean b)
    {
        write("%b", b);
    }

    /**
     * Writes an int value to standard output.
     *
     * @param val the int value to be written
     */
    public static void write(int val)
    {
        write("%d", val);
    }

    /**
     * Writes an int value in the specified radix to standard output.
     *
     * @param val the int value to be written
     * @param radix the number base to use for conversion
     */
    public static void write(int val, int radix)
    {
        write("%s", Integer.toString(val, radix));
    }

    /**
     * Writes a long value to standard output.
     *
     * @param val the long value to be written
     */
    public static void write(long val)
    {
        write("%d", val);
    }

    /**
     * Writes a long value in the specified radix to standard output.
     *
     * @param val the long value to be written
     * @param radix the number base to use for conversion
     */
    public static void write(long val, int radix)
    {
        write("%s", Long.toString(val, radix));
    }

    /**
     * Writes a char to standard output.
     *
     * @param ch the char to be written
     */
    public static void write(char ch)
    {
        write("%c", ch);
    }

    /**
     * Writes a char n times to standard output.
     *
     * @param n the number of times to write the character
     * @param ch the char to be written
     */
    public static void write(int n, char ch)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(ch);
    }

    /**
     * Writes a double value to standard output.
     *
     * @param val the double value to be written
     */
    public static void write(double val)
    {
        write("%f", val);
    }

    /**
     * Writes a float value to standard output.
     *
     * @param val the float value to be written
     */
    public static void write(float val)
    {
        write("%f", val);
    }

    /**
     * Writes a {@link String} to standard output.
     *
     * @param s the {@link String} to be written
     */
    public static void write(String s)
    {
        write("%s", s);
    }

    /**
     * Writes a char array to standard output.
     *
     * @param c the char array to be written
     */
    public static void write(char [] c)
    {
        for (char ch : c)
            write(ch);
    }

    /**
     * Writes an {@link Object} to standard output.
     *
     * @param obj the {@link Object} to be written
     */
    public static void write(Object obj)
    {
        write("%s", obj);
    }

    /**
     * Writes a formatted {@link Object} arguments to standard output.
     *
     * @param fmt the format string
     * @param objects the {@link Object} arguments referenced by the format specifiers in the format string
     */
    public static void write(String fmt, Object...objects)
    {
        System.out.printf(fmt, objects);
    }

    /**
     * Writes a newline to standard output.
     */
    public static void writeLine()
    {
        write("\n");
    }

    /**
     * Writes a boolean value followed by a newline to standard output.
     *
     * @param b the boolean value to be written
     */
    public static void writeLine(boolean b)
    {
        writeLine("%b", b);
    }

    /**
     * Writes an int value followed by a newline to standard output.
     *
     * @param val the int value to be written
     */
    public static void writeLine(int val)
    {
        writeLine("%d", val);
    }

    /**
     * Writes an int value in the specified radix followed by a newline to standard output.
     *
     * @param val the int value to be written
     * @param radix the number base to use for conversion
     */
    public static void writeLine(int val, int radix)
    {
        writeLine("%s", Integer.toString(val, radix));
    }

    /**
     * Writes a long value followed by a newline to standard output.
     *
     * @param val the long value to be written
     */
    public static void writeLine(long val)
    {
        writeLine("%d", val);
    }

    /**
     * Writes a long value in the specified radix followed by a newline to standard output.
     *
     * @param val the long value to be written
     * @param radix the number base to use for conversion
     */
    public static void writeLine(long val, int radix)
    {
        writeLine("%s", Long.toString(val, radix));
    }

    /**
     * Writes a char followed by a newline to standard output.
     *
     * @param ch the char to be written
     */
    public static void writeLine(char ch)
    {
        writeLine("%c", ch);
    }

    /**
     * Writes a character n times followed by a newline to standard output.
     *
     * @param n the number of times to write the character
     * @param ch the char to be written
     */
    public static void writeLine(int n, char ch)
    {
        write(n, ch);
        System.out.println();
    }

    /**
     * Writes a double value followed by a newline to standard output.
     *
     * @param val the double value to be written
     */
    public static void writeLine(double val)
    {
        writeLine("%f", val);
    }

    /**
     * Writes a float value followed by a newline to standard output.
     *
     * @param val the float value to be written
     */
    public static void writeLine(float val)
    {
        writeLine("%f", val);
    }

    /**
     * Writes a {@link String} followed by a newline to standard output.
     *
     * @param s the {@link String} to be written
     */
    public static void writeLine(String s)
    {
        writeLine("%s", s);
    }

    /**
     * Writes a char array followed by a newline to standard output.
     *
     * @param c the char array to be written
     */
    public static void writeLine(char [] c)
    {
        for (char ch : c)
            writeLine(ch);
    }

    /**
     * Writes an {@link Object} followed by a newline to standard output.
     *
     * @param obj the {@link Object} to be written
     */
    public static void writeLine(Object obj)
    {
        writeLine("%s", obj);
    }

    /**
     * Writes a formatted {@link Object} arguments followed by a newline to standard output.
     *
     * @param fmt the format string
     * @param objects the {@link Object} arguments referenced by the format specifiers in the format string
     */
    public static void writeLine(String fmt, Object...objects)
    {
        write(fmt + "\n", objects);
    }

    /**
     * Writes the bit representation of a char value to standard output.
     *
     * @param val the char value whose bits will be written
     */
    public static void writeBits(char val)
    {
        for (int k = 15; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    /**
     * Writes the bit representation of a byte value to standard output.
     *
     * @param val the byte value whose bits will be written
     */
    public static void writeBits(byte val)
    {
        for (int k = 7; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    /**
     * Writes the bit representation of a short value to standard output.
     *
     * @param val the short value whose bits will be written
     */
    public static void writeBits(short val)
    {
        for (int k = 15; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    /**
     * Writes the bit representation of an int value to standard output.
     *
     * @param val the int value whose bits will be written
     */
    public static void writeBits(int val)
    {
        for (int k = 31; k >= 0; --k)
            write((val & 1 << k) != 0 ? 1 : 0);

        writeLine();
    }

    /**
     * Writes the bit representation of a long value to standard output.
     *
     * @param val the long value whose bits will be written
     */
    public static void writeBits(long val)
    {
        for (int k = 63; k >= 0; --k)
            write((val & 1L << k) != 0 ? 1 : 0);

        writeLine();
    }
}