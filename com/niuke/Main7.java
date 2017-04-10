package com.niuke;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	如果一个数字能表示为p^q(^表示幂运算)且p为一个素数,q为大于1的正整数,就称这个数叫做超级素数幂。现在给出一个正整数n,如果n是一个超级素数幂需要找出对应的p,q。 
 *	输入描述：
 *		输入一个正整数n(2 ≤ n ≤ 10^18)
 *	输出描述：
 *		如果n是一个超级素数幂则输出p,q,以空格分隔,行末无空格。
 *		如果n不是超级素数幂，则输出No
 *
 *	已经通过全部测试用例
 */
public class Main7 {

	//判断一个数是不是素数,由于前提条件n>=2
	public boolean isSuShu(Long n){
		boolean flag = true;
		for (long i = 2; i * i <= n; i++) {
			if(n % i == 0){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Long n = scan.nextLong();
		scan.close();
		Main7 main = new Main7();
		Long fin = 0L;
		for(int i=2; Math.pow(n, 1d/i)>=2; i++){
			double temNum = Math.pow(n, 1d/i);
			if((int)temNum == temNum && main.isSuShu((long)temNum)){
				System.out.print((int)temNum + " " + i);
				fin = (long) temNum;
				break;
			}
		}
		if(fin == 0){
			System.out.print("No");
		}
	}
}
