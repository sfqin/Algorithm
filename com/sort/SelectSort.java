package com.qinzhe.sort;

/**
 * 
 * @author qinzhe
 *	两种选择排序
 */
public class SelectSort {

	/**
	 * 
	 * @param src
	 * 简单选择排序
	 * 每一趟排序从后面的n-i+1个待排序的元素中选取关键字最小的元素，作为有序子序列的第i个元素，直到第n-1趟排序做完
	 */
	public static void easy(int[] src){
		for (int i = 0; i < src.length-1; i++) {
			int min = i;
			int j;
			//找到 已经有序的 序列[0,i,j...n] 前面的 0-i 已经有序了 找到 j-n中最小元素的下标
			for ( j= i+1; j < src.length; j++) {
				min = src[j] < src[min] ? j : min;
			}
			//交换最小元素和 i的位置
			int temp = src[i];
			src[i] = src[min];
			src[min] = temp;
		}
	}
	
	/**
	 * 
	 * @param src
	 * 堆排序
	 * 看成是完全二叉树序列，利用完全二叉树和孩子节点的内在关系，在当前的无序区中选择关键字最小的,
	 * 输出,然后将最后一个元素和堆顶元素进行交换，破坏了堆结构，再进行调整，直至最后一个(完成排序)
	 * 
	 * 步骤 1.构造初始堆   2.调整堆结构  3.输出根节点  4.将最后一个叶子节点和堆根元素互换位置  5.调整堆结构
	 * 构建大根堆(升序). 小根堆(降序)
	 * 
	 * 不稳定
	 * 
	 */
	public static void heap(int[] src){
		BuildMinHeap(src);
		for (int i = src.length-1; i > 0; i--) {
			int temp = src[i];
			src[i] = src[0];
			src[0] = temp;
			AdjustDown(src, 0, i-1);
		}
	}
	
	/**
	 * 
	 * 建立初始的大根堆
	 * @param src
	 * 
	 */
	private static void BuildMinHeap(int[] src) {
		for (int i = (src.length-1)/2; i >= 0; i--)
			AdjustDown(src, i, src.length-1);
	}
	
	/**
	 * 调整 以i为根节点，到j结束的堆为 小根堆
	 * @param src 待排序序列
	 * @param i 堆根
	 * @param j 到何处结束
	 */
	private static void AdjustDown(int[] src, int i, int j) {
		int temp = src[i];
		for (int k = 2*i+1; k <= j; k *=2) {
			//将k的值变为左右儿子中较大的那个的下标
			if (k < j && src[k] < src[k+1]) 
				k++;
			if(temp > src[k]) //如果父亲比儿子中较大的那个还大,则不需要交换了
				break;
			else{
				src[i] = src[k];
				i = k;
			}
		}
		src[i] = temp;
	}




	public static void main(String[] args) {
		int[] test1 = {3,1,6,9,4,5,100,7,-1};
		int[] test = {5,2,7,3,6,1,8};
		easy(test1);
		easy(test);
		System.out.println(0000); 
	}
}
