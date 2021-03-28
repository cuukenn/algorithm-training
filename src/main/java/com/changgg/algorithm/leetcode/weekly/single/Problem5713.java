package com.changgg.algorithm.leetcode.weekly.single;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author changgg
 * @Classname Problem5713
 * @Description https://leetcode-cn.com/contest/weekly-contest-234/problems/number-of-different-integers-in-a-string/
 * @Date 2021/3/28 10:30
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5713 {
    public int numDifferentIntegers(String word) {
        String[] split = word.split("\\D+");
        Set<BigInteger> set = new HashSet<>();
        for (String s : split) {
            if (!s.isEmpty()) {
                set.add(new BigInteger(s));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Problem5713 problem5713 = new Problem5713();
//        System.out.println(problem5713.numDifferentIntegers("a123bc34d8ef34"));
//        System.out.println(problem5713.numDifferentIntegers("leet1234code234"));
//        System.out.println(problem5713.numDifferentIntegers("a1b01c001"));
        System.out.println(problem5713.numDifferentIntegers("167278959591294"));
    }
}
