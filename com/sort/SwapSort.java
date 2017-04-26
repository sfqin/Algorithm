package com.qinzhe.sort;

/**
 * 
 * @author qinzhe
 *	两种交换排序
 */
public class SwapSort {

	/**
	 * 
	 * @param src
	 * 冒泡排序
	 * 从后往前两两比较相邻元素的值，若为逆序，则交换它们，知道序列比较完成。
	 */
	public static void bubble(int[] src){
		for (int i = 0; i < src.length-1; i++) {
			boolean flag = false;
			for (int j = src.length-1; j > i; j--) {
				if(src[j] < src[j-1]){
					int temp = src[j];
					src[j] = src[j-1];
					src[j-1] = temp;
					flag = true;
				}
			}
			if(flag == false)
				return ;
		}
	}
	
	/**
	 * 
	 * @param src
	 * 
	 * 基本思想是基于分治的，在待排序的序列中选取一个元素作为基准，通过一趟排序将待排序表划分为独立的两部分，
	 * 一部分都小于该元素，一部分都大于该元素。而后分别递归两个子序列，直到每个部分都只有一个元素或为空为止。
	 * 
	 * 不稳定
	 * 
	 */
	public static void quick(int[] src, int low, int high){
		if(low<high){
			int pivot = Partition(src, low, high);
			quick(src, low, pivot-1);
			quick(src, pivot+1, high);
		}
	}
	
	/**
	 * 一个排序，将一个基准元素排到最终的位置
	 * 
	 * @param src
	 * @param low
	 * @param high
	 * @return 选取的基准元素的最终位置
	 */
	private static int Partition(int[] src, int low, int high) {
		int pivot = src[low];
		while(low<high){
			while(low<high && src[high] >= pivot)
				--high;
			src[low] = src[high];
			while(low<high && src[low] <= pivot)
				++low;
			src[high] = src[low];
		}
		src[low] = pivot;
		return low;
	}

	public static void main(String[] args) {
		int[] test1 = {3,1,6,9,4,5,100,7,-1};
		int[] test = {5,2,7,3,6,1,8};
		quick(test, 0, test.length-1);
		System.out.println(0000); 
	}
}
