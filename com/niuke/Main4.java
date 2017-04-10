package com.niuke;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
	 * 
	 * @author qinzhe
	 *	如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。 
	 *	例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
	 *
	 *	输入：
	 * 		1.输入包括n+1行：
			2.第一行为单词个数n(1 ≤ n ≤ 50)
			3.接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成
				
		输出：
			1.输出循环单词的种数
			
	已经通过全部测试用例
*/
	

public class Main4 {
	
	
	//判断两个单词是否是一种循环单词
	public boolean isCircle(String str1, String str2){
		boolean flag = false;
		if(str1.length() == str2.length() && !str1.equals(str2))
		for(int i=1; i<str2.length(); i++){
			String pre = str2.substring(0, i);
			String fle = str2.substring(i, str2.length());
			String fin = fle+pre;
			if(str1.equals(fin)){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Main4 wordoow = new Main4();
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] word = new String[n];
		for (int i = 0; i < word.length; i++) {
			word[i] = scan.nextLine();
		}
		scan.close();
		//使用HashSet去除重复的单词
		HashSet<String> tmpSet = new HashSet<String>();
		for (int i = 0; i < word.length; i++) {
			tmpSet.add(word[i]);
		}
		word = new String[tmpSet.size()];
		Object[] obj =  tmpSet.toArray();
		for (int i = 0; i < obj.length; i++) {
			word[i] = (String)obj[i];
		}
		/**
		 * aword 装最后的单词 一种循环单词装一个
		 * aword1 装从aword中被踢出去的循环单词
		 */
		ArrayList<String> aword = new ArrayList<String>();
		ArrayList<String> aword1 = new ArrayList<String>();
		for (int i = 0; i < word.length; i++) {
			aword.add(word[i]);
		}
		for (int i = 0; i < word.length; i++) {
			ArrayList<String> tmpArray = new ArrayList<String>();
			if(aword1.contains(word[i]))
				continue;
			else{
				for (String str : aword) {
					if(wordoow.isCircle(str, word[i])){
						tmpArray.add(str);
					}
				}
				for (String string : tmpArray) {
					aword.remove(string);
					aword1.add(string);
				}
			}
		}
		System.out.print(aword.size());
	}
}
