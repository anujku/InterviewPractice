package com.anuj.interview.practice.sorting.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Not stable
// O(1) extra space
// O(n3/2) time as shown (see below)
// Adaptive: O(n·lg(n)) time when nearly sorted
//
//
// The worse-case time complexity of shell sort depends on the increment
// sequence. For the increments 1 4 13 40 121..., which is what is used here,
// the time complexity is O(n3/2). For other increments, time complexity is
// known to be O(n4/3) and even O(n·lg2(n)). Neither tight upper bounds on time
// complexity nor the best increment sequence are known.
//
// Because shell sort is based on insertion sort, shell sort inherits insertion
// sort's adaptive properties. The adaption is not as dramatic because shell
// sort requires one pass through the data for each increment, but it is
// significant. For the increment sequence shown above, there are log3(n)
// increments, so the time complexity for nearly sorted data is O(n·log3(n)).
//
public class ShellSort {
	private static void shellSort(int[] array) {
		shellSort(array, array.length);
	}

	private static void shellSort(int numbers[], int array_size) {
		int i, j, increment, temp;
		increment = 3;
		while (increment > 0) {
			for (i = 0; i < array_size; i++) {
				j = i;
				temp = numbers[i];
				while ((j >= increment) && (numbers[j - increment] > temp)) {
					numbers[j] = numbers[j - increment];
					j = j - increment;
				}
				numbers[j] = temp;
			}
			if (increment / 2 != 0) increment = increment / 2;
			else if (increment == 1) increment = 0;
			else increment = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do shell sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		  System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to do shell sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		shellSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Shell sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}