package com.changgg.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: algorithm
 * @description: see:https://leetcode-cn.com/problems/group-anagrams/
 * @author: changgg
 * @create: 2021-02-25 19:34
 **/
public class Problem49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    int index = 0;
    final String[] ss = new String[strs.length];
    final String[] clone = strs.clone();
    for (String s : clone) {
      ss[index] = sort(s) + '-' + index;
      index++;
    }
    Arrays.sort(ss, Comparator.comparingInt(String::length));
    Arrays.sort(ss);
    List<List<String>> rs = new ArrayList<>();

    final String[] strings = new String[ss.length];
    final int[] indexes = new int[ss.length];
    index = 0;
    for (String s : ss) {
      final int splitIndex = s.lastIndexOf('-');
      strings[index] = s.substring(0, splitIndex);
      indexes[index] = Integer.parseInt(s.substring(splitIndex + 1));
      index++;
    }
    int start = 0, end = 0;
    while (start < strings.length && end < strings.length) {
      if ((end + 1) < strings.length && strings[end].equals(strings[end + 1])) {
        end++;
      } else {
        List<String> tmp = new ArrayList<>();
        for (int j = start; j <= end; j++) {
          tmp.add(strs[indexes[j]]);
        }
        rs.add(tmp);
        end++;
        start = end;
      }
    }
    return rs;
  }

  private String sort(String s) {
    final char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public static void main(String[] args) {
    Problem49 problem49 = new Problem49();
//    System.out.println(problem49.groupAnagrams(new String[]{"eat"}));
//    System.out.println(problem49.groupAnagrams(new String[]{"eat", ""}));
//    System.out.println(problem49.groupAnagrams(new String[]{"eat", "tea"}));
//    System.out.println(problem49.groupAnagrams(new String[]{"ape", "and", "cat"}));
//    System.out.println(problem49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(problem49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat", "ac", "bd", "aac", "bbd", "aacc", "bbdd", "acc", "bdd"}));
  }
}
