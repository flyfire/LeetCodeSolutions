package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/10/14.
 * Desc:
 */
public class L0026RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
