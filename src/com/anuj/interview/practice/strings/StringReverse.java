package com.anuj.interview.practice.strings;

import java.io.*;

public class StringReverse {
	public static void main(String[] args) throws IOException{
		System.out.println("Please Enter a String");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();	
		System.out.println("Reverse of " + string + " is : " +reverse(string));
	}

	public static String reverse(String string) {
		String reverseString = "";

		for (int i = string.length() - 1; i >= 0 ; i--) {
			reverseString = reverseString + Character.toString(string.charAt(i));
		}

		return reverseString;
	}
}
