package programmers;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int l = 0;
        int r = Arrays.stream(budgets).max().getAsInt();

        while (l <= r) {

            int mid = (l + r) / 2;
            int sum = 0;
            for (int budget : budgets) {
                sum += Integer.min(budget, mid);
            }

            if (sum <= M) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}
