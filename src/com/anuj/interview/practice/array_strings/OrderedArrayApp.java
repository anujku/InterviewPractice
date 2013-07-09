package com.anuj.interview.practice.array_strings;

import java.io.*;

public class OrderedArrayApp {

	// TODO : Finish this
	// Insertion : O(1)
	// Search (No duplicates): O(Log N) (Comparison)
	// Deletion (No duplicates) : O(N/2) (Moving) + O(Log N) (Comparison)

	// Search (Duplicates): O(LogN) (Comparison)
	// Deletion (Duplicates) : More than O(N/2) (Moving) + O(Log N) (Comparison)

	static int array[];
	static int arrayElements;

	// binary search
	private static int searchElement(int element) {
		int currPos;
		int lowerBound = 0;
		int upperBound = arrayElements - 1;

		while (true) {
			currPos = (lowerBound + upperBound) / 2;

			if (element == array[currPos]) {
				return currPos; // Found it

			} else if (lowerBound > upperBound) {
				return -1; // Cant find it

			} else {
				if (element > array[currPos]) {
					lowerBound = currPos + 1; // Its in lower half
				} else upperBound = currPos - 1; // Its in upper half
			}
		}
	}

	private static void insert(int[] array, int element, int arrayElements) {
		int currElem;
		for (currElem = 0; currElem < arrayElements; currElem++) {
			if (array[currElem] > element) {
				break;
			}
		}
		for (int elem = arrayElements; elem > currElem; elem--) {
			array[elem] = array[elem - 1];
		}
		array[currElem] = element;
	}

	private static int[] deleteElement(int element) {
		int elemPos = searchElement(element);

		if (elemPos > 0) {
			for (int elem = elemPos; elem < arrayElements - 1; elem++) {
				array[elem] = array[elem + 1];
			}
			return array;
		}
		return null;
	}

	private static int removeMax() {
		int max = -1;

		for (int i = 0; i < arrayElements; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		deleteElement(max);
		return max;
	}

	private static int[] removeDups(int[] array, int arrayElements) {

		return null;
	}

	private static int[] merge(int[] array1, int arraySize1, int[] array2,
	  int arraySize2) {
		int[] merged = new int[arraySize1 + arraySize2];
		int i = 0, j = 0, k = 0;

		while (i < arraySize1 && j < arraySize2) {
			if (array1[i] < array2[j]) merged[k++] = array1[i++];

			else merged[k++] = array2[j++];
		}

		while (i < arraySize1)
			merged[k++] = array1[i++];

		while (j < arraySize2)
			merged[k++] = array2[j++];

		return merged;
	}

	public static void main(String[] args) throws Exception {
		int choice = -1;

		while (choice < 8) {
			System.out.println("Please Enter your choice\n");
			System.out.println("1. Create New Array \n" + "2. Search Element\n"
			  + "3. Delete Element\n" + "4. List Elements\n"
			  + "5. Remove the Maximum Element\n" + "6. Merge Array\n"
			  + "7. Remove Duplicates\n" + "8. Exit\n");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(reader.readLine());

			switch (choice) {
				case 1:
					System.out.println("Enter Array Size\n");
					int arraySize = Integer.parseInt(reader.readLine());
					array = new int[arraySize];

					System.out.println("Enter Elements\n");
					for (int count = 0; count < arraySize; count++) {
						insert(array, Integer.parseInt(reader.readLine()), arrayElements);
						arrayElements++;
					}
					break;

				case 2:
					System.out.println("Enter Element to search : \n");
					int pos = searchElement(Integer.parseInt(reader.readLine()));

					if (pos < 0) {
						System.out.println("Element not present !");
						break;
					}
					System.out.println("Element position in the array : " + (pos + 1));
					break;

				case 3:
					System.out.println("Enter Element to delete : \n");

					if (deleteElement(Integer.parseInt(reader.readLine())) == null) {
						System.out.println("Element not present !");
						break;
					}
					arrayElements--;
					System.out.println("Updated Array");
					for (int count = 0; count < arrayElements; count++) {
						System.out.println(array[count]);
					}
					break;

				case 4:
					for (int count = 0; count < arrayElements; count++) {
						System.out.println(array[count]);
					}
					break;

				case 5:
					System.out.println("Maximum Element in the array : " + removeMax()
					  + " removed.");
					arrayElements--;
					break;

				case 6:
					System.out.println("Enter New Array size : ");
					int newArraySize = Integer.parseInt(reader.readLine());
					int[] newArray = new int[newArraySize];

					System.out.println("Enter New Array Elements to merge with"
					  + " existing array : \n");
					int newArrayElements = 0;
					for (int count = 0; count < newArraySize; count++) {
						insert(newArray, Integer.parseInt(reader.readLine()), newArrayElements);
						newArrayElements++;
					}
					int[] mergedArray = merge(array, arrayElements, newArray, newArraySize);
					for (int count = 0; count < mergedArray.length; count++) {
						System.out.println(mergedArray[count]);
					}
					break;

				case 7:
					removeDups(array, arrayElements);
					break;
			}
		}
	}

}