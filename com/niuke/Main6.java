package com.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
 *	牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 *	10 7 12 8 11 那么抹除掉的整数只可能是9 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 *	
 *	输入描述
 *		输入包括2行：
 *		第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
 *		第二行为n个整数num[i] (1 <= num[i] <= 1000000000)
 *	输出描述
 *		在一行中输出所有可能是抹除掉的数,从小到大输出,用空格分割,行末无空格。如果没有可能的数，则输出mistake
 *
 *	已经通过全部测试用例
 */
public class Main6 {
	
	//判断这个数组的数是不是全是挨着的
	public boolean isNojump(int[] num){
		boolean flag = true;
			for (int i = 0; i < num.length-1; i++) {
				if(num[i+1] != num[i]+1)
					return false;
			}
		return flag;
	}
	
	//判断是否是非法的
	public boolean isOK(int[] num){
		boolean flag = false;
		int sum = 0;
		for (int i = 0; i < num.length-1; i++) {
			if(num[i+1] != num[i]+1)
				sum ++;
		}
		if(sum == 1)
			return true;
		return flag;
	}
	
	
	//给定一个数组排序后就差一个数了，返回这个数
	public int getNum(int[] num){
		Integer theNum = null;
		Arrays.sort(num);
		for (int i = 0; i < num.length-1; i++) {
			if(num[i+1]-num[i] == 2)
				theNum = num[i]+1;
		}
		return theNum;
	}
	
	public static void main(String[] args) {
		Main6 main = new Main6();
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
		}
		scan.close();
			Arrays.sort(num);
			if(num.length == 1 && num[0] == 1)
				//如果只有一个数而且是边界
				System.out.print(2);
			else if(num.length == 1 && num[0] == 1000000000)
				System.out.print(999999999);
			else if(main.isNojump(num)){
				//如果出现两边到头的情况
				if(num[0]-1 < 1 && num[n-1]+1 > 1000000000)
					System.out.println("mistake");
				else if(num[0]-1 >= 1 && num[0]-1 <=1000000000 && num[n-1]+1 > 1000000000)
					System.out.print(num[0]-1);
				else if(num[0]-1 < 1 && num[n-1]+1 <= 1000000000 && num[n-1]+1 >= 1)
					System.out.print(num[n-1]+1);
				else
					System.out.print(num[0]-1 + " " + (num[n-1]+1));
			}
			else{
				if(!main.isOK(num))
					System.out.println("mistake");
				else{
					int theNum = main.getNum(num);
					System.out.println(theNum);
					
				}
					
			}
	}

}
