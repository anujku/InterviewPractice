package com.anuj.interview.practice.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringUnique {
	public static void main(String[] args) throws IOException {
		System.out.println("Enter String : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string = reader.readLine();
		if (checkUnique(string)) {
			System.out.println(string + " has all unique characters");
		} else {
			System.out.println(string + " does not have unique characters");
		}
	}

	// My Version
	// private static boolean checkUnique(String string) {
	// String newString = "";
	// for (int i = 0; i < string.length(); i++) {
	// String charc = Character.toString(string.charAt(i));
	// if (!newString.contains(charc)) {
	// newString = newString + charc;
	// } else {
	// return false;
	// }
	// }
	// return true;
	// }
	// Book Version
	private static boolean checkUnique(String string) {
		boolean[] chars = new boolean[256];
		if (string.length() > 256) { return false; }
		for (int i = 0; i < string.length(); i++) {
			int charc = string.charAt(i);
			if (chars[charc]) {
				return false;
			} else {
				chars[charc] = true;
			}
		}
		return true;
	}
}
