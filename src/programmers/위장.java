package programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장 {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (Integer value : map.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }
}
