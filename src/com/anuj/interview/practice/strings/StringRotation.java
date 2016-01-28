package com.anuj.interview.practice.strings;

import java.io.*;

public class StringRotation {
	public static boolean isRotation(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		} else {
			char c = word1.charAt(0);
			int i;
			for (i = 0; i < word2.length(); i++) {
				if (word2.charAt(i) == c) break;
			}
			return word1.equals(word2.substring(i, word2.length())
			  + word2.substring(0, i));
		}
	}
	
	public static boolean isRotation2(String s1,String s2) {
    		return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Program to check if one word is rotation of other");
		System.out.println("**************************************************");
		System.out.println("Enter first word : ");
		String word1 = reader.readLine();
		System.out.println("Enter second word : ");
		String word2 = reader.readLine();
		if (isRotation(word1, word2)) {
			System.out.println(word2 + " is rotation of " + word1);
		} else {
			System.out.println(word2 + " is not a rotation of " + word1);
		}
	}
}
