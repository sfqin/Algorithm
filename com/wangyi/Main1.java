package com.wangyi;

import java.util.Scanner;


/**
 * 
 * @author qinzhe
 *	小意走在街上 突然服务器发来劲爆 群修bug 假设市区是无限大的区域
 *每个街道坐标是（x，y）小意当前在（0,0）办公室在（gx，gy）街道上。
 *小意周围有多个出租车打车点，赶去办公室有两种办法 一是走路 2是走到
 *打车点去打车去公司。每次移动到相邻的街道横向或者纵向走路都会花费 walkTime
 *时间，打车讲花费taxiTime时间。小意需要尽快到公司  现在小意想知道最快的的时间
 *
 *	输入 
 *	第一行   周围出租车打车点的个数  1《=n《=50
 *	第二行 每个出租车的打车点的横坐标 tx【i】 -10000   10000
 *	第三行 每个出租车的纵坐标 ty【i】 -10000 10000
 *	第四行 办公室的坐标 gx，gy -10000《= gx，gy《=10000 空格分隔
 *	第五行为走路的时间walkTime 1  1000 和taxiTime 1 1000
 *
 *	已过测试用例
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		String[] tx = scanner.nextLine().split(" ");
		String[] ty = scanner.nextLine().split(" ");
		String[] gxgy = scanner.nextLine().split(" ");
		String[] walkTaxi = scanner.nextLine().split(" ");
		int walkTime = Integer.parseInt(walkTaxi[0]);
		int taxiTime = Integer.parseInt(walkTaxi[1]);
		scanner.close();
		
//		int n = 2;
//		String[] tx = {"-2","-2"};
//		String[] ty = {"0","-2"};
//		String[] gxgy = {"-4","-2"};
//		String[] walkTaxi = {"15","3"};
//		int walkTime = Integer.parseInt(walkTaxi[0]);
//		int taxiTime = Integer.parseInt(walkTaxi[1]);
		
		int minTime = 10000000;
		//单纯的走路
		int shu = Math.abs(Integer.parseInt(gxgy[0]));
		int heng = Math.abs(Integer.parseInt(gxgy[1]));
		int disworkTime = (Math.abs(Integer.parseInt(gxgy[0]))+Math.abs(Integer.parseInt(gxgy[1])))*walkTime;
		if( disworkTime < minTime)
			minTime = ((Math.abs(Integer.parseInt(gxgy[0]))+Math.abs(Integer.parseInt(gxgy[1]))))*walkTime;
		//每个出租车到公司要多远
		for (int i = 0; i < n; i++) {
			int dischetocomp = Math.abs(Integer.parseInt(gxgy[0])-Integer.parseInt(tx[i])) + 
							   Math.abs(Integer.parseInt(gxgy[1])-Integer.parseInt(ty[i]));
			int cheTime = dischetocomp*taxiTime;
			int disprotoche = (Math.abs(Integer.parseInt(tx[i]))+Math.abs(Integer.parseInt(ty[i])));
			int peoTime = disprotoche*walkTime;
			int totalTime = cheTime+peoTime;
			if(totalTime<minTime)
				minTime = totalTime;
		}
		
		System.out.print(minTime);
	}
	
	
	
}
