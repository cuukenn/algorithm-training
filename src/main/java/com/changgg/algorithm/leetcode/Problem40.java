package com.changgg.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: see: https://leetcode-cn.com/problems/combination-sum-ii/
 * @author: changgg
 * @create: 2021-02-21 18:27
 **/
public class Problem40 {
  /**
   * f(target)=candidates[index]+f(target-candidates[index])
   *
   * @param candidates 数据
   * @param target     目标
   * @return 结果
   */
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    final List<List<Integer>> result = new ArrayList<>();
    dsf(result, new ArrayList<>(), target, 0, candidates);
    return result;
  }

  private void dsf(List<List<Integer>> result, List<Integer> path,
                   int currentTarget, int currentIndex, int[] candidates) {
    if (currentTarget == 0) {
      if (!path.isEmpty()) {
        result.add(new ArrayList<>(path));
      }
      return;
    }
    for (int index = currentIndex; index < candidates.length; index++) {
      if (candidates[index] <= currentTarget) {
        //去除重复数据
        if (index > currentIndex && candidates[index] == candidates[index - 1]) {
          continue;
        }
        path.add(candidates[index]);
        dsf(result, path, currentTarget - candidates[index], index + 1, candidates);
        path.remove(path.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    final Problem40 problem40 = new Problem40();
    System.out.println(problem40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 4));
    System.out.println(problem40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println(problem40.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
  }
}
