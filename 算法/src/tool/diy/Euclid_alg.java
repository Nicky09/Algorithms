package tool.diy;

import stdlib.StdOut;

/**
 * Created by gate on 2015/6/27.
 * 欧几里得算法 求最大公约数
 */
public class Euclid_alg {
	/**
	 * 全局变量Deep记录算法深度
	 */
	public static int Deep = 0;
	// test
	public static void main(String[] args){
		StdOut.println(gcd(1111111,1234567));
	}

	/**
	 * 算法本体
	 * 欧几里得算法：计算两个非负整数的最大公约数：若q是0，则最大公约数为p。
	 * 否则，将p除以q得到余数r，p和q的最大公约数即为q和r的最大公约数。
	 * @param p 非负整数
	 * @param q 同上
	 * @return  递归
	 *          递归完成求出最大公约数
	 */
	public static int gcd(int p,int q){
		Deep++;
		if (q==0) return p;
		int r = p % q;
		return gcd(q,r);
	}

}
