package com.qinzhe.sort;

/**
 * 
 * @author qinzhe
 *	基数排序
 */
public class RadixSort {
	
	/**
	 * 
	 * @param src 待排序的数组
	 * @return 数组中最大的元素的位数
	 */
	public static int getMaxBit(int[] src){
		int max = src[0];
		for (int i = 1; i < src.length; i++) 
			max = src[i] > max ? src[i] : max;
		String maxString = max + "";
		return maxString.length();
	}
	
	/**
	 * 
	 * @param num 一个数
	 * @param pos 1代表个位,2代表十位,三代表百位 ...
	 * @return 这个数的第几位的数字
	 */
	public static int getNumInPos(int num, int pos){
//		String numString = num + "";
//		if(numString.length() < pos || pos < 1){
//			System.out.println(num + "没有" + pos + "这个位");
//			return -1;
//		}else{
			int tmp = 1;
			for (int i = 1; i < pos; i++) 
				tmp *= 10;
			return (num / tmp) % 10;
//		}
	}
	
	public static void sort(int[] src){
		int maxBit = getMaxBit(src);
		int[][] array = new int[10][src.length+1];
		for (int pos = 1; pos <= maxBit; pos++) {
			for (int i = 0; i < src.length; i++) {
				int row = getNumInPos(src[i], pos);
				System.out.println(row);
				int cloum = ++array[row][0];
				array[row][cloum] = src[i];
			}
			for (int i = 0,k=0; i < 10; i++) {
				for (int j = 1; j <= array[i][0]; j++) 
						src[k++] = array[i][j];
				array[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] test1 = {3,1,6,9,4,5,100,7123456,98};
		int re = getMaxBit(test1);
//		for (int i = -1; i < 10; i++) {
//			int nu = getNumInPos(1234567, i);
//			System.out.println(nu);
//		}
		sort(test1);
		System.out.println(0);
	}
}
