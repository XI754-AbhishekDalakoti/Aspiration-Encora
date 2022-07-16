import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    static final int row = 3;
    static final int col = 3;
    static int dim_row[] = {-1, 0, 1, 0};
    static int dim_col[] = {0, 1, 0, -1};

    static class pointCoordinates {
        int firstCoordinate, secondCoordinate,thirdCoordinate;

        public pointCoordinates(int firstCoordinate, int secondCoordinate, int thirdCoordinate) {
            super();
            this.firstCoordinate =firstCoordinate;
            this.secondCoordinate =secondCoordinate;
            this.thirdCoordinate= thirdCoordinate;
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

        Queue<pointCoordinates> pointCoordinates = new LinkedList<pointCoordinates>();
        int[][] distance = new int[row][col];
        int[][] obstacles = new int[row][col];
        pointCoordinates.add(new pointCoordinates(source.first, source.second,k));
        while (!pointCoordinates.isEmpty()) {
            pointCoordinates point = pointCoordinates.peek();
            int firstCoordinate = point.firstCoordinate;
            int secondCoordinate = point.secondCoordinate;
            int thirdCoordinate =  point.thirdCoordinate;
            if (firstCoordinate == destination.first && secondCoordinate == destination.second)
                return distance[firstCoordinate][secondCoordinate];
            pointCoordinates.remove();
            if (matrix[firstCoordinate][secondCoordinate] == 1) {
                if (thirdCoordinate > 0)
                   thirdCoordinate--;
                else
                    continue;
            }
            if (obstacles[firstCoordinate][secondCoordinate] >= thirdCoordinate)
                continue;
            obstacles[firstCoordinate][secondCoordinate] = thirdCoordinate;
            for (int i = 0; i < 4; i++) {
                int firstDimension = firstCoordinate + dim_row[i];
                int secondDimension = secondCoordinate + dim_col[i];
                if (firstDimension < 0 || secondDimension < 0 || firstDimension >= row || secondDimension >= col)
                    continue;
                pointCoordinates.add(new pointCoordinates(firstDimension,secondDimension, thirdCoordinate));
                distance[firstDimension][secondDimension] = distance[firstCoordinate][secondCoordinate] + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int matrix[][] = {{0, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        int noOfPoints = 2;
        pair source = new pair(0, 0);
        pair destination = new pair(2, 2);
        System.out.print(BFS(matrix, noOfPoints, source, destination));
    }
}
