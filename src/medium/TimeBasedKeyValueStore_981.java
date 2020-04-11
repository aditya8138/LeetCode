import java.util.*;

public class TimeBasedKeyValueStore_981 {

    Map<String, List<MapObj>> map;

    /**
     * Initialize your data structure here.
     */
    public TimeBasedKeyValueStore_981() {
        map = new HashMap<String, List<MapObj>>();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore_981 timeMap = new TimeBasedKeyValueStore_981();
        timeMap.set("foo", "bar", 1);
        timeMap.get("foo", 1);
        timeMap.get("foo", 3);
        timeMap.set("foo", "bar2", 4);
        timeMap.get("foo", 4);
        timeMap.get("foo", 5);
        timeMap.get("foo", 2);
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<MapObj>());
        }
        map.get(key).add(new MapObj(value, timestamp));
    }

    public void get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            System.out.println("");
        }
        List<MapObj> objList = map.get(key);
        System.out.println(binarySearch(objList, timestamp));
    }

    private String binarySearch(List<MapObj> list, int time) {
        int low = 0, high = list.size() - 1;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (list.get(mid).time == time) {
                return list.get(mid).val;
            }
            if (list.get(mid).time < time) {
                if (list.get(mid + 1).time > time) {
                    return list.get(mid).val;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return list.get(low).time <= time ? list.get(low).val : "";
    }

    public class MapObj {
        String val;
        int time;

        public MapObj(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

