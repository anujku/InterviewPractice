package com.anuj.interview.practice.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Insertion sort is a simple sorting algorithm that builds the final sorted
// array (or list) one item at a time. It is much less efficient on large lists
// than more advanced algorithms such as quicksort, heapsort, or merge sort.
// However, insertion sort provides several advantages:
// Simple implementation
// Efficient for (quite) small data sets
// Adaptive (i.e., efficient) for data sets that are already substantially
// sorted: the time complexity is O(n + d), where d is the number of inversions
// More efficient in practice than most other simple quadratic (i.e., O(n2))
// algorithms such as selection sort or bubble sort; the best case (nearly
// sorted input) is O(n)
// Stable; i.e., does not change the relative order of elements with equal keys
// In-place; i.e., only requires a constant amount O(1) of additional memory
// space
// Online; i.e., can sort a list as it receives it
public class InsertionSort {
	// Insertion sort iterates, consuming one input element each repetition, and
	// growing a sorted output list. On a repetition, insertion sort removes one
	// element from the input data, finds the location it belongs within the sorted
	// list, and inserts it there. It repeats until no input elements remain.
	// Worst case performance О(n2) comparisons, swaps
	// Best case performance O(n) comparisons, O(1) swaps
	// Average case performance О(n2) comparisons, swaps
	// Worst case space complexity О(n) total, O(1) auxiliary
	private static int[] insertionSort(int[] array) {
		return null;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do insertion sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to do insertion sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		array = insertionSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Insertion sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
