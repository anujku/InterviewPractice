package com.anuj.interview.practice.sorting.advance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
	public static void swap(int array[], int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	// Reorganizes the given list so all elements less than the first are
	// before it and all greater elements are after it.
	public static int partition(int array[], int f, int l) {
		int pivot = array[f];
		while (f < l) {
			while (array[f] < pivot)
				f++;
			while (array[l] > pivot)
				l--;
			swap(array, f, l);
		}
		return f;
	}

	public static void quicksort(int array[], int f, int l) {
		if (f >= l) return;
		int pivot_index = partition(array, f, l);
		quicksort(array, f, pivot_index);
		quicksort(array, pivot_index + 1, l);
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
