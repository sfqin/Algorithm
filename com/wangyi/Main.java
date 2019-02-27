package wangyi;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *
 *	小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 *	每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),一旦某个位置的数字大于等于100就马
 *	上对100取模(比如某个位置变为103,就会自动变为3).现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。
 *	输入描述:	输入数据包括两行：
 *		第一行为两个整数n(2 ≤ n ≤ 50)和k(1 ≤ k ≤ 2000000000),以空格分隔
 *		第二行为魔力手环初始的n个数，以空格分隔。范围都在0至99.
 *	输出描述:
 *		输出魔力手环使用k次之后的状态，以空格分隔，行末无空格。
 *	测试用例全部通过
 */
public class Main {
	
	//得到那个矩阵
	public static int[][] getTheArray(int n){
		int[][] result = new int[n][n];
			
		for (int i = 0; i < n; i++) {
			if(i == n-1){
				result[i][0] = 1;
				result[i][i] = 1;
			}else{
				result[i][i] = 1;
				result[i][i+1] = 1;
			}
		}
		return result;
	}
	
	//一边求矩阵乘法一边取余数
	public static int[][] muiltAndMod(int[][] a, int[][] b){
		int row = a.length;
		int colum = b[0].length;
		int muiltNum = a[0].length;
		int[][] result = new int[row][colum];
		
		for (int i = 0; i < row; i++) {
			int j = 0;
			for (j = 0; j < colum; j++) {
				for (int k = 0; k < muiltNum; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
				result[i][j] %= 100;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] allNum = new int[n][1];
		for (int i = 0; i < n; i++) {
			allNum[i][0] = scanner.nextInt();
		}
		scanner.close();
		
		int[][] midArray = getTheArray(n);
		
		//使用快速幂取余法可以大大减少循环的次数
		while(k>0){
			if(k % 2 ==1){
				allNum = muiltAndMod(midArray, allNum);
			}
			midArray = muiltAndMod(midArray, midArray);
			k >>= 1;
		}
		
		for (int i = 0; i < n; i++) {
			if(i == 0)
				System.out.print(allNum[i][0]);
			else
				System.out.print(" " + allNum[i][0]);
		}
	}
}