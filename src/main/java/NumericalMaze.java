import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class NumericalMaze {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    static int ROW;
    static int COL;


    public static void main(String[] args) throws IOException {
        int numCases = readInt();
        for (int i = 0; i < numCases; i++) {
            readLine();
            ROW = readInt();
            COL = readInt();
            int[][] maze = new int[ROW][COL];
            populateMaze(maze);
            PriorityQueue<int[]> res = new PriorityQueue<>(NumericalMaze::compare);
            for (int j = 0; j < COL; j++) {
                if (maze[0][j] == 1) {
                    dfs(maze, res, 0, j, 1, 0, j);
                }
            }
            int[] ans = res.peek();
            System.out.println(1 + " " + (ans[0] + 1));
            System.out.println(ROW + " " + (ans[1] + 1));
            if (i != numCases - 1) System.out.println();
        }
    }

    public static int compare(int[] arr, int[] brr) {
        for (int i = 0; i < arr.length && i < brr.length; i++) {
            if (arr[i] > brr[i]) return 1;
            if (arr[i] < brr[i]) return -1;
        }
        return 0;
    }

    public static void dfs(int[][] maze, PriorityQueue<int[]> res, int row, int col, int goal, int last, int scol) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL) return;
        int curr = maze[row][col];
        boolean condition = curr == last + 1;
        boolean flag = false;
        if (curr == goal) {
            flag = true;
            goal++;
            curr = 0;
        }
        if (condition) {
            maze[row][col] = -1;
            dfs(maze, res, row + 1, col, goal, curr, scol);
            dfs(maze, res, row - 1, col, goal, curr, scol);
            dfs(maze, res, row, col + 1, goal, curr, scol);
            dfs(maze, res, row, col - 1, goal, curr, scol);
            maze[row][col] = curr;
            if (row == ROW - 1 && flag) {
                res.add(new int[]{scol, col});
            }
        }
    }

    static void populateMaze(int[][] maze) throws IOException {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                maze[i][j] = readInt();
            }
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return parseInt(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

}
