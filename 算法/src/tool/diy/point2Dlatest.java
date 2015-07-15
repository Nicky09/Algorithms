package tool.diy;

import stdlib.StdDraw;
import stdlib.StdOut;
import stdlib.StdRandom;

/**
 * Created by gate on 2015/7/9.
 * *********************************************************************************
 * * API    public class  point2Dlatest
 * *                      point2Dlatest(int N)
 * *               void   drawpoints(double val1,double val2,N)         添加点
 * *               double distance(double[] point1,double[] point2)    两点间距离
 * *               void   mean()                                     所有距离比较出最小值
 * *               string toString()                                 对象的字符串表示
 * *********************************************************************************
 */
public class point2Dlatest {
	private double min = 1;       // 初始化最小值并赋值
	private double[][] point;     // 初始化点

	public point2Dlatest(int N) {
		point = new double[N][1];
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		StdDraw.setPenRadius(.005);
	}

	public void drawpoints(double val1, double val2, int N) {
		double[] a = {val1, val2};
		point[N] = a;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(val1, val2);
	}

	public double distance(double[] point1, double[] point2) {
		double dis;
		dis = Math.sqrt(Math.pow((point1[0] - point2[0]), 2) + Math.pow((point1[1] - point2[1]), 2));
		return dis;
	}

	public void mean() {
		for (int i = 0; i < point.length - 1; i++) {
			double a = distance(point[i], point[i + 1]);
			if (a < min) min = a;
			for (int j = i + 2; j < point.length; j++) {
				double b = distance(point[i], point[j]);
				if (a < b && a < min) min = a;
				else if (b < a && b < min) min = b;
			}
		}
	}

	public String toString() {
		mean();
		return "mean:" + String.format("%7.5f", min);
	}

	//	测试用例
	public static void main(String[] args) {
		point2Dlatest a = new point2Dlatest(500);
		for (int i = 0; i < 500; i++) {
			a.drawpoints(StdRandom.uniform(0, 1.0), StdRandom.uniform(0.0, 1.0), i);
		}
		StdOut.println(a);
	}
}
