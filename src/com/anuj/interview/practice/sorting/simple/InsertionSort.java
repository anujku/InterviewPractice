package com.anuj.interview.practice.sorting.simple;

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
	private static int[] array;

	// Insertion sort iterates, consuming one input element each repetition, and
	// growing a sorted output list. On a repetition, insertion sort removes one
	// element from the input data, finds the location it belongs within the sorted
	// list, and inserts it there. It repeats until no input elements remain.
	// Worst case performance О(n2) comparisons, swaps
	// Best case performance O(n) comparisons, O(1) swaps
	// Average case performance О(n2) comparisons, swaps
	// Worst case space complexity О(n) total, O(1) auxiliary
	private static int[] insertionSort() {
		int counter = 0;
		for (int outer = 1; outer < array.length; outer++) {
			// at the start of the iteration, A[0..i-1] are in sorted order
			// this iteration will insert A[i] into that sorted order
			// save A[i], the value that will be inserted into the array on this
			// iteration
			int holePos = outer;
			// now mark position i as the hole; A[i]=A[holePos] is now empty
			int valueToInsert = array[holePos];
			// keep moving the hole down until the valueToInsert is larger than
			// what's just below the hole or the hole has reached the beginning of the
			// array
			while (holePos > 0 && valueToInsert < array[holePos - 1]) {
				// value to insert doesn't belong where the hole currently is, so shift
				array[holePos] = array[holePos - 1]; // shift the larger value up
				holePos = holePos - 1; // move the hole position down
			}
			if (valueToInsert == array[holePos - 1]) {
				array[holePos - 1] = -1;
				counter++;
			}
			// hole is in the right position, so put valueToInsert into the hole
			array[holePos] = valueToInsert;
			// A[0..i] are now in sorted order
		}
		// To remove duplicate elements
		int[] updatedArray = new int[array.length - counter];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != -1) {
				updatedArray[j] = array[i];
				j++;
			}
		}
		return updatedArray;
	}

	// This method removes duplicates from sorted array in O(N) time also, it does
	// not change the position of any element twice
	public static int removeDups() {
		int j = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] != array[j]) {
				j++;
				array[j] = array[i];
			}
		}
		return j + 1;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do insertion sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		  System.in));
		int size = Integer.parseInt(reader.readLine());
		array = new int[size];
		System.out.println("Enter the array to do insertion sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		array = insertionSort();
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Insertion sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		int length = removeDups();
		System.out
		  .println("Insertion sorted after removing duplicates array : ");
		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}
}
