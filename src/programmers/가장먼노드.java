package programmers;

import java.util.*;

public class 가장먼노드 {

    public int solution(int n, int[][] edge) {
        int[] results = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] vertex : edge) {
            int firstPoint = vertex[0];
            int secondPoint = vertex[1];

            edges.get(firstPoint).add(secondPoint);
            edges.get(secondPoint).add(firstPoint);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : edges.get(now)) {
                if (!visit[next]) {
                    visit[next] = true;
                    results[next] = results[now] + 1;
                    queue.add(next);
                }
            }
        }
        int max = Arrays.stream(results).max()
                .orElse(1);

        return (int) Arrays.stream(results).filter(result -> result == max)
                .count();
    }
}
