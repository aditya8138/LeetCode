package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore_981 {

    Map<String, HashMap<Integer, String>> timeMap;


    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore_981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> newMap = new HashMap<>();
        newMap.put(timestamp, value);
        timeMap.put(key, newMap);
    }

    public String get(String key, int timestamp) {
        Map<Integer, String> treeMap = new TreeMap<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//sort in descending order
            }
        });
        HashMap<Integer, String> valueMap = timeMap.get(key);

        for (int k : valueMap.keySet()) {
            if (valueMap.containsKey(timestamp)) {
                System.out.println(" timestamp: " + timestamp);
                String res = valueMap.get(timestamp);
                System.out.println(" Result: " + res);
                return res;
            } else {
                timestamp--;
                get(key, timestamp);
            }
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

