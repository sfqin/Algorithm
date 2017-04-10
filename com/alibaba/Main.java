package com.alibaba;

/**
 * 
 * @author qinzhe
 *	对于一个长度为N的整型数组A，数组里所有的数都是正整数，对于两个满足0<=X<=Y<N的整数，A[x],A[x+1]...A[y]构成A的一个切片，记作(x,y)。
 *	用三个下标m1,m2,m3下标满足条件 0<m1,m1+1<m2<m2+1<m3<N-1。
 *	可以把这个整型数组分为(0,m1-1),(m1+1,m2-1),(m2+1,m3-1),(m3+1,N-1)四个切片。如果这四个切片中的整数求和相等，称作“四等分”。
 *	编写一个函数，求给定的整型数组是否可以四等分，如果可以，返回一个boolean类型的true，否则返回false
 *	限制条件 数组A最多有1000000项，数组中的整数介于  -1000000到1000000之间。
 *	要求时间复杂度为O(N),使用的额外存储空间(除了数组外)最多为O(N).
 *	2,5,1,1,1,1,4,1,7,3,7       2,5    1,1,1,4   7   7  true
 *	10,2,11,13,1,1,1,1,1  false
 *
 *	已完成，但是没有测试地方
 */
public class Main {
	
	/**
	 * 
	 * @param A
	 * @return 	第一个元素为等分元素的和
	 * 			第二个元素为第一个分割点的下标，
	 * 			第三个元素第二个分割点的位置，但是第一个次先返回0，
	 * 			第四个元素为第三个分割点的位置
	 */
	static int[] find_Val_1_3(int[] A){
		int v1 = 0,v4 = 0;
		for (int i = 0,j = A.length-1; i<j;) {
			
			if(v1 < v4){
				v1 += A[i];
				i++;
			}else if(v1 > v4){
				v4 += A[j];
				j--;
			}else{
				int m = A.length - 3 - (i + A.length -j -1);
				if(m >= 2 && m <= 2*v1){
					int[] result = {v1,i,0,j};
					return result;
				}
				else{
					v1 += A[i];
					i++;
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param A 总的数组
	 * @param val 等分元素每一部分的和
	 * @param pre 从此处下标开始
	 * @param pfix 从此处下标结束
	 * @return 找出 pre 到 下标 x 的和等于 val ，然后返回 x
	 */
	static int checkingFind(int[] A, int val, int pre, int pfix){
		int s = 0;
		for (int i = pre; i < pfix; i++) {
			s += A[i];
			if(s == val)
				return i+1;
		}
		return -1;
	}
	
	static boolean resovle(int[] A){
		int[] re = find_Val_1_3(A);
		if(re == null)
			return false;
		re[2] = checkingFind(A, re[0], re[1]+1, re[3]-1);
		int v3 = checkingFind(A, re[0], re[2]+1, re[3]);
		if(v3 == re[3])
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		int[] test = {2,5,1,1,1,1,4,1,7,3,7 };
		int i = test.length;
		boolean result = resovle(test);
		System.out.println(result);
	}
}
