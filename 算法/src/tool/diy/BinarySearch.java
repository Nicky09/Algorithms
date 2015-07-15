package tool.diy;

import stdlib.StdOut;
import stdlib.StdRandom;

import java.util.Arrays;

/**
 *  Created by gate on 2015/6/27.
 *  功能：初始化数组，数组处理（排序+删重）。二分法查找，并且记录递归深度
 */
public class BinarySearch {
	/**
	 * 定义全局变量，任何方法都可以访问
	 */
	public static int deep = 0;
//	public static int cnt = 0;
	// test
	public static void main(String[] args) {
		// write your code here
		int[] a = new int[20];
		a = rdm(a,20);
		int loc = rank(7,a);
		for(int i =0;i<a.length;i++){
			StdOut.println(a[i]);
		}
		for(int j =0;j<del(a).length;j++){
			StdOut.println(del(a)[j]);
		}
		StdOut.println("索引为"+loc);
		StdOut.println("深度为"+deep);
	}

	/**
	 *  引导二分法
	 * @param key 查找的值
	 * @param a   在此数组中查找（已排序）
	 * @return    重载方法
	 */
	public static int rank(int key,int[] a){
		return rank(key,a,0,a.length-1);
	}

	/**
	 *  二分法算法本体
	 * @param key 参见rank(未重载)
	 * @param a   如上
	 * @param lo  查找区间的最小值
	 * @param hi  查找区间的最大值
	 * @return    未完成继续递归查找
	 *            查找完成返回索引
	 */
	public static int rank(int key,int[] a,int lo,int hi){
		/**
		 * 此处引用全局变量，记录递归深度
		 */
		deep++;
		if (lo>hi) return -1;
		int mid = lo + (hi-lo)/2;
		if (key<a[mid]) return rank(key,a,lo,mid-1);
		else if (key>a[mid]) return rank(key,a,mid+1,hi);
		else return mid;
	}

	/**
	 *  初始化数组并且排序 引用了Array.sort进行排序
	 * @param a 待处理数组
	 * @param N 数组内值的范围  0~N
	 * @return 返回初始化过后的数组
	 * */

 	public static int[] rdm(int[] a,int N){
		for (int i = 0;i<a.length;i++){
			a[i]= StdRandom.uniform(N);
		}
		Arrays.sort(a);
		return a;
	}

	/**
	 *  计算数组内的重复元素
	 * @param a 待处理数组
	 * @return 重复量
	 */
	public static int cnt(int[] a){
		int cnt =0;
		/**
		 * 【i=1】与【（i-1）==a[i]】是防止出现超出索引范围
		 */
		for(int i =1;i<a.length;i++){
			if (a[i-1]==a[i]){cnt++;}
		}
		return cnt;
	}

	/**
	 *  删重
	 * @param a 待处理数组
	 * @return 处理完毕的数组
	 */
	public static int[] del(int[] a){
		/**
		 * 只是用来计数，无其他作用
		 */
		int cnt = 0;
		int[] b = new int[a.length-cnt(a)-1];
		/**
		 * 删重算法本体
		 * 注意 【a[i-1]=a[i]】与 【int i=1】 都是为了不超出索引范围
		 */
		for (int i =1,j=0;i<a.length;i++){
			if(a[i-1]==a[i]) cnt++;
			else {b[j]=a[i];j++;}
		}
		return b;
	}

}

