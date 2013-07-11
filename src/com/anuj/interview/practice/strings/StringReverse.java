package com.anuj.interview.practice.strings;

import java.io.*;

public class StringReverse {
	public static void main(String[] args) throws IOException {
		System.out.println("Please Enter a String");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
		System.out.println("Reverse of " + string + " is : " + reverse(string));
	}

	// public static String reverse(String string) {
	// StringBuilder reverseString = new StringBuilder();
	// for (int i = string.length() - 1; i >= 0; i--) {
	// reverseString.append(Character.toString(string.charAt(i)));
	// }
	// return reverseString.toString();
	// }
	public static String reverse(String string) {
		int length = string.length();
		for (int i = length -1 ; i >= 0; i--) {
			string = string + string.charAt(i);
		}
		return string.substring(length, string.length());
	}
}
