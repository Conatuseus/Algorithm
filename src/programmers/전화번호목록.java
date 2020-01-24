package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparing(String::length));
        Set<String> phones = new HashSet<>();

        for (String phone : phone_book) {
            for (int i = 1; i <= phone.length(); i++) {
                String now = phone.substring(0, i);
                if (phones.contains(now)) {
                    answer = false;
                    break;
                }
            }
            if (!answer) {
                break;
            }
            phones.add(phone);
        }
        return answer;
    }
}
