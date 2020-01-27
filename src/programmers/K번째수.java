package programmers;

import java.util.Arrays;

public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int startIndex = commands[i][0] - 1;
            int endIndex = commands[i][1];
            int findIndex = commands[i][2] - 1;

            int[] arr = Arrays.copyOfRange(array, startIndex, endIndex);
            Arrays.sort(arr);

            answer[i] = arr[findIndex];
        }
        return answer;
    }
}
