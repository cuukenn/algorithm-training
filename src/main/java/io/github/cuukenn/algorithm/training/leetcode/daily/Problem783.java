package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem783
 * @Description https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/submissions/
 * @Date 2021/4/13 19:53
 */
public class Problem783 {
    private int result;
    private int pre;

    public int minDiffInBST(Problem173.TreeNode root) {
        this.result = Integer.MAX_VALUE;
        this.pre = -1;
        this.minDiffInBSTP(root);
        return this.result;
    }

    public void minDiffInBSTP(Problem173.TreeNode root) {
        if (root == null) {
            return;
        }
        minDiffInBSTP(root.left);
        if (this.pre < 0) {
            this.pre = root.val;
        } else {
            this.result = Math.min(this.result, root.val - this.pre);
            this.pre = root.val;
        }
        minDiffInBSTP(root.right);
    }

    public static void main(String[] args) {
        Problem783 problem783 = new Problem783();
        Problem173.TreeNode root = new Problem173.TreeNode(4);
        Problem173.TreeNode n1 = new Problem173.TreeNode(2);
        Problem173.TreeNode n2 = new Problem173.TreeNode(6);
        Problem173.TreeNode n3 = new Problem173.TreeNode(1);
        Problem173.TreeNode n4 = new Problem173.TreeNode(3);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        System.out.println(problem783.minDiffInBST(root));
    }
}
