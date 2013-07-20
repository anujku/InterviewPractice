package com.anuj.interview.practice.sorting.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Worst case performance O(n2) (Data is sorted already)
// When the pivot is the smallest (or largest) element at partitioning on
// a block of size n, the result yields one empty sub-block, one element (pivot)
// in the “correct” place and one sub-block of size (n-1) takes θ(n) times.
// Recurrence Equation:
// T(1) = 1
// T(n) = T(n-1) + cn
// Solution : θ(n2) Worse than Mergesort
//
// Best case performance O(n log n) Comparable to Mergesort!
// The pivot is in the middle (median) (at each partition
// step), i.e. after each partitioning, on a block of size n, the
// result yields two sub-blocks of approximately equal size and
// the pivot element in the “middle” position takes n data comparisons.
// Recurrence Equation becomes
// T(1) = 1
// T(n) = 2T(n/2) + cn
// Solution: θ(n logn)
//
// Average case performance O(n log n)
// Worst case space complexity O(n) auxiliary (naive)
// O(log n) auxiliary (Sedgewick 1978)
public class QuickSort {
	// Quicksort is a divide and conquer algorithm. Quicksort first divides a large
	// list into two smaller sub-lists: the low elements and the high elements.
	// Quicksort can then recursively sort the sub-lists.
	// The steps are:
	// Pick an element, called a pivot, from the list.
	// Reorder the list so that all elements with values less than the pivot come
	// before the pivot, while all elements with values greater than the pivot come
	// after it (equal values can go either way). After this partitioning, the
	// pivot is in its final position. This is called the partition operation.
	// Recursively apply the above steps to the sub-list of elements with smaller
	// values and separately the sub-list of elements with greater values.
	// The base case of the recursion are lists of size zero or one, which never
	// need to be sorted.
	public static void swap(int array[], int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	// Different ways to select a good pivot.
	// - First element
	// - Last element
	// - Median-of-three elements
	// - Pick three elements, and find the median x of
	// these elements. Use that median as the pivot.
	// - Random element
	// - Randomly pick a element as a pivot.
	//
	// Reorganizes the given list so all elements less than the first are
	// before it and all greater elements are after it.
	public static int partition(int array[], int start, int end) {
		int pivot = array[start];
		while (start < end) {
			while (array[start] < pivot) {
				start++;
			}
			while (array[end] > pivot) {
				end--;
			}
			swap(array, start, end); // Move pivot to its final place
		}
		return start;
	}

	public static void quicksort(int array[], int start, int end) {
		if (start >= end) return;
		int pivot_index = partition(array, start, end);
		quicksort(array, start, pivot_index);
		quicksort(array, pivot_index + 1, end);
	}

	private static void quickSort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do quick sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		  System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to do quick sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + (i + 1) + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		quickSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Quick sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
