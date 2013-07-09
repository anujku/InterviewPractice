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

	private static boolean checkUnique(String string) {
		String newString = "";
		for(int i = 0; i < string.length(); i++) {
			String charc = Character.toString(string.charAt(i));
			if(!newString.contains(charc)) {
				newString = newString + charc;
			}
			else {
				return false;
			}
		}
		return true;
	}
}
