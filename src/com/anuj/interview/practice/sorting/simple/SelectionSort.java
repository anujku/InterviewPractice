package com.anuj.interview.practice.sorting.simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The algorithm divides the input list into two parts: the sublist of items
// already sorted, which is built up from left to right at the front (left) of
// the list, and the sublist of items remaining to be sorted that occupy the
// rest of the list. Initially, the sorted sublist is empty and the unsorted
// sublist is the entire input list. The algorithm proceeds by finding the
// smallest (or largest, depending on sorting order) element in the unsorted
// sublist, exchanging it with the leftmost unsorted element (putting it in
// sorted order), and moving the sublist boundaries one element to the right.
public class SelectionSort {
	// Worst case performance О(n2)
	// Best case performance О(n2)
	// Average case performance О(n2)
	// Worst case space complexity О(n) total, O(1) auxiliary
	private static int[] selctionSort(int[] array) {
		for (int outer = 0; outer < array.length - 1; outer++) {
			int minPos = findMinPos(array, outer);
			int temp = array[outer];
			array[outer] = array[minPos];
			array[minPos] = temp;
		}
		return array;
	}

	private static int findMinPos(int[] array, int startIndex) {
		int minIndex = startIndex;
		int min = array[minIndex];
		
		for (int i = startIndex; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Enter size of the array to do selction sort : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(reader.readLine());
		int[] array = new int[size];
		System.out.println("Enter the array to do selction sort : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println("Enter " + i + "th element of the array");
			array[i] = Integer.parseInt(reader.readLine());
		}
		long startTime = System.nanoTime();
		array = selctionSort(array);
		long totalTime = System.nanoTime() - startTime;
		System.out.println("Total Runtime in nanoseconds : " + totalTime);
		System.out.println("Selection sorted array : ");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
