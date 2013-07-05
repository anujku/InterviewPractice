package com.anuj.interview.practice.array_strings;

import java.io.*;

public class ArrayApp {

	// Insertion : O(1)
	// Search (No duplicates): O(N/2) (Comparison)
	// Deletion (No duplicates) : O(N/2) (Moving) + O(N/2) (Comparison)
	
	// Search (Duplicates): O(N) (Comparison)
	// Deletion (Duplicates) : More than O(N/2) (Moving) + O(N) (Comparison)
	
	
	static int array[];
	static int size;

	// linear search
	private static int searchElement(int element) {
		int pos = -1;

		for (int count = 0; count < size; count++) {
			if (array[count] == element) {
				pos = count;
				break;
			}
		}
		return pos;
	}

	private static int[] deleteElement(int element) {
		int elemPos = searchElement(element);

		if (elemPos > 0) {
			for (int elem = elemPos; elem < size - 1; elem++) {
				array[elem] = array[elem + 1];
			}
			return array;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		int choice = -1;

		while (choice < 4) {
			System.out.println("Please Enter your choice\n");
			System.out
					.println("1. Create New Array \n2. Search Element \n3. Delete Element \n4. Exit\n");

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					System.in));
			choice = Integer.parseInt(reader.readLine());

			switch (choice) {
			case 1:
				System.out.println("Enter Array Size\n");
				size = Integer.parseInt(reader.readLine());
				array = new int[size];

				System.out.println("Enter Elements\n");
				for (int count = 0; count < size; count++) {
					array[count] = Integer.parseInt(reader.readLine());
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
				size--;
				System.out.println("Updated Array");
				for (int count = 0; count < size; count++) {
					System.out.println(array[count]);
				}
				break;
			}
		}
	}
}
