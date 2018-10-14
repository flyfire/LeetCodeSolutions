package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/10/14.
 * Desc:
 */
public class L0027RemoveElements {
    public int removeElement(int[] nums, int val) {
        int lastNotEqualValIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastNotEqualValIndex++] = nums[i];
            }
        }
        return lastNotEqualValIndex;
    }

    public int removeElements(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
