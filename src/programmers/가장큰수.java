package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 가장큰수 {

    public String solution(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        Arrays.stream(numbers).forEach(list::add);

        list.sort((a, b) -> {
            String aString = String.valueOf(a);
            String bString = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(aString + bString), Integer.parseInt(bString + aString));
        });

        list.forEach(stringBuilder::append);
        String result = stringBuilder.toString();

        return result.charAt(0) == '0' ? "0" : result;
    }
}

