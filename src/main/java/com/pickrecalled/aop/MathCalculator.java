package com.pickrecalled.aop;

public class MathCalculator {

	/**
	 * 除法
	 * @param i
	 * @param j
	 * @return
	 */
	public int div(int i, int j) {
		System.out.println("除法方法被调用....");
		return i / j;
	}
}
