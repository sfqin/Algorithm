package com.niuke;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目
 		 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤n,均为正整数)，
		牛牛现在想把新捕捉的鱼放入鱼缸。鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外
		一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。考虑到这个，牛牛要放入的鱼就需要保证： 
		1、放进去的鱼是安全的，不会被其他鱼吃掉 
		2、这条鱼放进去也不能吃掉其他鱼 
		鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。现在知道新放入鱼的大小范围[minSize,maxSize]
		(考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
		
		已经通过全部测试用例
 */ 
public class Main3 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		/**
		 * minSize 新放入的鱼的最小尺寸
		 * maxSize 新放入的鱼的最大尺寸
		 * n 鱼缸里面已经有的鱼的数量
		 * fishSize[i] 已经有的鱼的大小，以空格分隔，有多个是一个数组
		 * sum 用来计数到底有多少种大小的鱼
		 */
		int sum = 0;
		int minSize = scan.nextInt();
		int maxSize = scan.nextInt();
		int n = scan.nextInt();
		ArrayList<Integer> fishSize = new ArrayList<>();
		for(int i=0; i<n; i++){
			fishSize.add(scan.nextInt());
		}
		scan.close();
		
		for(int i=minSize; i<=maxSize; i++){
			//temsum记录本个尺寸和池中鱼比较的个数
			int temsum = 0;
			for (Integer integer : fishSize) {
				//如果放进去的鱼i 吃别人或者被别人吃
				if((i >= 2*integer && i <= 10*integer) || (integer >= 2*i && integer <= 10*i))
					break;
				else{
					temsum++;
				}
				if(temsum == fishSize.size())
					sum++;
			}
		}
		System.out.print(sum);
	}
}
