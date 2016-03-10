/**
 * 
 */
package net.zhangwenbo;

import java.util.Stack;

/**
 * @author Iver3oN Zhang
 * @date 2016Äê3ÔÂ9ÈÕ
 * @email grepzwb@qq.com
 * StackImpl.java
 * Impossible is nothing
 */
public class StackImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x= 5647;
		//getNumber(x);
		getNumber2(x);
	}

	/**
	 * @param x
	 */
	private static void getNumber(int x) {
		// TODO Auto-generated method stub
		while(x>10){
			System.out.print(x%10+" ");
			x = x/10;
		}
		System.out.print(x);
	}

	private static void getNumber2(int x){
		Stack<Integer> stack = new Stack<>();
		while(x>10){
			stack.add(x%10);
			x = x/10;
		}
		stack.add(x);
		while(stack.size()>0){
			System.out.print(stack.pop()+" ");
		}
	}
}
