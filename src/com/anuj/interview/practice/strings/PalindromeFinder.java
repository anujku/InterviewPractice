package com.anuj.interview.practice.strings;

import java.io.*;

public class PalindromeFinder {
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

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter word1 : ");
		String word1 = reader.readLine();
		System.out.println("Enter word2 : ");
		String word2 = reader.readLine();
		if (iPalindrome(word1, word2)) {
			System.out
			  .println(word1 + " and " + word2 + " are palindrome of each other");
		} else {
			System.out.println(word1 + " and " + word2
			  + " are not palindrome of each other");
		}
	}
}
