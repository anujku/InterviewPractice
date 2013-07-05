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
				} else
					upperBound = currPos - 1; // Its in upper half
			}
		}
	}

	private static void insert(int element) {
		int currElem;
		for (currElem = 0; currElem < arrayElements; currElem++) {
			if (array[currElem] > element) {
				break;
			}
		}
		for (int elem = arrayElements; elem < currElem; elem--) {
			array[elem] = array[elem - 1];
		}
		array[currElem] = element;
		arrayElements++;
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

	public static void main(String[] args) throws Exception {
		int choice = -1;

		while (choice < 5) {
			System.out.println("Please Enter your choice\n");
			System.out
					.println("1. Create New Array \n2. Search Element \n3. Delete Element \n4. List Elements \n5. Exit\n");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			choice = Integer.parseInt(reader.readLine());

			switch (choice) {
			case 1:
				System.out.println("Enter Array Size\n");
				int arraySize = Integer.parseInt(reader.readLine());
				array = new int[arraySize];

				System.out.println("Enter Elements\n");
				for (int count = 0; count < arraySize; count++) {
					insert(Integer.parseInt(reader.readLine()));
				}
				break;

			case 2:
				System.out.println("Enter Element to search : \n");
				int pos = searchElement(Integer.parseInt(reader.readLine()));

				if (pos < 0) {
					System.out.println("Element not present !");
					break;
				}
				System.out.println("Element position in the array : "
						+ (pos + 1));
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
			}
		}
	}

}