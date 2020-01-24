package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participants = new HashMap<>();

        for (String partied : participant) {
            participants.put(partied, participants.getOrDefault(partied,0) +1 );
        }
        for (String completed : completion) {
            participants.put(completed, participants.get(completed)-1);
        }
        for(String part : participant) {
            if(participants.get(part) != 0) {
                return part;
            }
        }
        return null;
    }
}

