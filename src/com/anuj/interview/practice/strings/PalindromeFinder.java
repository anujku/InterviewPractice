package com.anuj.interview.practice.strings;

import java.io.*;

public class PalindromeFinder {
	public static boolean isPalindrome(String word){
		return word.equals(reverse(word));
	}

	public static String reverse(String word) {
		StringBuilder reverse = new StringBuilder();
		for(int i = word.length() -1; i >= 0; i --) {
			reverse.append(Character.toString(word.charAt(i)));
		}
		return reverse.toString();
	}
	public static void main(String[] args) throws IOException{
		System.out.println("Enter word : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String word = reader.readLine();
		if(isPalindrome(word)) {
			System.out.println(word + " is Palindrome");
		} else {
			System.out.println(word + " is not Palindrome");
		}
	}
}
