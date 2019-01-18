package wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author qinzhe
 *	一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，
 *	每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 *	输入描述：
 *		输入包括两行：
 *		第一行为整数n(1 ≤ n ≤ 50)
 *		第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 *	输出描述：
 *		输出一个整数，表示最少需要处理的时间
 */
public class Main5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] length = new int[n];
		for (int i = 0; i < length.length; i++) {
			length[i] = scanner.nextInt();
		}
		scanner.close();
		
		int time1 = 0;
		int time2 = 0;
		
		Arrays.sort(length);
		for (int i = length.length-1; i >= 0; i--) {
			if(time1 > time2){
				time2 += length[i];
				System.out.println("time2 的元素  ---->  " + length[i] + "  time2的和为------>" + time2 + "   time1的和为------>" + time1);
			}else{
				time1 += length[i];
				System.out.println("time1 的元素  ---->  " + length[i] + "   time1的和为------>" + time1 + "  time2的和为------>" + time2);
			}
		}
//		10
//		1411072 2110464 1388544 2362368 1103872 59392 133120 1184768 1500160 1332224
		System.out.println(length);
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time1 > time2 ? time1 : time2);
	}

}
