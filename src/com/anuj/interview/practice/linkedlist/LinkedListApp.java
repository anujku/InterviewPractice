package com.anuj.interview.practice.linkedlist;

public class LinkedListApp {
	public static void main(String[] args) {
		LinkedList theList = new LinkedList(); // make new list
		// insert four items
		theList.insertFirst(22, 2.99);
		theList.insertFirst(44, 4.99);
		theList.insertFirst(66, 6.99);
		theList.insertFirst(88, 8.99);
		theList.displayList();
		Link f = theList.find(44);
		// find item
		if (f != null) System.out.println("Found link with key " + f.iData);
		else System.out.println("Can’t find link");
		Link d = theList.delete(66);
		// delete item
		if (d != null) System.out.println("Deleted link with key " + d.iData);
		else System.out.println("Can’t delete link");
		theList.displayList();
		// display list
		while (!theList.isEmpty()) {// until it’s empty,
			Link aLink = theList.deleteFirst();
			// delete link
			System.out.print("Deleted ");
			// display it
			aLink.displayLink();
			System.out.println();
		}
		theList.displayList();
		// display list
	} // end main()
}

class LinkedList {
	private Link first;

	public LinkedList() {
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public Link find(int key) {
		// find link with given key
		// (assumes non-empty list)
		Link current = first;
		// start at ‘first’
		while (current.iData != key) {
			// while no match,
			if (current.next == null) {
				// if end of list,
				return null;
			}
			// didn’t find it
			else {
				// not end of list,
				current = current.next;
			}
			// go to next link
		}
		return current;
		// found it
	}

	public Link delete(int key) {
		// delete link with given key (assumes non-empty list)
		Link current = first;		// search for link
		Link previous = first;
		while (current.iData != key) {
			if (current.next == null) return null;
			// didn’t find it
			else {
				previous = current;
				// go to next link
				current = current.next;
			}
		}
		// found it
		if (current == first) {
			// if first link,
			first = first.next;
		}
		// change first
		else {
			// otherwise, bypass it
			previous.next = current.next;
		}
		return current;
	}

	// -------------------------------------------------------------
	// insert at the start of list
	public void insertFirst(int id, double dd) {
		Link newLink = new Link(id, dd);
		newLink.next = first;
		first = newLink;
	}

	// delete first item
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}

	// display the list
	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first;
		// start at beginning of list
		while (current != null) { // until end of list
			current.displayLink();
			// print data
			current = current.next; // move to next link
		}
		System.out.println();
	}
}

class Link {
	public int iData;
	public double dData;
	public Link next;

	public Link(int iData, double dData) {
		this.dData = dData;
		this.iData = iData;
	}

	public void displayLink() {
		System.out.print("{" + this.iData + ", " + this.dData + "} ");
	}
}
