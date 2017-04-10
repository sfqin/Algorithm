package com.tengxun;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	给定一个正数 输入的值小于1000
 *	输出 有多少对质数的和等于输入的正数
 *
 *	已完成，没有地方测试
 */
public class Main {
	
	//判断一个数是不是素数,由于前提条件n>=2
		public boolean isSuShu(int n){
			boolean flag = true;
			for (int i = 2; i * i <= n; i++) {
				if(n % i == 0){
					flag = false;
					break;
				}
			}
			return flag;
		}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		Main mian = new Main();
		int count = 0;
		for (int i = 2; i <= n/2; i++) {
			int restNum = n-i;
			if(mian.isSuShu(i) && mian.isSuShu(restNum)){
				count++;
//				System.out.println(i+"+" +restNum + "="+ n);
			}
		}
		System.out.print(count);
	}
}
