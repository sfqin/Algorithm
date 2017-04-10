package com.wangyi;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	常规的表达式求值，我们都会根据计算的优先级来计算，比如 乘除的优先级就高于加减
 *	但是小意所生活的世界的表达式的规则很简单，从左往右依次计算即可，而且小意所在
 *	的世界没有除法，意味着表达式中没有/。现在给出一个表达式，需要你计算出小意所在
 *	世界表达式的值是多少
 *	输入描述 
 *		一行字符串，即一个表达式。其中的运算符只有 - + *。参与计算的数字只有0~9
 *		保证表达式都是合法的，排列规则如样例琐事
 *	输出描述  
 *		输出一个数 即表达式的值
 *
 *	以过测试用例
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
//		String line = "3+8*2-4*0";
		int result = Integer.parseInt(line.substring(0, 1));
		String reg = "";
		for (int i = 1; i < line.length(); i++) {
			if(i%2 == 0){
				int b = Integer.parseInt(line.substring(i,i+1));
				if(reg.equals("*"))
					result = result * b;
				else if(reg.equals("-"))
					result = result - b;
				else if(reg.equals("+"))
					result = result + b;
			}else{
				reg = line.substring(i,i+1);
			}
		}
		System.out.print(result);
		
	}
}
