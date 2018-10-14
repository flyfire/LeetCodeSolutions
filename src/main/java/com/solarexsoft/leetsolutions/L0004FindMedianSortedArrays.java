package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/10/14.
 * Desc:
 */
public class L0004FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            // to ensure m <= n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m+n+1)/2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if (i< iMax && B[j-1] > A[i]) {
                iMin = i+1;
            } else if (i > iMin && A[i-1] > B[j]) {
                iMax = i-1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1];
                } else if (j == 0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                return (maxLeft + minRight) /2.0f;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArraysCorrect(int[] nums1, int[] nums2) {
        double mid = 0;  double pre = 0;  int idx1 = 0;  int idx2 = 0; //line 1

        if(nums1.length == 0 && nums2.length == 1) return nums2[0]; //line 2
        if(nums2.length == 0 && nums1.length == 1) return nums1[0]; //line 3

        for(int i = 0; i<(nums1.length + nums2.length + 3)/2; i++){ //line 4
            pre = mid; //line 5
            if(idx1 == nums1.length) mid = nums2[idx2++]; //line 6
            else if(idx2 == nums2.length) mid = nums1[idx1++]; //line 7
            else if(nums1[idx1] <= nums2[idx2]) mid = nums1[idx1++]; //line 8
            else if(nums1[idx1] > nums2[idx2]) mid = nums2[idx2++]; //line 9
        }
        return (nums1.length + nums2.length)%2 == 1? pre : (pre + mid)/2; //line 10
    }
}
