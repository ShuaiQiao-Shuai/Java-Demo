package com.qiao;

public class main {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		
		list.add(20);
		list.addElementWithIndex(0, 10);
		list.add(30);
		list.addElementWithIndex(list.size(), 40);
		
		list.removeElementAtIndex(1);
		
		list.setElementWithIndex(1, 11);
		
		System.out.println(list.getElementFromIndex(1));
		
		

	}

}
