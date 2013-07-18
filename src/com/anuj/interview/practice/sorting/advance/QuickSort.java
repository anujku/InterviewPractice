package com.anuj.interview.practice.sorting.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
	private static int[] array;

	private static void quickSort() {
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do quick sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		  System.in));
		int size = Integer.parseInt(reader.readLine());
		array = new int[size];
		System.out.println("Enter the array to do quick sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		quickSort();
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Quick sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
