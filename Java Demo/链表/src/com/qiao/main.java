package com.qiao;

public class main {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList_双向循环链表<>();
		
		list.add(11);
		list.add(13);
		list.addElementWithIndex(1,12);
		list.addElementWithIndex(0, 10);
		
		list.removeElementAtIndex(0);
		
		System.out.println(list);

	}

}
