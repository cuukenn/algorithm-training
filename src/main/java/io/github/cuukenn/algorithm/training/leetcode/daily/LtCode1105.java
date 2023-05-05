package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/filling-bookcase-shelves/">leetcode1105</a>
 */
public class LtCode1105 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
    }

    static class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            return minHeightShelves(books, books.length, shelfWidth);
        }

        private int minHeightShelves(int[][] books, int length, int shelfWidth) {
            return 0;
        }
    }
}
