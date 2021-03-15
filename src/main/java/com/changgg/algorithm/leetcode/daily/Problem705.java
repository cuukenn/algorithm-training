package com.changgg.algorithm.leetcode.daily;

/**
 * @Classname Problem705
 * @Description https://leetcode-cn.com/problems/design-hashset/
 * @Date 2021/3/13 21:07
 * @Created by changgg
 */
public class Problem705 {
    private static final int SIZE = 64;
    private final Integer[][] entry;

    /**
     * Initialize your data structure here.
     */
    public Problem705() {
        entry = new Integer[SIZE][SIZE];
    }

    public void add(int key) {
        int hash = (key + "").hashCode() % SIZE;
        resize(hash);
        final Integer[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index] != key) {
            index++;
        }
        target[index] = key;
    }

    public void remove(int key) {
        int hash = (key + "").hashCode() % SIZE;
        final Integer[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index] != key) {
            index++;
        }
        if(index < target.length){
            target[index] = null;
        }
        final Integer[] newValues = new Integer[target.length];
        index = 0;
        for (Integer val : target) {
            if (val != null) {
                newValues[index] = val;
                index++;
            }
        }
        entry[hash] = newValues;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = (key + "").hashCode() % SIZE;
        final Integer[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index] != key) {
            index++;
        }
        return index < target.length && target[index] != null && target[index] == key;
    }

    private void resize(int index) {
        final Integer[] hashValues = entry[index];
        if (hashValues[hashValues.length - 1] != null) {
            final Integer[] newValues = new Integer[hashValues.length << 1 + 1];
            System.arraycopy(hashValues, 0, newValues, 0, hashValues.length);
            entry[index] = newValues;
        }
    }

    public static void main(String[] args) {
        Problem705 myHashSet = new Problem705();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
    }
}
