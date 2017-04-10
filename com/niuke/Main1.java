package com.niuke;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.” 
 *	输入描述
 *		每个测试输入包含2个字符串
 *	输出描述
 *		输出删除后的字符串
 *
 *	已经通过全部测试用例
 */

public class Main1 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String sec = scan.nextLine();
		String word = scan.nextLine();
		scan.close();
		char[] sec1 = sec.toCharArray();
		String[] sec2 = new String[sec1.length];
		for(int i=0; i<sec1.length; i++)
			sec2[i] = String.valueOf(sec1[i]);
		char[] word1 = word.toCharArray();
		for(int i = 0; i< sec1.length; i++){
			for(int j = 0; j< word1.length; j++){
				if(sec1[i] == word1[j])
					sec2[i] = "";
			}
		}
		for (String s : sec2) {
			System.out.print(s);
		}
	}
}
