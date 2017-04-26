package com.huawei;

import java.util.ArrayList;
/**
 * 
 * @author qinzhe
 *	输入5个任务ID，任务优先级，开始运行时间和任务运行时长，其中调度过程支持抢占式，即优先级
 *	高的任务可抢占正在运行的优先级值低的任务，最后输出前200秒，任务的调度过程
 *	输入描述：
 *		任务信息输入格式为：[任务ID.任务优先级.任务开始运行时间.任务运行时长];任务与任务之间使用
 *		"|" 隔离；五个任务的任务ID为1-5，任务优先级范围为0-200
 *	输出描述：
 *		输出任务信息为：任务ID.任务运行时长；任务之间用 "|" 隔离； 如果无任务运行，则任务ID为0
 */
//public class Main4 {
	
	public static int getMaxPro(ArrayList<int[]> taskPool){
		int maxNum = -1;
		for (int i = 0; i < taskPool.size(); i++) {
			maxNum = taskPool.get(i)[1] > maxNum ? taskPool.get(i)[1] : maxNum;
		}
		return maxNum;
	}
	
	public static ArrayList<Integer> getMinTime(ArrayList<int[]> taskPool){
		ArrayList<Integer> listID = new ArrayList<>();
		int minNum = 300;
		for (int i = 0; i < taskPool.size(); i++) {
			minNum = taskPool.get(i)[2] < minNum ? taskPool.get(i)[2] : minNum;
		}
		for (int i = 0; i < taskPool.size(); i++) {
			if(taskPool.get(i)[2] == minNum)
				listID.add(taskPool.get(i)[0]);
		}
		return listID;
	}
	
	public static int[][] getTasks(String line){
		String[] taskline = line.split("\\|");
		int[][] result = new int[5][4];
		for (int i = 0; i < 5; i++) {
			String[] midStringtask = taskline[i].substring(1, taskline[i].length()-1).split("\\.");
			for (int j = 0; j < 4; j++) {
				result[i][j] = Integer.parseInt(midStringtask[j]);
			}
		}
		
		return result;
	}
	
	public static ArrayList<int[]> gettaskPool(int[][] tasks, int currentTime){
		ArrayList<int[]> taskPool = new ArrayList<int[]>();
		int minTime = 300;
		ArrayList<Integer> minTimeList = getMinTime(taskPool);
		minTime = tasks[minTimeList.get(0)][2];
		Integer Pority = tasks[minTimeList.get(0)][1];
		for (int i = 0; i < tasks.length; i++) {
			if(tasks[i][1] >= Pority)
				taskPool.add(tasks[i]);
		}
		return taskPool;
	}
	
	public static int[] checkMoument(int[][] tasks){
		 int[] timePool = {tasks[0][2],tasks[1][2],tasks[2][2],tasks[3][2],tasks[4][2],};
		 return timePool;
	}
	
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String line = scanner.nextLine();
//		scanner.close();
		String line = "[1.100.20.30]|[2.10.68.3]|[3.40.130.50]|[4.66.50.100]|[5.55.30.70]";
		int [][] tasks = getTasks(line);
		
		int currentTime = 0;
		int[] timePool = checkMoument(tasks);
		ArrayList<int[]> taskPool = gettaskPool(tasks, currentTime);
		ArrayList<Integer> times = getMinTime(taskPool);
		while(currentTime <= 200){
			
		}
	}

}
