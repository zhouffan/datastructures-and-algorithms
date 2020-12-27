package org.fuwa._01两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 进击的烧年.
 * @Date: 2020/12/27 22:33
 * @Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Test {
    /**
     * 时间复杂度：O(N^2)，其中 N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     *
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 方法一时间复杂度高： 原因是寻找 target - x 的时间复杂度过高
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> saveNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            boolean b = saveNums.containsKey(target - nums[i]);
            if(b){
                int j = saveNums.get(target - nums[i]);
                return new int[]{i, j};
            }
            saveNums.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 15, 7};
        int target = 9;
        int[] ints = twoSum2(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }
}

