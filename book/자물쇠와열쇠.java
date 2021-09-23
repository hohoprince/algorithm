class Solution {
    
    public int[][] rotate90(int[][] key) {

        int n = key.length;
        int m = key[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][n - i - 1] = key[i][j];
            }
        }

        return result;
    }

    public boolean check(int[][] tmp, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i + n - 1][j + m - 1] != 1) return false;
            }
        }

        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = key[0].length;

        int[][] tmp = new int[3 * n - 2][3 * m - 2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i + n - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            key = rotate90(key);

            for (int i = 0; i <= tmp.length - n; i++) {
                for (int j = 0; j <= tmp[0].length - m; j++) {

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            tmp[x + i][y + j] += key[x][y];
                        }
                    }

                    if (check(tmp, n, m)) {
                        return true;
                    }

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < m; y++) {
                            tmp[x + i][y + j] -= key[x][y];
                        }
                    }

                }
            }
        }
        return false;
    }
}
