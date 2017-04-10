package com.wangyi;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	现在有n位工程师和6项工作（编号为0至5），现在给出每个人能够胜任的工作
 *	序号表（用一个字符串表示，比如：045，表示某位工程师能够胜任0,4,5号工作）。
 *	现在需要进行工作安排，每位工程师不能安排到同一项工作当中去。如果两种工作安排
 *	中只有一人被安排在的工作序号不一样就被视为不同的工作安排，现在需要计算出
 *	有多少种不同的工作安排计划
 *
 *	输入描述
 *		输入有 n+1 行
 *		第一行为工程师的人数n(1<=n<=6)
 *		接下来的n行，每行一个字符串表示第i(1<=i<=n)个人能够胜任的工作（字符串不一定等长）
 *	输出描述
 *		有多少种安排
 *
 *	已过测试用例
 */
public class Main4 {
	
	//将可以的序列都存在a数组中，然后跟下一行进行比较再将无序序列添加进来，最后得到的数组长度即为 安排的种数
	public String[] getSques(String[] a, String b){
		int len = a.length*b.length();
		String[] result = new String[len];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			String str = a[i];
			for (int j = 0; j < b.length(); j++) {
				String onew = b.substring(j, j+1);
				if(str.contains(onew))
					continue;
				else{
					result[k] = str + onew;
					k++;
				}
			}
		}
		String[] resu = new String[k];
		System.arraycopy(result, 0, resu, 0, k);
		return resu;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] work = new String[n];
		for (int i = 0; i < n; i++) {
			work[i] = scanner.nextLine();
		}
		scanner.close();
		Main4 mian = new Main4();
//		String[] a = {"0","4","5"};
//		String b = "345";
//		String[] re = mian.getSques(a, b);
//		String rr = "123";
//		String[] resul = mian.getSques(re, rr);
//		System.out.println(resul);
		String[] result = {""};
		for (int i = 0; i < n; i++) 
			result = mian.getSques(result, work[i]);
		System.out.print(result.length);
	}
}
