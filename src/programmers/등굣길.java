package programmers;

public class 등굣길 {

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        map[1][1] = 1;
        for (int[] puddle : puddles) {
            int x = puddle[1];
            int y = puddle[0];
            map[x][y] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                if (map[i - 1][j] != -1) {
                    map[i][j] += map[i - 1][j];
                }
                if (map[i][j - 1] != -1) {
                    map[i][j] += map[i][j - 1];
                }
                map[i][j] %= 1000000007;
            }
        }
        return map[n][m];
    }
}
