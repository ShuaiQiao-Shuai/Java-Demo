package com.qiao;

//interface：接口 只能声明方法，不能实现
public interface List<E> {
	
	static final int DEFAULT_NOT_FOUND = -1;
	
	int size();
	
	void add(E elememt);
	
	void addElementWithIndex(int index , E element);
	
	void setElementWithIndex (int index , E element);
	
	void removeElementAtIndex(int index);
	
	void cleanAllElement();
	
	E getElementFromIndex(int index);
	
	boolean contains(E element);
	
	int elementForIndex(E element);
	
	boolean isEmpty();
}
