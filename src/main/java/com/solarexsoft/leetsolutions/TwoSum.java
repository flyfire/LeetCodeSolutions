package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/7/26.
 */
public class TwoSum {
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

    public static void main(String[] args) {
        int[] sums = {2, 4, 5, 6, 8, 7, 3};
        int target = 9;
        int[] result = twoSum(sums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
