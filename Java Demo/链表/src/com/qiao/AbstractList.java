package com.qiao;

//abstract表示抽象父类，不能声明。可以把子类的公共方法写进来，防止重复代码
public abstract class AbstractList<E> implements List<E> {

	/**
	 * 成员数量
	 */
	protected int size;
	
	public int size() {
		return size;
	}
	
	public void add (E element) {
		//elemArray[size++] = element;
		//上面方法同样达到add效果，但是扩容数组需要走下面方法(为了不写重复扩容代码)
		addElementWithIndex(size, element);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void cleanAllElement() {
		size = 0;
	}
	
	public boolean contains(E element) {
		return elementForIndex(element) != DEFAULT_NOT_FOUND;
	}
	
	protected void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index超出范围");
		}
	}
	
	protected void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index超出范围");
		}
	}
	
}
