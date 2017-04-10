package com.niuke;

import java.util.Scanner;

/**
 * 
 * @author qinzhe
 *	DNA分子是以4种脱氧核苷酸为单位连接而成的长链，这4种脱氧核苷酸分别含有A,T,C,G四种碱基。
 *	碱基互补配对原则：A和T是配对的，C和G是配对的。如果两条碱基链长度是相同的并且每个位置的碱
 *	基是配对的，那么他们就可以配对合成为DNA的双螺旋结构。现在给出两条碱基链，允许在其中一条上
 *	做替换操作：把序列上的某个位置的碱基更换为另外一种碱基。问最少需要多少次让两条碱基链配对成功?
 *
 *	输入描述
 *		输入包括一行：包括两个字符串,分别表示两条链,两个字符串长度相同且长度均小于等于50
 *	输出描述
 *		输出一个整数，即最少需要多少次让两条碱基链配对成功
 *
 *	已经通过全部测试用例
 */
public class Main5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String both = scan.nextLine();
		scan.close();
		String[] bothLine = both.split(" ");
		char[] fir = bothLine[0].toCharArray();
		char[] sec = bothLine[1].toCharArray();
		int sum = 0;
		for (int i = 0; i < fir.length; i++) {
			if(fir[i] == 'A' && sec[i] != 'T')
				sum++;
			if(fir[i] == 'T' && sec[i] != 'A')
				sum++;
			if(fir[i] == 'C' && sec[i] != 'G')
				sum++;
			if(fir[i] == 'G' && sec[i] != 'C')
				sum++;
		}
		System.out.print(sum);
	}

}
