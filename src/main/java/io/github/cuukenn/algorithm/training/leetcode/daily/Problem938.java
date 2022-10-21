package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem938
 * @Description https://leetcode-cn.com/problems/range-sum-of-bst/
 * @Date 2021/4/27 23:18
 */
public class Problem938 {
    private int rs = 0;

    public int rangeSumBST(Problem173.TreeNode root, int low, int high) {
        this.dsf(root, low, high);
        return rs;
    }

    private void dsf(Problem173.TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        dsf(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            rs += root.val;
        }
        dsf(root.right, low, high);
    }

    public static void main(String[] args) {
        Problem938 problem938 = new Problem938();
    }
}
