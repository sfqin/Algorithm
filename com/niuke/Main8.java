package com.niuke;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：在这本算法书页码中0~9每个数字分别出现了多少次？ 
 *	输入描述:
 *		输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 *	输出描述:
 *		输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格。
 */
public class Main8 {
	
	public static int getReapt(int num,int val){
		int times = 0;
		String numString = num + "";
		char[] numChars = numString.toCharArray();
		char valt = (char) (val+48);
		for (int i = 0; i < numChars.length; i++) {
			if(numChars[i] == valt)
				times++;
		}
		return times;
	}
	
	public static int getTimes(int start, int end, int val) {
		int count = 0;
		for (int i = start; i <= end; i++) {
			count += getReapt(i, val);
		}
		return count;
	}
	
	public static int getZeroTimes(int n){
		int count = 0;
		String nString = n + "";
		int length = nString.length();
		for (int i = 1; i < length; i++) {
			int tempNum = 0;
			if(i == 1)
				tempNum = 0;
			else {
				tempNum = 9;
			}
			
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		String nString = n + "";
		int[] result = new int[10];
		int length = nString.length();
		for (int i = 0; i < 10; i++) {
			int count = 0;
			if(length == 1)
				count = 0;
			else if(length == 2)
				count = 1;
			else{
				count = (int) ((length-1) * Math.pow(10, (length-2)));
			}
			int endNum = getTimes((int)Math.pow(10, length-1), n, i);
			count += endNum;
			result[i] = count;
		}
		int exceptZero = 0;
		for(int i=2; i<=length; i++){
			exceptZero += Math.pow(10, i-1);
		}
		result[0] = (int) (result[0] - exceptZero -1 + Math.pow(10, length-1));
		for (int i = 0; i < result.length; i++) {
			if(i == 0)
				System.out.print(result[i]);
			else
				System.out.print(" "+result[i]);
		}
		
	}

}
