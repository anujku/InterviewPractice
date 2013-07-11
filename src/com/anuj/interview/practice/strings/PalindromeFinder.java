package com.anuj.interview.practice.strings;

import java.io.*;
import java.util.Arrays;

public class PalindromeFinder {
	// method 1 : match characters
	public static boolean iPalindrome(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		} else {
			for (int i = 0; i < word1.length(); i++) {
				if (!Character.toString(word1.charAt(i)).equals(
				  Character.toString(word2.charAt(word2.length() - 1 - i)))) { return false; }
			}
			return true;
		}
	}

	// method 2 : use sorting
	private static boolean iPalindrome2(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		} else {
			char[] word1Char = word1.toCharArray();
			Arrays.sort(word1Char);
			char[] word2Char = word2.toCharArray();
			Arrays.sort(word2Char);
			return new String(word1Char).equals(new String(word2Char));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter word1 : ");
		String word1 = reader.readLine();
		System.out.println("Enter word2 : ");
		String word2 = reader.readLine();
		System.out.println("Using method 1 : ");
		if (iPalindrome(word1, word2)) {
			System.out
			  .println(word1 + " and " + word2 + " are palindrome of each other");
		} else {
			System.out.println(word1 + " and " + word2
			  + " are not palindrome of each other");
		}
		System.out.println("Using method 2 : ");
		if (iPalindrome2(word1, word2)) {
			System.out
			  .println(word1 + " and " + word2 + " are palindrome of each other");
		} else {
			System.out.println(word1 + " and " + word2
			  + " are not palindrome of each other");
		}
	}
}