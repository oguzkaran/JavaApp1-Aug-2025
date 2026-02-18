package com.karandev.io.util.console;

/**
 * Utility class for validating command line argument counts.
 *
 * <p>Provides static methods to check if the number of command line arguments
 * matches specific conditions (equals, not equals, greater, less, etc.).
 * If a check fails, an error message is printed and the application exits
 * with the specified exit code.
 *
 * <p>Copyleft (c) 1993 by C and System Programmers Association (CSD)
 * All Rights Free
 *
 * @author CSD Development Group
 */
public final class CommandLineArgs {
    private CommandLineArgs()
    {
    }

    /**
     * Checks if the number of arguments equals the expected length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len expected number of arguments
     * @param message error message to display if check fails
     */
    public static void checkLengthEquals(int argsLen, int len, String message)
    {
        checkLengthEquals(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments equals the expected length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len expected number of arguments
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthEquals(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen != len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    /**
     * Checks if the number of arguments does not equal the expected length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len length to compare against
     * @param message error message to display if check fails
     */
    public static void checkLengthNotEquals(int argsLen, int len, String message)
    {
        checkLengthNotEquals(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments does not equal the expected length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len length to compare against
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthNotEquals(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen == len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    /**
     * Checks if the number of arguments is greater than the specified length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len minimum number of arguments required
     * @param message error message to display if check fails
     */
    public static void checkLengthGreater(int argsLen, int len, String message)
    {
        checkLengthGreater(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments is greater than the specified length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len minimum number of arguments required
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthGreater(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen <= len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    /**
     * Checks if the number of arguments is greater than or equal to the specified length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len minimum number of arguments required
     * @param message error message to display if check fails
     */
    public static void checkLengthGreaterOrEqual(int argsLen, int len, String message)
    {
        checkLengthGreaterOrEqual(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments is greater than or equal to the specified length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len minimum number of arguments required
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthGreaterOrEqual(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen < len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    /**
     * Checks if the number of arguments is less than the specified length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len maximum number of arguments allowed
     * @param message error message to display if check fails
     */
    public static void checkLengthLess(int argsLen, int len, String message)
    {
        checkLengthLess(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments is less than the specified length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len maximum number of arguments allowed
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthLess(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen >= len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }

    /**
     * Checks if the number of arguments is less than or equal to the specified length.
     * Exits with code 1 if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len maximum number of arguments allowed
     * @param message error message to display if check fails
     */
    public static void checkLengthLessOrEqual(int argsLen, int len, String message)
    {
        checkLengthLessOrEqual(argsLen, len, message, 1);
    }

    /**
     * Checks if the number of arguments is less than or equal to the specified length.
     * Exits with the specified exit code if the check fails.
     *
     * @param argsLen actual number of arguments
     * @param len maximum number of arguments allowed
     * @param message error message to display if check fails
     * @param exitCode exit code to use if check fails
     */
    public static void checkLengthLessOrEqual(int argsLen, int len, String message, int exitCode)
    {
        if (argsLen > len) {
            Console.Error.writeLine(message);
            System.exit(exitCode);
        }
    }
}