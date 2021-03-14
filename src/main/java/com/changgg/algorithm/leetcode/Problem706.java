package com.changgg.algorithm.leetcode;

/**
 * @Classname Problem706
 * @Description https://leetcode-cn.com/problems/design-hashmap/
 * @Date 2021/3/14 16:45
 * @Created by changgg
 */
public class Problem706 {
    private static final int SIZE = 64;
    private final Entry[][] entry;

    public Problem706() {
        entry = new Entry[SIZE][SIZE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = (key + "").hashCode() % SIZE;
        resize(hash);
        final Entry[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index].getKey() != key) {
            index++;
        }
        target[index] = new Entry(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hash = (key + "").hashCode() % SIZE;
        final Entry[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index].getKey() != key) {
            index++;
        }
        boolean hasKey = index < target.length && target[index] != null && target[index].getKey() == key;
        return hasKey ? target[index].getValue() : -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = (key + "").hashCode() % SIZE;
        final Entry[] target = entry[hash];
        int index = 0;
        while (index < target.length && target[index] != null && target[index].getKey() != key) {
            index++;
        }
        if (index < target.length) {
            target[index] = null;
        }
        final Entry[] newValues = new Entry[target.length];
        index = 0;
        for (Entry val : target) {
            if (val != null) {
                newValues[index] = val;
                index++;
            }
        }
        entry[hash] = newValues;
    }

    private void resize(int index) {
        final Entry[] hashValues = entry[index];
        if (hashValues[hashValues.length - 1] != null) {
            final Entry[] newValues = new Entry[hashValues.length << 1 + 1];
            System.arraycopy(hashValues, 0, newValues, 0, hashValues.length);
            entry[index] = newValues;
        }
    }

    static class Entry {
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Problem706 myHashMap = new Problem706();
        myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
        myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
        myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
        System.out.println(myHashMap.get(2));    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
        myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
        System.out.println(myHashMap.get(2));    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
    }
}
