package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/10/14.
 * Desc: https://leetcode-cn.com/problems/move-zeroes/
 */
public class L0283MoveZeros {
    public static void moveZeros(int[] arrs) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] != 0) {
                arrs[lastNonZeroIndex++] = arrs[i];
            }
        }
        for (int i = lastNonZeroIndex; i < arrs.length; i++) {
            arrs[i] = 0;
        }
    }
}
