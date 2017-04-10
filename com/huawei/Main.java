package com.huawei;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	反转求和：将输入的两个整数，分别进行反转，然后求和。反转就如123->321  数的大小为1到70000
 *	例子：输入为
			123，456
      	输出为   
			975
			
	已完成，没测试地方
 */
public class Main {
	
	
	public int reveNum(int num){
		int lenth = (num + "").length();
		if(lenth == 1) 
			return num;
		else{
			int restNum = num / 10;
			int theNum = num % 10;
			return (int)Math.pow(10, lenth-1) * theNum + reveNum(restNum);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] all = scan.nextLine().split(",");
		int a = Integer.parseInt(all[0]);
		int b = Integer.parseInt(all[1]);
		scan.close();
		
		Main main = new Main();
		int result = main.reveNum(a) + main.reveNum(b);
		System.out.print(result);
	}
}
