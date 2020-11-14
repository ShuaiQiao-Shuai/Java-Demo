package com.qiao;

public class LinkedList_单向环形链表<E> extends AbstractList<E>{

	private static class Node<E> {
		E element;
		Node<E> nextNode;
		public Node(E element, Node<E> nextNode) {
			this.element = element;
			this.nextNode = nextNode;
		}
	}
	
	//private int size;
	private Node<E> firstNode;
	
	
	@Override
	public void addElementWithIndex(int index, E element) {
		
		checkIndexForAdd(index);
		
		if (index == 0) {
			Node<E> newNode = new Node<>(element, firstNode);
			Node<E> node = (size == 0) ? newNode : getCurrentIndexNode(size-1);
			node.nextNode = newNode;
			firstNode = newNode;
		}else {
			//先获取上一个节点的node
			Node<E> lastNode = getCurrentIndexNode(index - 1);
			//index新加入node的next指向后一个node
			//再将上一个node中next指向新加入的node
			lastNode.nextNode = new Node<>(element, lastNode.nextNode);
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
			if (size == 1) {
				firstNode = null;
			}else {
				//要先执行获取最后一个node,不然下一行改变了first的指针,获取的node就不准了
				Node<E> node = getCurrentIndexNode(size - 1);
				firstNode = firstNode.nextNode;
				node.nextNode = firstNode;
			}
		}else {
			Node<E> node = getCurrentIndexNode(index - 1);
			node.nextNode = node.nextNode.nextNode;
		}
		size--;
	}
	
	public void cleanAllElement() {
		size = 0;
		//只需将头节点的指针断掉，剩下node会自动销毁
		firstNode = null;
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
		Node<E> node = firstNode;
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		return node;
	}
	
	
	@Override
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
