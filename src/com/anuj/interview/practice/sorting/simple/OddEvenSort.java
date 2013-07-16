package com.anuj.interview.practice.sorting.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// In computing, an odd–even sort or odd–even transposition sort (also known as
// brick sort[1]) is a relatively simple sorting algorithm, developed originally
// for use on parallel processors with local interconnections. It is a
// comparison sort related to bubble sort, with which it shares many
// characteristics. It functions by comparing all (odd, even)-indexed pairs of
// adjacent elements in the list and, if a pair is in the wrong order (the first
// is larger than the second) the elements are switched. The next step repeats
// this for (even, odd)-indexed pairs (of adjacent elements). Then it alternates
// between (odd, even) and (even, odd) steps until the list is sorted.
public class OddEvenSort {
	private static int[] oddEvenSort(int[] array) {
		/* Assumes a is an array of values to be sorted. */
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < array.length - 1; i += 2) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
			for (int i = 1; i < array.length - 1; i += 2) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					sorted = false;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do odd-even sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to do odd-even sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		array = oddEvenSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Odd-even sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
