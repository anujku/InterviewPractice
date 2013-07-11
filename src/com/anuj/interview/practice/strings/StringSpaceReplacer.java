package com.anuj.interview.practice.strings;

import java.io.*;

public class StringSpaceReplacer {
	public static String replaceSpaces(String string) {
		string = string.trim();
		int length = string.length();
		int spaces = 0;
		for (int i = 0; i < length; i++) {
			if (string.charAt(i) == ' ') {
				spaces++;
			}
		}
		char[] newChars = new char[length + spaces * 2];
		char[] chars = string.toCharArray();
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				newChars[j] = '%';
				newChars[j + 1] = '2';
				newChars[j + 2] = '0';
				j = j + 3;
			} else {
				newChars[j] = chars[i];
				j++;
			}
		}
		return new String(newChars);
	}

	public static String replaceSpaces2(String string) {
		string = string.trim();
		StringBuilder newString = new StringBuilder();
		char[] chars = string.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				newString.append("%20");
			} else {
				newString.append(chars[i]);
			}
		}
		return newString.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Please Enter a String to replace spaces from it : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
		System.out.println("Using Method 1 : ");
		System.out.println(string + " after replacing spaces from it : "
		  + replaceSpaces(string));
		System.out.println("Using Method 2 : ");
		System.out.println(string + " after replacing spaces from it : "
		  + replaceSpaces2(string));
	}
}
