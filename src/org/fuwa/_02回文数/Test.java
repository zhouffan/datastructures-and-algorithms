package org.fuwa._02回文数;

/**
 * @Author: 进击的烧年.
 * @Date: 2020/12/27 23:05
 * @Description:
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Test {
    /**
     * 考虑奇数位 和 偶数位
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x != 0 && x % 10 == 0){
            return false;
        }
        //12344321 1234321
        //1234432 -> 1
        //123443 -> 12
        //12344 -> 123
        //1234 -> 1234

        //123432 -> 1
        //12343 -> 12
        //1234 -> 123
        //123 -> 1234   1234 / 10 = 123
        int y = 0;
        while (x > y){
            y = y * 10 + x % 10;
            //x 一直减小
            x = x / 10;
        }
        if(x == y){
            return true;
        }
        if(y / 10 == x){
            return true;
        }
        return false;
    }

    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }
}
