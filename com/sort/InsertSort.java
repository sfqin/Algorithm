package com.qinzhe.sort;


/**
 * 
 * @author qinzhe
 *	三种插入排序
 */
public class InsertSort {
	
	/**
	 * @param src
	 * 直接插入排序 
	 * 在有序序列中插入一个新的元素
	 * 
	 * j >= 0 && temp < src[j]  切记不能交换位置
	 * 
	 * 4 6 7   5 2
	 * 4 6 5 7 2 和7比较 交换
	 * 4 5 6 7 2 和6比较 交换
	 * 4 5 6 7 2 和4比较 不交换
	 * 
	 * 稳定
	 */
	public static void direct(int[] src){
		for (int i=1; i < src.length; i++) {
			int temp = src[i];
			int j;
			for (j = i-1; j >= 0 && temp < src[j]; j--) 
					src[j+1] = src[j];
			src[j+1] = temp;
		}
	}  
	/**
	 * 
	 * @param src
	 * 折半插入排序
	 * 也是基于有序的序列，新加入一个元素，先用二分查找找到需要插入的元素的位置
	 * 然后将此位置后面的元素全部后移动一个位置，最后把那个元素插入
	 * 
	 * 稳定
	 */
	public static void half(int[] src){
		
		for (int i = 1; i < src.length; i++) {
			int currentValue = src[i];
			int left = 0;
			int right = i - 1;
			while(left <= right){
				int mid = (left + right) >> 1;
				if(src[mid] > currentValue)
					right = mid - 1;
				else
					left = mid + 1;
			}
			
			for (int j = i; j > left; j--)
				src[j] = src[j-1];
			src[left] = currentValue;
		}
	}
	
	/**
	 * 
	 * @param src
	 * 希尔排序
	 * 是先将数组分为 src/d个组，对每个组进行直接插入排序
	 * 第二轮 d = d/2 在进行直接插入排序 ，一直这样进行下去
	 * 最后一轮的 d=1 即全组的直接插入排序  
	 * 
	 * 不稳定
	 * 
	 */
	public static void shell(int[] src){
		int d = src.length >> 1;
		while(d >=1){
			for (int i = d; i < src.length; i++) {
				int temp = src[i];
				int j;
				for (j = i-d; j >= 0 && temp < src[j]; j -= d) 
						src[j+d] = src[j];
				src[j+d] = temp;
			}
			d >>= 1;
		}
	}
	
	
	public static void main(String[] args) {
		int[] test = {3,1,6,9,4,5,100,7,-1};
		direct(test);
		System.out.println(0000);
	}
}
