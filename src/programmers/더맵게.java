package programmers;

import java.util.PriorityQueue;

public class 더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int sco : scoville) {
            pq.add(sco);
        }

        while (!pq.isEmpty() && pq.peek() < K) {
            answer++;
            int smallest = pq.poll();
            if (pq.isEmpty()) {
                answer = -1;
                break;
            }
            int secSmallest = pq.poll();

            int mixed = smallest + (secSmallest * 2);
            pq.add(mixed);
        }
        return answer;
    }
}
