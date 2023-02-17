//Name: Guizhi Xu
//CWID: 20008770

//package gzxPackage;

import java.util.Scanner;
import java.lang.*;
import java.util.Arrays;

public class BinaryNumber {

	// Declare data and overflow in BinaryNumberClass
	private int data[];
	private boolean overflow;

	// Create a BinaryNumber of length
	public BinaryNumber(int length) {
		// To check if it's a legal length or not.
		if (length <= 0) {
			throw new IllegalArgumentException(
					"This length is not accessible, please provide an integral value greater than 0");
		} else {
			// establish array data
			data = new int[length];

			// initiate the data to make it consisting only zeros
			for (int i : data)
				data[i] = 0;
		}
		// System.out.println(Arrays.toString(data));
	}

	// Convert a string to a BinaryNumber
	public BinaryNumber(String str) {
		// establish array data[]
		data = new int[str.length()];
		// System.out.println(str);
		for (int n = 0; n < str.length(); n++) {
			// Check if parameter is an illegal BinaryNumber or not.
			if (str.charAt(n) != '0' && str.charAt(n) != '1') {
				throw new IllegalArgumentException(
						"Incorrect String entered. The string should only contain 0 and 1. It's an illegal BinaryNumber. Please enter again");
				// Handle incorrect input and terminating the program
			}

			else {
				// initiate the data
				// Use little endian to store BinaryNumbers
				for (int i = 0; i < data.length; i++) {
					// Return char value of every element at String str
					char temp1;
					temp1 = str.charAt(i);

					// Return int value of temp1
					int temp2;
					temp2 = Character.getNumericValue(temp1);

					// store numbers into data[]
					data[i] = temp2;
				}
			}

		}
	}

	// To improve the length of data.
	private void reallocate(int[] d, int sum_move) {
		data = Arrays.copyOf(data, sum_move);// To make rooms for new digits
	}

	// Operation to get length of the BinaryNumber
	public int getLength() {
		// Check overflow if it is true. Print "overflow" if so.
		return data.length;

	}

	// Operation to get digit index of a BinaryBumber
	public int getDigit(int index) {
		if (index < 0 || index >= data.length)// if the index is larger than data.length
		{
			System.out.println("The index entered is out of bounds.");
			return -1;
		} else {
			return data[index];
		}

	}

	// To shift all digits in a binary number any number of places to the right, as
	// indicated by a parameter amount.
	public void shiftR(int amount) {
		// To check the amount if it is vaild.
		if (amount < 0) {
			throw new IllegalArgumentException(
					"The amount is not accessible, please enter a valid non-negative integer for shifting the BinaryNumber to the right.");
		}

		else {
			int ori = data.length;// To record the original data.length
			this.reallocate(data, amount + ori);
			for (int i = ori - 1; i >= 0; i--)// To shift all digits and let the origial places become zero.
			{
				data[i + amount] = data[i];
				data[i] = 0;
			}
			return;
		}
	}

	public void add(BinaryNumber aBinaryNumber) {
		// if(!overflow&&!aBinaryNumber.overflow)
		{
			int ori = data.length;
			// To check that the lengths of two binary numbers are equal.
			if (ori != aBinaryNumber.getLength()) {
				System.out.println("The lengths of the BinaryNumber can not coincide.");
				// Try to get the maximum of two lengths, motify the shorter one.
				// int maxLength = Math.max(ori, aBinaryNumber.getLength());
				// this.reallocate(data, maxLength);
				// ori = data.length;
				// aBinaryNumber.reallocate(aBinaryNumber.data, maxLength);
			} else {
				int cnum = 0;
				// It is the carried number
				// boolean addBit=false;

				for (int i = 0; i < ori; i++) {

					switch (data[i] + aBinaryNumber.getDigit(i) + cnum) {
						case 0: {
							data[i] = 0;
							cnum = 0;
						}
							break;
						case 1: {
							data[i] = 1;
							cnum = 0;
						}
							break;
						case 2: {
							data[i] = 0;
							cnum = 1;
							if (i == ori - 1) {
								this.reallocate(data, 1 + ori);
								data[i + 1] = 1;
								overflow = true;
							}
						}
							break;
						case 3: {
							data[i] = 1;
							cnum = 1;
							if (i == ori - 1) {
								this.reallocate(data, 1 + ori);
								data[i + 1] = 1;
								overflow = true;
							}
						}
							break;
					}

				}
				return;
			}

		}
		// System.out.println("Overflow!");
		return;
	}

	// Transform a BinaryNumber to its decimal notation.
	public int decimal() {
		int decimalValue = 0;
		for (int i = 0; i < data.length; i++) {
			decimalValue += data[i] * Math.pow(2, i);
		}
		return decimalValue;
	}

	// To transform a binary number to a String
	public String toString() {
		if (!overflow) {
			// creat a new String for data reversed
			String ret = "";
			for (int i = 0; i < data.length; i++) {
				ret += data[i];
			}
			return ret;
		}
		return "Overflow";
		// Print Overflow when overflow occurs
	}

	// To print a binary number
	public String toPrint() {
		// creat a new String for data reversed
		String ret = "";
		for (int i = 0; i < data.length; i++) {
			ret += data[i];
		}
		return ret;
	}

	// To clear the overflow flag
	public void clearOverflow() {
		overflow = false;
		System.out.println("Overflow flag was cleared.");
	}
}