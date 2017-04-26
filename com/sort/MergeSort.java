package com.qinzhe.sort;

/**
 * 
 * @author qinzhe
 *	归并排序
 */
public class MergeSort {
	
	/**
	 * 二路并归排序
	 * 将两个有序的表组合成一个新的有序表。假定待排序表含有n个记录，则可看成是n个有序表，每个表的长度为1，
	 * 然后两两归并，直到合并成一个长度为n的有序表为止.
	 * @param src
	 * @param low
	 * @param high
	 * 
	 * 稳定
	 */
	public static void mergefrom2(int[] src, int low, int high){
		if(low < high){
			int mid= (low + high) / 2;
			mergefrom2(src, low, mid);
			mergefrom2(src, mid+1, high);
			Merge(src, low, mid, high);
		}
	}
	
	/**
	 * 将有序的相邻的两个有序表 src[low,mid] src[mid+1,high] 合并为一个有序表
	 * 其中用到了一个辅助数组 src1 
	 * @param src
	 * @param low
	 * @param mid
	 * @param high
	 */
	private static void Merge(int[] src, int low, int mid, int high) {
		int[] src1 = new int[src.length];
		for (int i = low; i <= high; i++) 
			src1[i] = src[i];
		int i,j,k;
		for (i=low, j=mid+1, k=i; i <= mid && j<=high; k++) 
			src[k] = src1[i] <= src[j] ? src1[i++] : src1[j++];
		while(i <= mid) src[k++] = src1[i++];
		while(j <= high) src[k++] = src1[j++];
	}
	
	public static void main(String[] args) {
		int[] test1 = {3,1,6,9,4,5,100,7,-1};
		int[] test = {5,2,7,3,6,1,8};
		mergefrom2(test1,0,test1.length-1);
		mergefrom2(test,0,test.length-1);
		System.out.println(0000); 
	}
}
