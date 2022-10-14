package org.hdu.No1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;

public class No90 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static int[] memo; // memo[1] 表示上一组下标为1的数字
    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 2};
//        No90 no90 = new No90();
//        List<List<Integer>> lists = no90.subsetsWithDup(nums);
//        for (List<Integer> list: lists) {
//            System.out.println(list);
//        }


    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res.add(path);
        memo = new int[nums.length];
        Arrays.fill(memo, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++) {
            backtrace(nums, i + 1, 0);
            System.out.println("size " + (i + 1) + ": "+ path.size());
            Arrays.fill(memo, Integer.MAX_VALUE);

        }
        return res;
    }

    void backtrace(int[] nums, int size, int start) {
        if (path.size() == size) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int curSize = path.size();
            if (nums[i] == memo[curSize]) {continue;}
            memo[curSize] = nums[i];
            path.add(nums[i]);
            backtrace(nums, size, i + 1);
            path.remove(path.size() - 1);
        }
    }
}


