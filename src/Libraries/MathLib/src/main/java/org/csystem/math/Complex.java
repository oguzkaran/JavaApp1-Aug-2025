package org.csystem.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Objects;

import static java.lang.Math.sqrt;

/**
 * Represents an immutable complex number in the form {@code a + bi}.
 * <p>
 * This class provides basic operations such as addition, subtraction,
 * conjugation, and norm/length calculation.
 * </p>
 */
@AllArgsConstructor
@Accessors(prefix = "m_")
@Getter
public class Complex {
	/**
	 * Tolerance value used for floating-point comparison in {@link #equals(Object)}.
	 */
	private static final double DELTA = 0.00001;

	/**
	 * Real part of the complex number.
	 */
	private final double m_real;

	/**
	 * Imaginary part of the complex number.
	 */
	private final double m_imag;

	/**
	 * Adds two complex numbers represented by their real and imaginary parts.
	 *
	 * @param re1 real part of the first complex number
	 * @param im1 imaginary part of the first complex number
	 * @param re2 real part of the second complex number
	 * @param im2 imaginary part of the second complex number
	 * @return a new {@code Complex} equal to {@code (re1 + im1i) + (re2 + im2i)}
	 */
	private static Complex add(double re1, double im1, double re2, double im2)
	{
		return new Complex(re1 + re2, im1 + im2);
	}

	/**
	 * Subtracts the second complex number from the first one, represented by their parts.
	 *
	 * @param re1 real part of the first complex number
	 * @param im1 imaginary part of the first complex number
	 * @param re2 real part of the second complex number
	 * @param im2 imaginary part of the second complex number
	 * @return a new {@code Complex} equal to {@code (re1 + im1i) - (re2 + im2i)}
	 */
	private static Complex subtract(double re1, double im1, double re2, double im2)
	{
		return add(re1, im1, -re2, -im2);
	}

	/**
	 * Creates the complex number {@code 0 + 0i}.
	 */
	public Complex()
	{
		m_real = m_imag = 0;
	}

	/**
	 * Creates a purely real complex number {@code real + 0i}.
	 *
	 * @param real real part of the complex number
	 */
	public Complex(double real)
	{
		m_real = real;
		m_imag = 0;
	}

	/**
	 * Adds a real value to a complex number.
	 *
	 * @param val real value to add
	 * @param z complex number
	 * @return a new {@code Complex} equal to {@code val + z}
	 */
	public static Complex add(double val, Complex z)
	{
		return add(val, 0, z.m_real, z.m_imag);
	}

	/**
	 * Adds another complex number to this complex number.
	 *
	 * @param other complex number to add
	 * @return a new {@code Complex} equal to {@code this + other}
	 */
	public Complex add(Complex other)
	{
		return add(m_real, m_imag, other.m_real, other.m_imag);
	}

	/**
	 * Adds a real value to this complex number.
	 *
	 * @param val real value to add
	 * @return a new {@code Complex} equal to {@code this + val}
	 */
	public Complex add(double val)
	{
		return add(m_real, m_imag, val, 0);
	}

	/**
	 * Subtracts a complex number from a real value.
	 *
	 * @param val real value
	 * @param z complex number to subtract from {@code val}
	 * @return a new {@code Complex} equal to {@code val - z}
	 */
	public static Complex subtract(double val, Complex z)
	{
		return subtract(val, 0, z.m_real, z.m_imag);
	}

	/**
	 * Subtracts another complex number from this complex number.
	 *
	 * @param other complex number to subtract
	 * @return a new {@code Complex} equal to {@code this - other}
	 */
	public Complex subtract(Complex other)
	{
		return subtract(m_real, m_imag, other.m_real, other.m_imag);
	}

	/**
	 * Subtracts a real value from this complex number.
	 *
	 * @param val real value to subtract
	 * @return a new {@code Complex} equal to {@code this - val}
	 */
	public Complex subtract(double val)
	{
		return subtract(m_real, m_imag, val, 0);
	}

	/**
	 * Returns the complex conjugate of this number.
	 *
	 * @return a new {@code Complex} equal to {@code a - bi} for this {@code a + bi}
	 */
	public Complex getConjugate()
	{
		return new Complex(m_real, -m_imag);
	}

	/**
	 * Returns the norm (magnitude/modulus) of this complex number.
	 *
	 * @return {@code sqrt(real^2 + imag^2)}
	 */
	public double getNorm()
	{
		return sqrt(m_real * m_real + m_imag * m_imag);
	}

	/**
	 * Returns the length of this complex number.
	 * <p>
	 * This is an alias of {@link #getNorm()}.
	 * </p>
	 *
	 * @return the norm of this complex number
	 */
	public double getLength()
	{
		return getNorm();
	}

	/**
	 * Compares this complex number with another object for approximate equality.
	 * <p>
	 * Two complex numbers are considered equal if the absolute differences of both
	 * real and imaginary parts are smaller than {@link #DELTA}.
	 * </p>
	 *
	 * @param other object to compare with
	 * @return {@code true} if approximately equal; otherwise {@code false}
	 */
	@Override
	public boolean equals(Object other)
	{
		return other instanceof Complex z && Math.abs(m_real - z.m_real) < DELTA && Math.abs(m_imag - z.m_imag) < DELTA;
	}

	/**
	 * Returns a hash code for this complex number based on exact field values.
	 *
	 * @return hash code value
	 */
	@Override
	public int hashCode()
	{
		return Objects.hash(m_real, m_imag);
	}

	/**
	 * Returns a string representation of this complex number formatted to two decimals.
	 *
	 * @return string in the form {@code "(re, im)"}
	 */
	@Override
	public String toString()
	{
		return "(%.2f, %.2f)".formatted(m_real, m_imag);
	}
}