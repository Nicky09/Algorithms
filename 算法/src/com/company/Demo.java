package com.company;
import stdlib.StdOut;
import stdlib.StdRandom;
import tool.diy.point2Dlatest;

public class Demo {
	public static void main(String[] args) {
		point2Dlatest a = new point2Dlatest(500);
		for (int i = 0; i < 500; i++) {
			a.drawpoints(StdRandom.uniform(0, 1.0), StdRandom.uniform(0.0, 1.0), i);
		}
		StdOut.println(a);
	}
}
