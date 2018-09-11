package com.solarexsoft.leetsolutions;

import java.util.HashMap;

/**
 * Created by houruhou on 2018/7/26.
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class L0001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                int tmp = nums[i] + nums[j];
                if (target == tmp) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int size = nums.length;
        HashMap<Integer, Integer> numMaps = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int left = target - nums[i];
            if (numMaps.containsKey(left)) {
                return new int[]{i, numMaps.get(left)};
            }
            numMaps.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 6, 8, 7, 3};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);

        result = twoSum2(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
