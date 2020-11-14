package com.qiao;

public class main {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList_单向环形链表<>();
		
		list.add(11);
		list.add(12);
		list.addElementWithIndex(list.size(),13);
		list.addElementWithIndex(0, 10);
		
		//list.removeElementAtIndex(0);
		
		System.out.println(list);

	}

}
