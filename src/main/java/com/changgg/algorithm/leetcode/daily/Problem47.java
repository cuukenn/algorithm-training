package com.changgg.algorithm.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: see:https://leetcode-cn.com/problems/permutations-ii/
 * @author: changgg
 * @create: 2021-02-24 19:07
 **/
public class Problem47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    if (nums.length <= 0) {
      return new ArrayList<>();
    }
    if (nums.length == 1) {
      List<Integer> rs = new ArrayList<>();
      rs.add(nums[0]);
      return new ArrayList<List<Integer>>() {{
        add(rs);
      }};
    }
    final List<List<Integer>> result = new ArrayList<>();
    for (int index = 0; index < nums.length; index++) {
      if (index > 0 && nums[index] == nums[index - 1]) {
        continue;
      }
      final List<List<Integer>> permute = permuteUnique(removeIndex(nums, index));
      for (List<Integer> list : permute) {
        list.add(nums[index]);
        result.add(list);
      }
    }
    return result;
  }

  private int[] removeIndex(int[] nums, int rmIndex) {
    int[] rs = new int[nums.length - 1];
    int ix = 0;
    for (int index = 0; index < nums.length; index++) {
      if (index == rmIndex) {
        continue;
      }
      rs[ix++] = nums[index];
    }
    return rs;
  }

  public static void main(String[] args) {
    Problem47 problem47 = new Problem47();
    System.out.println(problem47.permuteUnique(new int[]{1, 1, 2}));
    System.out.println(problem47.permuteUnique(new int[]{1, 2, 3}));
  }
}
