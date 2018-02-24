package com.mine.linkedListTools;

public class Manage {
	public static void main(String args[]) {
		MyLinkedList<String> ml = new MyLinkedList<>();
		ml.add("123");
		ml.add("456");
		ml.add("789");
		for (int i = 0; i < ml.getSize(); i++) {
			System.out.println(ml.find(i));
		}
		ml.delete(1);
		for (int i = 0; i < ml.getSize(); i++) {
			System.out.println(ml.find(i));
		}
		ml.update(1, "lalala");
		for (int i = 0; i < ml.getSize(); i++) {
			System.out.println(ml.find(i));
		}
	}
}