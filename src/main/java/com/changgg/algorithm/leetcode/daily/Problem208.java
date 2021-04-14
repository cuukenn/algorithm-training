package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem208
 * @Description https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @Date 2021/4/14 19:27
 */
public class Problem208 {
    private static class Node {
        private boolean isEnd = false;
        private final Node[] list = new Node[26];

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }

        public Node[] getList() {
            return list;
        }
    }

    private final Node root;

    public Problem208() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node node = this.root;
        for (char c : chars) {
            Node[] nodeList = node.getList();
            if (nodeList[c - 'a'] == null) {
                nodeList[c - 'a'] = new Node();
            }
            node = nodeList[c - 'a'];
        }
        node.setEnd(true);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node node = this.root;
        for (char c : chars) {
            Node[] nodeList = node.getList();
            if (nodeList[c - 'a'] != null) {
                node = nodeList[c - 'a'];
            } else {
                return false;
            }
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = this.root;
        for (char c : chars) {
            Node[] nodeList = node.getList();
            if (nodeList[c - 'a'] != null) {
                node = nodeList[c - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem208 problem208 = new Problem208();
        problem208.insert("apple");
        System.out.println(problem208.search("apple"));   // 返回 True
        System.out.println(problem208.search("app"));     // 返回 False
        System.out.println(problem208.startsWith("app")); // 返回 True
        problem208.insert("app");
        System.out.println(problem208.search("app"));     // 返回 True
    }
}
