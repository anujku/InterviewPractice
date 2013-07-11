package com.anuj.interview.practice.strings;

import java.io.*;

public class StringCompression {
	public static String compress(String string) {
		StringBuilder compressed = new StringBuilder();
		int count = 1;
		for (int i = 0; i < string.length() - 1; i++) {
			if (Character.toString(string.charAt(i)).equals(
			  Character.toString(string.charAt(i + 1)))) {
				count++;
			} else {
				compressed.append(Character.toString(string.charAt(i)) + count);
				count = 1;
			}
		}
		compressed.append(Character.toString(string.charAt(string.length() - 1))
		  + count);
		return (compressed.toString().length() > string.length()) ? string
		  : compressed.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Please Enter a string you want to compress");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String word = reader.readLine();
		System.out.println("Compressed String : " + compress(word));
	}
}
