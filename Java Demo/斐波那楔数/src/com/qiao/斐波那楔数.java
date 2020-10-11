package com.qiao;

public class 斐波那楔数 {
	
	/*
	 * 斐波那契数  0 1 1 2 3 5 8 13 ...
	 * 后一项数等于前两项之和
	 * 
	 *  耗时最短排名：O(1) > O(logn) > O(n) > O(nlogn) > O(n^2)
	 */
	
	//复杂度 O(2^n)
	public static int fib1(int n) {
		if (n <= 1) {return n;}
		return fib1(n-1) + fib1(n-2);
	}
	//复杂度 O(n)
	public static int fib2(int n) {
		if (n <= 1) {return n;}
		
		int first = 0;
		int second = 1;
		
		for (int i = 0; i < n - 1; i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	
	public static void main(String[] args) {
		System.out.println(fib2(2));
	}
	
}
