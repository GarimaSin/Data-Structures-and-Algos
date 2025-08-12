package Problem_Solving.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
	
	HashMap<String, TreeMap<Integer, String>> map;
    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            Integer idx = map.get(key).floorKey(timestamp);
            if(idx != null) {
                return map.get(key).get(idx);
            }
        }
        return "";
    }
}

//Binary Search Sol
class TimeMap {
    class TimeValue{
        int time;
        String value;
        public TimeValue(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<TimeValue>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        List<TimeValue> list = map.get(key);
        list.add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) 
        	return "";
        
        List<TimeValue> list = map.get(key);
        int left = 0, right = list.size() - 1;
        
        while(left + 1 < right){
            int mid = (left + right) / 2;
            TimeValue midTimeValue = list.get(mid);
            if(midTimeValue.time == timestamp) {
                return midTimeValue.value;
            } else if(midTimeValue.time < timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if(list.get(right).time <= timestamp) {
            return list.get(right).value;
        } else if(list.get(left).time <= timestamp) {
            return list.get(left).value;
        } else {
            return "";
        }
    }
}