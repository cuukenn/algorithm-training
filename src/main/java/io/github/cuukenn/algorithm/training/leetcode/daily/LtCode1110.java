package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">leetcode1110</a>
 */
public class LtCode1110 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.delNodes(new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(5)),
            new TreeNode(3, new TreeNode(6), new TreeNode(7))
        ), new int[]{3, 5}));
        System.out.println(solution.delNodes(new TreeNode(
            1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(4)
        ), new int[]{3}));
        System.out.println(solution.delNodes(new TreeNode(
            1,
            new TreeNode(2, new TreeNode(4), new TreeNode(3)),
            null
        ), new int[]{2, 3}));
    }

    static class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
            Set<Integer> toDeleteSet = IntStream.of(toDelete).boxed().collect(Collectors.toSet());
            List<TreeNode> treeNodes = new ArrayList<>();
            preDfs(treeNodes, toDeleteSet, root, null);
            return treeNodes.stream().filter(Objects::nonNull).collect(Collectors.toList());
        }

        private void preDfs(List<TreeNode> treeNodes, Set<Integer> toDeleteSet, TreeNode node, TreeNode preNode) {
            if (node == null) {
                return;
            }
            if (toDeleteSet.remove(node.val)) {
                if (preNode != null) {
                    if (preNode.left != null && preNode.left.val == node.val) {
                        preNode.left = null;
                    } else {
                        preNode.right = null;
                    }
                }
                addTreeNode(treeNodes, toDeleteSet, node.left);
                addTreeNode(treeNodes, toDeleteSet, node.right);
            } else {
                if (preNode == null) {
                    addTreeNode(treeNodes, toDeleteSet, node);
                }
            }
            preDfs(treeNodes, toDeleteSet, node.left, node);
            preDfs(treeNodes, toDeleteSet, node.right, node);
        }

        private void addTreeNode(List<TreeNode> treeNodes, Set<Integer> toDeleteSet, TreeNode newNode) {
            if (newNode == null) {
                return;
            }
            if (!toDeleteSet.contains(newNode.val)) {
                treeNodes.add(newNode);
            }
        }
    }

    static class TreeNode {
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

        @Override
        public String toString() {
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(this);
            List<Integer> values = new ArrayList<>();
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                if (node == null) {
                    continue;
                }
                values.add(node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
            }
            return values.toString();
        }
    }
}
