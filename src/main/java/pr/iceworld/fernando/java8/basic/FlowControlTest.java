package pr.iceworld.fernando.java8.basic;

import java.util.HashMap;
import java.util.Map;

public class FlowControlTest {

    public static void main(String[] args) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Integer key = 5;
        Integer value = key;
        countMap.put(key++, value);
        countMap.put(200, 200);
        int count = 0;
        for (Integer i: countMap.keySet()) {
            for (Integer j: countMap.values()) {
                count++;
                if (i == countMap.get(i)) {
                    break;
                }
            }
        }
        System.out.println("Count = " + count);
    }
}
