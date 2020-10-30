package com.qiao;

import com.qiao.反转链表.ListNode;

public class 判断环形链表是否有环 {

	/**
	 * 思路 ： 快慢指针
	 * 1 慢指针每次移动1个位置，快指针每次移动2个位置
	 * 2 如果没有环，快指针 或者 快指针.next 会指向null
	 * 3 如果有环，最终快指针和慢指针相遇（类似操场跑道）
	 * */
	
	
	public boolean NodeListHaveHuan(ListNode header) {
		
		if (header == null || header.next == null) return false;
		
		ListNode slowListNode = header;
		ListNode fastListNode = header.next;
		
		while (fastListNode != null && fastListNode.next != null) {
			
			slowListNode = slowListNode.next;
			fastListNode = fastListNode.next.next;
			
			if (slowListNode == fastListNode) return true;
		}
		return false;
	}
	
	
}
