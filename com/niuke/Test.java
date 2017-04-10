package com.niuke;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedInputStream(System.in));
		String s = scan.next();
		
		ArrayList<String> list = new ArrayList<>();
		int[] arr = new int[15];
		
		String[] q = s.split(",");
		String ss=null;
		for(int i=0;i < q.length;i++){
			ss+=q[i];
		}
		char[] c = ss.toCharArray();
		sort(c);
		char[] c1 = { c[0], c[1] };
		char[] c2 = { c[0], c[2] };
		char[] c3 = { c[1], c[2] };

		for (int i = 0; i < c.length; i++) {
			list.add(c[i] + "");
		}
		getAllPermutations2(list, c1, 0, c1.length);
		getAllPermutations2(list, c2, 0, c2.length);
		getAllPermutations2(list, c3, 0, c3.length);
		getAllPermutations2(list, c, 0, c.length);

		for (int i = 0; i != list.size(); i++) {
			arr[i] = Integer.parseInt(list.get(i));
		}

		bubbleSort(arr);
		for(int i=0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
		
		System.out.println(arr[arr[2]-1]);
	}

	// 字典序
	static void getAllPermutations2(ArrayList<String> list, char[] cs, int i, int length) {
		sort(cs);
		permutations(list, cs, i, length);
	}

	static void sort(char[] a) {// 对字符数组进行快排
		int len = a.length;
		int low = 0, high = len - 1;
		quickSort(a, low, high);
	}

	public static void bubbleSort(int[] numbers) {
		int temp = 0;
		int size = numbers.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (numbers[j] > numbers[j + 1]) // 交换两数位置
				{
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	static void quickSort(char[] a, int l, int h) {
		if (l >= h) {
			return;
		}
		int low = l;
		int high = h;
		char k = a[low];
		while (low < high) {
			//
			while (high > low && a[high] >= k) {// 寻找元素右边比其小的
				high--;
			}
			a[low] = a[high];// 进行交换，K指向high
			while (low < high && a[low] <= k) {// 寻找元素左边比其大的
				low++;
			}
			a[high] = a[low];// 进行交换，K指向low
		}
		a[low] = k;// 将K赋给low
		quickSort(a, l, low - 1);
		quickSort(a, low + 1, h);
	}

	static void permutations(ArrayList<String> answers, char[] cs, int start, int len) {// cs为字典序数组
		if (cs == null)
			return;
		while (true) {
			answers.add(String.valueOf(cs));
			int j = start + len - 2, k = start + len - 1;
			while (j >= start && cs[j] > cs[j + 1])
				--j;
			if (j < start)
				break;

			while (cs[k] < cs[j])
				--k;

			swap(cs, k, j);

			int a, b;
			for (a = j + 1, b = start + len - 1; a < b; ++a, --b) {
				swap(cs, a, b);
			}
		}
	}

	static void swap(char[] cs, int i, int j) {
		char t;
		t = cs[i];
		cs[i] = cs[j];
		cs[j] = t;
	}
}
