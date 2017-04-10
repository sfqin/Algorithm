package com.huawei;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	一个骰子，左边为1，右边为2，前面为3，后面为4，上面为5，下面为6.向左翻滚记为L,
 *	向右翻滚记为R，向前翻滚记为F,向后翻滚记为B，顺时针旋转记为C,逆时针旋转记为A,
 *	输入一行字符串，例如：RA,根据字母的顺序做相应的翻滚或旋转，输出最后的骰子各面的数字。
 *
 *	已完成，没有测试地方
 */
public class Main1 {
	
	final static int LEFT = 0;
	final static int RIGHT = 1;
	final static int FRONT= 2;
	final static int BACK = 3;
	final static int UP = 4;
	final static int DOWN = 5;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		scanner.close();
		char[] list = line.toCharArray();
		int[] lrfbud = {1,2,3,4,5,6};
		for(int i=0; i<list.length; i++){
			switch (list[i]) {
			case 'L':
//				System.out.println("左转");
				int temp = lrfbud[UP];
				lrfbud[UP] = lrfbud[RIGHT];
				lrfbud[RIGHT] = lrfbud[DOWN];
				lrfbud[DOWN] = lrfbud[LEFT];
				lrfbud[LEFT] = temp;
				continue;
			case 'R':
//				System.out.println("右转");
				temp = lrfbud[UP];
				lrfbud[UP] = lrfbud[LEFT];
				lrfbud[LEFT] = lrfbud[DOWN];
				lrfbud[DOWN] = lrfbud[RIGHT];
				lrfbud[RIGHT] = temp;
				continue;
			case 'F':
//				System.out.println("前转");
				temp = lrfbud[UP];
				lrfbud[UP] = lrfbud[BACK];
				lrfbud[BACK] = lrfbud[DOWN];
				lrfbud[DOWN] = lrfbud[FRONT];
				lrfbud[FRONT] = temp;
				continue;
			case 'B':
//				System.out.println("后转");
				temp = lrfbud[UP];
				lrfbud[UP] = lrfbud[FRONT];
				lrfbud[FRONT] = lrfbud[DOWN];
				lrfbud[DOWN] = lrfbud[BACK];
				lrfbud[BACK] = temp;
				continue;
			case 'C':
//				System.out.println("顺转");
				temp = lrfbud[FRONT];
				lrfbud[FRONT] = lrfbud[RIGHT];
				lrfbud[RIGHT] = lrfbud[BACK];
				lrfbud[BACK] = lrfbud[LEFT];
				lrfbud[LEFT] = temp;
				continue;
			case 'A':
//				System.out.println("逆转");
				temp = lrfbud[FRONT];
				lrfbud[FRONT] = lrfbud[LEFT];
				lrfbud[LEFT] = lrfbud[BACK];
				lrfbud[BACK] = lrfbud[RIGHT];
				lrfbud[RIGHT] = temp;
				continue;
			default:
				System.out.println("错误输入！！");
				break;
			}
		}
		
		for (int i = 0; i < lrfbud.length; i++) {
			if(i == 0)
				System.out.print(lrfbud[i]);
			else
				System.out.print(" " + lrfbud[i]);
		}
	}
}
