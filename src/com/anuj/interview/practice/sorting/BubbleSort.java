package com.anuj.interview.practice.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Bubble sort, sometimes incorrectly referred to as sinking sort, is a simple
// sorting algorithm that works by repeatedly stepping through the list to be
// sorted, comparing each pair of adjacent items and swapping them if they are
// in the wrong order. The pass through the list is repeated until no swaps are
// needed, which indicates that the list is sorted. The algorithm gets its name
// from the way smaller elements "bubble" to the top of the list. Because it
// only uses comparisons to operate on elements, it is a comparison sort.
// Although the algorithm is simple, most of the other sorting algorithms are
// more efficient for large lists.
public class BubbleSort {
	// Complexity : O(N^2)
	// Worst case performance O(n^2)
	// Best case performance O(n)
	// Average case performance O(n^2)
	// Worst case space complexity O(1) auxiliary
	private static int[] bubbleSort(int[] array) {
		for (int outer = array.length - 1; outer > 1; outer--) {
			for (int inner = 0; inner < outer; inner++) {
				if (array[inner] > array[inner + 1]) {
					int temp = array[inner];
					array[inner] = array[inner + 1];
					array[inner + 1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to bubble sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to bubble sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		array = bubbleSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Bubble sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
