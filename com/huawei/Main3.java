package com.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author qinzhe
 *	
 *	屏幕负责给出1-9中任意三个数字，大家以最快的时间给出这几个数字可拼成的数字从小到大排列位于第N位置的数字，其中N为给出的数字中最大的
 *	(如果不到这么多个数字则给出最后一个即可)，谁最快给出谁得奖。
 *	注意：屏幕如果给的是2，大家可把它当作2,也可以当作5来拼接数字；同理，如果屏幕是5，大家可以把它当作5，也可以把它当作2来拼接数字，但屏幕不能同时给出2与5
 *		屏幕如果给的是6，大家可把它当作6,也可以当作9来拼接数字；同理，如果屏幕是9，大家可以把它当作9，也可以把它当作6来拼接数字，但屏幕不能同时给出6与9
 *	现在要编写一个程序，根据给出的数学计算出能组合的所有数字以及最终的正确答案
 *
 *	输入：三个数字，用逗号隔开的
 *	输出：第N个位置的数，如果没有则给出最后一个,如果输入不和要求的或者非法字符，则返回-1
 *
 *	已经完成，没有地方测试
 */
public class Main3 {

	public static int dealSystemin(String str){
		String[] numList = str.split(",");
		int maxNum = 0;
		try {
			if(numList.length != 3)
				return -1;
			int num1 = Integer.parseInt(numList[0]);
			int num2 = Integer.parseInt(numList[1]);
			int num3 = Integer.parseInt(numList[2]);
			if(num1 <= 0 || num1 > 9 || num2 <= 0 || num2 > 9 || num3 <= 0 || num3 > 9)
				return -1;
			HashSet<Integer> set = new  HashSet<>();
			set.add(num1);
			set.add(num2);
			set.add(num3);
			if(set.size() != 3)
				return -1;
			else if(set.contains(2) && set.contains(5) || set.contains(6) && set.contains(9))
				return -1;
			if(num1 > maxNum)
				maxNum = num1;
			if(num2 > maxNum)
				maxNum = num2;
			if(num3 > maxNum)
				maxNum = num3;
		} catch (Exception e) {
			return -1;
		}
		return maxNum;
	}
	
	public static void addOne(int num1, int num2, int num3, TreeSet<Integer> numList){
		numList.add(num1);
		numList.add(num2);
		numList.add(num3);
		if(numList.contains(2))
			numList.add(5);
		if(numList.contains(5))
			numList.add(2);
		if(numList.contains(6))
			numList.add(9);
		if(numList.contains(9))
			numList.add(6);
	}
	
	public static void addTwobyOne(TreeSet<Integer> numList){
		ArrayList<Integer> copyList = new ArrayList<>(numList);
		
		for (int i = 0; i < copyList.size(); i++) {
			for (int j = 0; j < copyList.size(); j++) {
				if(i == j)
					continue;
				else{
					numList.add(copyList.get(i)*10 + copyList.get(j));
				}
			}
		}
		Iterator it =  numList.iterator();
		while(it.hasNext()){
			Integer integer = (Integer) it.next();
			if ((integer+"").contains("25") || (integer+"").contains("52") || 
					(integer+"").contains("69") || (integer+"").contains("96"))
				it.remove();
		}
	}
	
	public static void addThr(int num1, int num2, int num3, TreeSet<Integer> numList, ArrayList<String> strList){
		
		for (String string : strList) {
			String[] strs = string.split(",");
			num1 = Integer.parseInt(strs[0]);
			num2 = Integer.parseInt(strs[1]);
			num3= Integer.parseInt(strs[2]);
			
			numList.add(num1*100+num2*10+num3);
			numList.add(num1*100+num3*10+num2);
			numList.add(num2*100+num1*10+num3);
			numList.add(num2*100+num3*10+num1);
			numList.add(num3*100+num1*10+num2);
			numList.add(num3*100+num2*10+num1);
		}
	}
	
	public static ArrayList<String> spareList(int num1, int num2, int num3){
		ArrayList<String> spArrayList = new ArrayList<>();
		String temp = num1 + "" + "," + num2 + "," + num3;
		spArrayList.add(temp);
		if(temp.contains("2")){
			String anthotemp = temp.replace('2', '5');
			spArrayList.add(anthotemp);
			if (temp.contains("6")) {
				String anthotemp1 = temp.replace('2', '5').replace('6', '9');
				spArrayList.add(anthotemp1);
			}
			if (temp.contains("9")) {
				String anthotemp1 = temp.replace('2', '5').replace('9', '6');
				spArrayList.add(anthotemp1);
			}
		}
		if (temp.contains("5")) {
			String anthotemp = temp.replace('5', '2');
			spArrayList.add(anthotemp);
			if (temp.contains("6")) {
				String anthotemp1 = temp.replace('5', '2').replace('6', '9');
				spArrayList.add(anthotemp1);
			}
			if (temp.contains("9")) {
				String anthotemp1 = temp.replace('5', '2').replace('9', '6');
				spArrayList.add(anthotemp1);
			}
		}
		if (temp.contains("6")) {
			String anthotemp = temp.replace('6', '9');
			spArrayList.add(anthotemp);
		}
		if (temp.contains("9")) {
			String anthotemp = temp.replace('9', '6');
			spArrayList.add(anthotemp);
		}
		return spArrayList;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		int N = dealSystemin(line);
		System.out.println("输入是否合法： "+ N);
		if (N > 0) {
			String[] strList = line.split(",");
			int num1 = Integer.parseInt(strList[0]);
			int num2 = Integer.parseInt(strList[1]);
			int num3 = Integer.parseInt(strList[2]);
			TreeSet<Integer> numList = new TreeSet<>();
			addOne(num1, num2, num3, numList);
			addTwobyOne(numList);
			ArrayList<String> arryList = spareList(num1, num2, num3);
			addThr(num1, num2, num3, numList, arryList);
			
			ArrayList<Integer> result = new ArrayList<>(numList);
			for (int i = 0; i < numList.size(); i++) {
				if(i == 0)
					System.out.print(result.get(i));
				else
					System.out.print(" " + result.get(i));
			}
			System.out.println();
			if(N > result.size())
				System.out.print(result.get(result.size()-1));
			else
				System.out.print(result.get(N-1));
		}
	}
}	