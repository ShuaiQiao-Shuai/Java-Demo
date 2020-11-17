package com.qiao;

import java.nio.channels.FileChannel.MapMode;

@SuppressWarnings("unused")

public class LinkedList_双向循环链表<E> extends AbstractList<E>{

	private static class Node<E> {
		E element;
		Node<E> nextNode;
		Node<E> prevNode;
		public Node(Node<E> prevNode,E element, Node<E> nextNode) {
			this.prevNode = prevNode;
			this.element = element;
			this.nextNode = nextNode;
		}
	}
	
	//private int size;
	private Node<E> firstNode;
	private Node<E> lastNode;
	
	
	@Override
	public void addElementWithIndex(int index, E element) {
		
		checkIndexForAdd(index);	
		// ----- 双向链表的写法：
		if (index == size) {//index == size 添加在最后一位
			
			Node<E> newNode = new Node<>(lastNode, element, firstNode);
			if (size == 0) {
				firstNode = lastNode = newNode;
				newNode.prevNode = firstNode;
				newNode.nextNode = firstNode;
			}else {
				lastNode.nextNode = newNode;
				lastNode = newNode;
				firstNode.prevNode = newNode;
			}
		}else {
			//index == 0 或者 index < size
			Node<E> node = getCurrentIndexNode(index);
			Node<E> last = node.prevNode;
			Node<E> newNode = new Node<>(node.prevNode, element, node);
			node.prevNode = newNode;
			last.nextNode = newNode;
			if (index == 0) {//index == 0 的情况
				firstNode = newNode;
			}
		}
		size++;
		
	}
	@Override
	public void setElementWithIndex(int index, E element) {
		getCurrentIndexNode(index).element = element;
	}
	@Override
	public void removeElementAtIndex(int index) {
		checkIndex(index);
		
		if (size == 1) {
			firstNode = null;
			lastNode = null;
		}else {
			Node<E> node = getCurrentIndexNode(index);
			Node<E> next = node.nextNode;
			Node<E> last = node.prevNode;
			last.nextNode = next;
			next.prevNode = last;
			
			if (node == firstNode) { // index == 0
				firstNode = next;
			}
			
			if (node == lastNode) { // index == size - 1
				lastNode = last;
			}
		}
		
		//用下面这个方法等效
		
//		if (size == 1) {
//			firstNode = lastNode = null;
//		}else {
//			Node<E> node = getCurrentIndexNode(index);
//			if (index == 0) {
//				firstNode = node.nextNode;
//				firstNode.prevNode = null;
//			}else if (index == (size -1)) {
//				lastNode = node.prevNode;
//				lastNode.nextNode = null;
//			}else {
//				node.prevNode.nextNode = node.nextNode;
//				node.nextNode.prevNode = node.prevNode;
//			}
//		}
		size--;
	}
	
	public void cleanAllElement() {
		size = 0;
		//只需将头节点的指针断掉，剩下node会自动销毁
		firstNode = null;
		lastNode = null;
	}
	
	@Override
	public E getElementFromIndex(int index) {
		return getCurrentIndexNode(index).element;
	}
	
	@Override
	public int elementForIndex(E element) {
		
		Node<E> node = firstNode;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.nextNode;
			}
		}else {
			for (int i = 0; i < size; i++) {
				if (node.element.equals(element)) return i;
				node = node.nextNode;
			}
		}
		return DEFAULT_NOT_FOUND;
	}
	
	private Node<E> getCurrentIndexNode(int index) {
		checkIndex(index);
		
		if (index < (size >> 1)) {
			Node<E> node = firstNode;
			for (int i = 0; i < index; i++) {
				node = node.nextNode;
			}
			return node;
		}else {
			Node<E> node = lastNode;
			for (int i = size - 1; i > index; i--) {
				node = node.prevNode;
			}
			return node;
		}
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		Node<E> node = firstNode;
		for (int i = 0; i < size; i++) {
			 sb.append(node.element+"-");
			 node = node.nextNode;
		}
		return sb.toString();
	}
	
}
