package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/">leetcode1072</a>
 */
public class LtCode1072 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 1}
        }));
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{
            {0, 1},
            {1, 0}
        }));
        System.out.println(solution.maxEqualRowsAfterFlips(new int[][]{
            {0, 0, 0},
            {0, 0, 1},
            {1, 1, 0}
        }));
    }

    static class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            matrix = preOptimizer(matrix);
            Map<String, Integer> regular2num = new HashMap<>(matrix.length);
            StringBuilder stringBuilder = new StringBuilder();
            for (int[] row : matrix) {
                for (int cell : row) {
                    stringBuilder.append(cell);
                }
                String key = stringBuilder.toString();
                regular2num.put(key, regular2num.getOrDefault(key, 0) + 1);
                stringBuilder.delete(0, stringBuilder.length());
            }
            return regular2num.values().stream().max(Integer::compareTo).orElse(0);
        }

        private int[][] preOptimizer(int[][] matrix) {
            int[][] matrixOpt = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                boolean flag = matrix[i][0] == 1;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (flag) {
                        matrixOpt[i][j] = 1 - matrix[i][j];
                    } else {
                        matrixOpt[i][j] = matrix[i][j];
                    }
                }
            }
            return matrixOpt;
        }
    }
}
