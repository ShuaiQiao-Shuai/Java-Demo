package com.qiao;

@SuppressWarnings("unchecked")

//泛型，类名后面加<E>,E可以是任意字符串，代表类型
public class DynamicArray<E> {

	/**
	 * 成员数量
	 */
	private int size;
	
	/**
	 * 成员数组
	 */
	private E[] elemArray;
	
	private static final int DEFAULT_Capacity = 10;
	private static final int DEFAULT_NOT_FOUND = -1;
	
	/**
	 * init
	 */
	public DynamicArray(int catipty) {
		catipty = (catipty < DEFAULT_Capacity) ? DEFAULT_Capacity : catipty;
		elemArray = (E[]) new Object[catipty];
	}
	public DynamicArray() {
		// this 可以直接调用 同名含参 函数
		this(DEFAULT_Capacity);
	}
	
	public int size() {
		return size;
	}
	
	
	public void add (E element) {
		//elemArray[size++] = element;
		//上面方法同样达到add效果，但是扩容数组需要走下面方法(为了不写重复扩容代码)
		addElementWithIndex(size, element);
	}
	
	public void addElementWithIndex(int index , E element) {
		checkIndexForAdd(index);
		//检查是否需要扩容
		ensuerSize(size + 1);
		// [1,2,3,4,5]
		// 比如增加index=2，将"3"及其之后元素全部后移一位，然后新element赋值到index=2
		for (int i = size; i >= index+1; i--) {
			elemArray[i] = elemArray[i-1];
		}
		elemArray[index] = element;
		size++;
	}
	
	/**
	 * 数组元素替换
	 */
	public void setElementWithIndex (int index , E element) {
		checkIndex(index);
		elemArray[index] = element;
	}
	/**
	 * 移除元素
	 */
	public void removeElementAtIndex(int index) {
		// [1,2,3,4,5,6,7]
		// 比如删除index=2，将"3"这个元素移动到最后一位
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elemArray[i] = elemArray[i+1];
		}
		size--;
	}
	
	public void cleanAllElement() {
		size = 0;
	}
	
	/**
	 * 根据角标，获取元素
	 */
	public E getElementFromIndex(int index) {
		checkIndex(index);
		return elemArray[index];
	}	
	/**
	 * 是否包含某元素
	 */
	public boolean contains(E element) {
		return elementForIndex(element) != DEFAULT_NOT_FOUND;
	}
	/**
	 * 根据元素返回坐标
	 */
	public int elementForIndex(E element) {
		for (int i = 0; i < size; i++) {
			//用equals 如果类里没有主动实现equals方法，与==相同，会比较内存地址是否一致
			//如果类主动实现了equals，equals方法里可以自定义比较的规则
			if (elemArray[i].equals(element)) return i;
		}
		return DEFAULT_NOT_FOUND;
	}
	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	//**********************************************
	
	private void ensuerSize(int newSize) {
		int oldSize = elemArray.length;
		if (oldSize >= newSize) return;
		
		//扩容的原理就是申请一个新的更大的数组，让原数组内存地址指向新的数组
		//旧数组会自动释放
		int newArraySize = oldSize + (oldSize >> 1);//位运算 (>>1)相当于除以2=(2^1)  (<<1)相当于乘以2=(2^1)
		
		E[] newArray = (E[]) new Object[newArraySize];
		
		for (int i = 0; i < size; i++) {
			newArray[i] = elemArray[i];
		}
		elemArray = newArray;
		System.out.println(oldSize + "扩容" + newArraySize);
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index超出范围");
		}
	}
	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index超出范围");
		}
	}
	
	@Override 
	//自定义打印方法，类似iOS里的descrition
	public String toString() {
		// size = 3 [1,2,3]
		// 多处拼接建议使用StringBuilder
		StringBuilder string = new StringBuilder();
		string.append("size = ").append(size).append(" [");
 		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(",");
			}
			string.append(elemArray[i]);
		}
		string.append("]");
		return string.toString();
	}
	
}
