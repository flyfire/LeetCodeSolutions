package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/10/14.
 * Desc:
 */
public class L0080RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i-2]){
                nums[i++] = num;
            }
        }
        return i;
    }
}
