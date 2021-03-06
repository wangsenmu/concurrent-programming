package leetcode.easy;

/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrtx {

    public static void main(String[] args) {
        int x = new Sqrtx().mySqrt(8);
    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;

        while (ans == -1) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid == x) {
                ans = mid;
                return ans;
            } else if (mid * mid > x) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }


}
