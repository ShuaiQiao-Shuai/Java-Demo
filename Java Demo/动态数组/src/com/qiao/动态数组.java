package com.qiao;


public class 动态数组 {

	public static void main(String[] args) {
		
		DynamicArray<Integer> dynamicArray = new DynamicArray<>();
		dynamicArray.add(1);
		dynamicArray.add(2);
		dynamicArray.add(3);
		dynamicArray.add(4);
		dynamicArray.add(5);
		
		//dynamicArray.addElementWithIndex(1, 9);
		
		System.out.println(dynamicArray);

	}
}
