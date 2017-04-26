package com.niuke;

import java.util.Scanner;
/**
 * 
 * @author qinzhe
 *	输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来 
 *	输入描述
 *		每个测试输入包含2个整数,n和m
 *	输出描述
 *		按每个组合的字典序排列输出,每行输出一种组合
 */

//public class Main2 {
	static int n = 0;
	static int m = 0;
	public void comb(int a){
		int diss;
		for(int i=0; i<n; i++){
			diss = n -a;
				if(diss >=1&&diss<=n)
					System.out.print(i + " " + diss);
				else if(diss == 0)
					System.out.print(diss);
		}
	}
	
	public void comb1(int a){
		int diss;
		for(int i=0; i<n; i++){
			diss = n -a;
			for(int j=0; j<n; j++)
				if(diss >=1&&diss<=n)
					System.out.print(i + " " + diss);
				else if(diss == 0)
					System.out.print(diss);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		for(int i=1; i<n; i++){
			int dis = m - i;
		}
	}
}
