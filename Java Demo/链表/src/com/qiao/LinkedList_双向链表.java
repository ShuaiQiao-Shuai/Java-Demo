package com.qiao;

import java.nio.channels.FileChannel.MapMode;

@SuppressWarnings("unused")

public class LinkedList_双向链表<E> extends AbstractList<E>{

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
		
		if (index == 0) {
			firstNode = new Node<>(firstNode.prevNode,element, firstNode);
		}else {
			//先获取上一个节点的node
			Node<E> lastNode = getCurrentIndexNode(index - 1);
			//index新加入node的next指向后一个node
			//再将上一个node中next指向新加入的node
			lastNode.nextNode = new Node<>(lastNode,element, lastNode.nextNode);
			
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
		if (index == 0) {
			firstNode = firstNode.nextNode;
			firstNode.prevNode = firstNode;
		}else {
			Node<E> node = getCurrentIndexNode(index - 1);
			node.nextNode = node.nextNode.nextNode;
			node.nextNode.prevNode = node;
		}
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
	
	
	
}
