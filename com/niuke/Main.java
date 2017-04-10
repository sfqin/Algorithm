package com.niuke;
import java.util.Scanner;
/**
 * 
 * @author qinzhe
 *	将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I 
 *	输入描述
 *		每个测试输入包含1个测试用例：  I like  beijing. 输入用例长度不超过100
 *	输出描述
 *		依次输出倒置之后的字符串,以空格分割
 *
 *	已经通过全部测试用例
 */
public class Main{
    public static void main(String[] args){
        Main worder = new Main();
        Scanner sacn = new Scanner(System.in);
        String str = sacn.nextLine();
        String[] fin = str.split(" ");
        for(int i = 0; i < fin.length; i++){
            System.out.print(fin[fin.length - i-1] + " ");
        }
    }
}