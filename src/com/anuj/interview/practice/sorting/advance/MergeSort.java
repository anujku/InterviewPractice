package com.anuj.interview.practice.sorting.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Conceptually, a merge sort works as follows
// 1. Divide the unsorted list into n sublists, each containing 1 element (a
// list of 1 element is considered sorted).
// 2. Repeatedly merge sublists to produce new sublists until there is only 1
// sublist remaining. This will be the sorted list.
// Merge sort is an O(n log n) comparison-based sorting algorithm.
// Most implementations produce a stable sort, which means that the
// implementation preserves the input order of equal elements in the sorted
// output. Merge sort is a divide and conquer algorithm.
public class MergeSort {
	// Advantages :
	// 1. conceptually simple
	// 2. suited to sorting linked lists of elements because merge traverses each
	// linked list
	// 3. suited to sorting external files; divides array into smaller files until
	// can be stored in array in memory
	// 4. stable performance
	//
	//
	// Two inefficiencies of MergeSort :
	//
	//
	// 1. Not in place (It uses another array b[].)
	// 1.1 Copy between a[] and b[] needed
	// 2. Space and time for stack due to recursion
	// 2.2 For small set sizes, most of time consumed by recursion instead of
	// sorting
	private static int[] array;

	public static void mergeSort() {
		divide(0, array.length);
	}

	public static void divide(int first, int length) {
		int firstHalf; // Size of the first half of the array
		int secondHalf; // Size of the second half of the array
		if (length > 1) {
			// Compute sizes of the two halves
			firstHalf = length / 2;
			secondHalf = length - firstHalf;
			divide(first, firstHalf);      // Sort data[first] through data[first+n1-1]
			divide(first + firstHalf, secondHalf); // Sort data[first+n1] to the end
			// Merge the two sorted halves.
			merge(first, firstHalf, secondHalf);
		}
	}

	public static void merge(int first, int middle, int last) {
		int[] temp = new int[middle + last]; // Allocate the temporary array
		int copied = 0; // Number of elements copied from array to temp
		int copied1 = 0; // Number copied from the first half of array
		int copied2 = 0; // Number copied from the second half of array
		int i;           // Array index to copy from temp back into array
		// Merge elements, copying from two halves of array to the temporary array.
		while ((copied1 < middle) && (copied2 < last)) {
			temp[copied++] = (array[first + copied1] < array[first + middle
			  + copied2]) ? array[first + (copied1++)] : array[first + middle
			  + (copied2++)];
		}
		// Copy any remaining entries in the left and right subarrays.
		while (copied1 < middle)
			temp[copied++] = array[first + (copied1++)];
		while (copied2 < last)
			temp[copied++] = array[first + middle + (copied2++)];
		// Copy from temp back to the array array.
		for (i = 0; i < middle + last; i++)
			array[first + i] = temp[i];
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do merge sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		  System.in));
		int size = Integer.parseInt(reader.readLine());
		array = new int[size];
		System.out.println("Enter the array to do merge sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		mergeSort();
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Merge sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
