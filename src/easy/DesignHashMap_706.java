/*Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.*/

public class DesignHashMap_706 {

    ListNode[] node;

    public DesignHashMap_706() {
        node = new ListNode[10000];
    }

    public static void main(String[] args) {
        DesignHashMap_706 hashMap = new DesignHashMap_706();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.put(2, 3);
        hashMap.put(3, 3);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));             // returns -1 (not found)
        System.out.println(hashMap.get(2));             // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2)); // return -1
    }

    private int findIndex(int key) {
        return Integer.hashCode(key) % node.length;
    }

    public int get(int key) {
        int index = findIndex(key);
        ListNode prev = findValue(index, key);
        return prev.next == null ? -1 : prev.next.val;
    }

    public void put(int key, int value) {
        int index = findIndex(key);
        ListNode prev = findValue(index, key);

        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public void remove(int key) {
        int index = findIndex(key);
        ListNode prev = findValue(index, key);

        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    private ListNode findValue(int index, int key) {
        if (node[index] == null) {
            node[index] = new ListNode(-1, -1);
        }

        ListNode prev = node[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }

    private class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int k, int v) {
            key = k;
            val = v;
        }
    }
}
