package com.changgg.algorithm.leetcode.weekly.single;

import java.util.*;

/**
 * @author changgg
 * @Classname Problem5716
 * @Description https://leetcode-cn.com/contest/weekly-contest-234/problems/maximize-number-of-nice-divisors/
 * @Date 2021/3/28 11:07
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5716 {
    //TODO 未完成
    public int maxNiceDivisors(int primeFactors) {
        int num = 0;
        Set<Integer> rs = new HashSet<>();
        while (true) {
            num++;
            List<List<Integer>> num1 = getNum1(num);
            if (!num1.isEmpty()) {
                List<Integer> num2 = getNum2(num1.get(0));
                if (num2.size() == primeFactors) {
                    for (List<Integer> nv : num1) {
                        int tmp1 = nv.get(0);
                        boolean tmp1Can = true;
                        for (Integer v : num2) {
                            if ((tmp1 / v) * v == tmp1) {
                                tmp1Can = false;
                                break;
                            }
                        }
                        if (tmp1Can) {
                            rs.add(tmp1);
                        }
                        tmp1 = nv.get(1);
                        tmp1Can = true;
                        for (Integer v : num2) {
                            if ((tmp1 / v) * v == tmp1) {
                                tmp1Can = false;
                                break;
                            }
                        }
                        if (tmp1Can) {
                            rs.add(tmp1);
                        }
                    }
                    break;
                }
            }
        }
        return rs.size();
    }

    private List<List<Integer>> getNum1(int num) {
        final int mid = num >> 1;
        List<List<Integer>> rs = new ArrayList<>();
        for (int index = 2; index <= num; index++) {
            int tmp = num / index;
            if (tmp < index) {
                break;
            }
            if (tmp * index == num) {
                rs.add(Arrays.asList(index, tmp));
            }
        }
        return rs;
    }

    private List<Integer> getNum2(List<Integer> num1) {
        int v1 = num1.get(0);
        List<Integer> rs = new ArrayList<>();
        if (v1 % 2 == 0 || v1 % 3 == 0 || v1 % 5 == 0 || v1 % 7 == 0) {
            List<List<Integer>> num11 = getNum1(v1);
            if (num11.size() > 0) {
                rs.addAll(getNum2(num11.get(0)));
            } else {
                rs.add(v1);
            }
        } else {
            rs.add(v1);
        }
        int v2 = num1.get(1);
        if (v2 % 2 == 0 || v2 % 3 == 0 || v2 % 5 == 0 || v2 % 7 == 0) {
            List<List<Integer>> num11 = getNum1(v2);
            if (num11.size() > 0) {
                rs.addAll(getNum2(num11.get(0)));
            } else {
                rs.add(v2);
            }
        } else {
            rs.add(v2);
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem5716 problem5716 = new Problem5716();
        System.out.println(problem5716.maxNiceDivisors(5));
        System.out.println(problem5716.maxNiceDivisors(8));

        System.out.println(problem5716.getNum1(12));
        System.out.println(problem5716.getNum2(problem5716.getNum1(12).get(0)));
    }
}
