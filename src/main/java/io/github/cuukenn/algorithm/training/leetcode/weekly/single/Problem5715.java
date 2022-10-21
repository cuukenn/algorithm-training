package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem5715
 * @Description https://leetcode-cn.com/contest/weekly-contest-234/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * @Date 2021/3/28 10:39
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5715 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        StringBuilder tmp1 = new StringBuilder();
        for (int index = 0; index < n; index++) {
            perm[index] = index;
            tmp1.append(index);
        }
        final String old = tmp1.toString();
        int rs = 0;
        while (true) {
            StringBuilder tmp2 = new StringBuilder();
            int[] array = new int[n];
            for (int index = 0; index < n; index++) {
                if (index % 2 == 0) {
                    array[index] = perm[index >> 1];
                } else {
                    array[index] = perm[(n >> 1) + ((index - 1) >> 1)];
                }
                tmp2.append(array[index]);
            }
            rs++;
            if (tmp2.toString().equals(old)) {
                break;
            }
            perm = array;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem5715 problem5715 = new Problem5715();
        System.out.println(problem5715.reinitializePermutation(2));
        System.out.println(problem5715.reinitializePermutation(4));
        System.out.println(problem5715.reinitializePermutation(6));

    }
}
