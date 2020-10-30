package com.qiao;

public class 反转链表 {

	public class ListNode {
		int count;
		ListNode next;
		ListNode(int var){
			count = var;
		}
	}
	
	/**
	 *思路：
	 *1 先声明临时变量tmp指向header.next（防止第二步后没有指针指向header.next）
	 *2 将header.next指向newHeader
	 *3 将newHeader指向header
	 *4 将header指向tmp
	 *5 次循环直到 header 指向null为止，证明反转完成
	 **/
	
	
	private ListNode reverseListNode(ListNode headerNode) {
		
		ListNode newHeaderListNode = null;
		
		while (headerNode != null) {
			ListNode tmpListNode = headerNode.next;
			headerNode.next = newHeaderListNode;
			newHeaderListNode = headerNode;
			headerNode = tmpListNode;
		}
		return newHeaderListNode;
	}
	
	
	
	
	
}
