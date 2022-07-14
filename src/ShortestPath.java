
import java.util.*;

public class ShortestPath {

    static final int row = 3;
    static final int col = 3;
    static int dim_row[] = {-1, 0, 1, 0};
    static int dim_col[] = {0, 1, 0, -1};

    static class pointCoordinates {
        int x, y, z;

        public pointCoordinates(int x, int y, int z) {
            super();
            this.x = x;
            this.y = y;
            this.z = z;
        }
    };

    static class pair {
        int first, second;

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static int BFS(int matrix[][], int k, pair source, pair destination) {

        Queue<pointCoordinates> q = new LinkedList<pointCoordinates>();
        int[][] distance = new int[row][col];
        int[][] obstacles = new int[row][col];
        q.add(new pointCoordinates(source.first, source.second,k));
        while (!q.isEmpty()) {
            pointCoordinates test = q.peek();
            int x = test.x;
            int y = test.y;
            int testCoordinates =  test.z;
            if (x == destination.first && y == destination.second)
                return distance[x][y];
            q.remove();
            if (matrix[x][y] == 1) {
                if (testCoordinates > 0)
                    testCoordinates--;
                else
                    continue;
            }
            if (obstacles[x][y] >= testCoordinates)
                continue;
            obstacles[x][y] = testCoordinates;
            for (int i = 0; i < 4; i++) {
                int ax = x + dim_row[i];
                int ay = y + dim_col[i];
                if (ax < 0 || ay < 0 || ax >= row || ay >= col)
                    continue;
                q.add(new pointCoordinates(ax, ay, testCoordinates));
                distance[ax][ay] = distance[x][y] + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int matrix[][] = {{0, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        int k = 2;
        pair source = new pair(0, 0);
        pair destination = new pair(2, 2);
        System.out.print(BFS(matrix, k, source, destination));
    }
}
