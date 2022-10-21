package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author changgg
 * @Classname Problem173
 * @Description https://leetcode-cn.com/problems/binary-search-tree-iterator/submissions/
 * @Date 2021/3/28 14:23
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem173 {
    public static void main(String[] args) {
    }

    class BSTIterator {
        private Iterator<Integer> iterator;

        public BSTIterator(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            this.midSearch(root, list);
            this.iterator = list.iterator();
        }

        private void midSearch(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            midSearch(root.left, list);
            list.add(root.val);
            midSearch(root.right, list);
        }

        public int next() {
            return iterator.next();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
