package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: see: https://leetcode-cn.com/problems/permutations/
 * @author: changgg
 * @create: 2021-02-23 20:12
 **/
public class Problem46 {
  /**
   * f(n)=[nums[index],f(n-index)]
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permute(int[] nums) {
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
      final List<List<Integer>> permute = permute(removeIndex(nums, index));
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
    Problem46 problem46 = new Problem46();
    System.out.println(problem46.permute(new int[]{1, 2, 3}));
  }
}
