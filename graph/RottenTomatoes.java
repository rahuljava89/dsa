package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenTomatoes {

    public static void main(String[] args) {
        int[][] mat = { { 0, 1, 2 },
                { 0, 1, 2 },
                { 2, 1, 1 } };
        System.out.println("time " + orangesRotting(mat));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int xAxis = 0; xAxis < grid.length; xAxis++) {
            for (int yAxis = 0; yAxis < grid[0].length; yAxis++) {
                if (grid[xAxis][yAxis] == 2) {
                    System.out.println("xAixs : " + xAxis + " yAxis : " + yAxis);
                    queue.add(new int[] { xAxis, yAxis });
                }
            }
        }
      
        int timeElapsed = 0;

        while (!queue.isEmpty()) {
            timeElapsed++;
            System.out.println("Size : " + queue.size());
           print(grid);
            int currentSize  = queue.size();
            for (int i = 0; i < currentSize; i++) {
                int[] node = queue.poll();
                // upword
                int currentX = node[0];
                int currentY = node[1];
                if (isWithinMatrix(currentX - 1, currentY, grid.length, grid[0].length)
                        && grid[currentX - 1][currentY] == 1) {
                    grid[currentX - 1][currentY] = 2;
                    queue.add(new int[] { currentX - 1, currentY });
                }
                // downward
                if (isWithinMatrix(currentX + 1, currentY, grid.length, grid[0].length)
                        && grid[currentX + 1][currentY] == 1) {
                    grid[currentX + 1][currentY] = 2;
                    queue.add(new int[] { currentX + 1, currentY });
                }
                // left
                if (isWithinMatrix(currentX, currentY - 1, grid.length, grid[0].length)
                        && grid[currentX][currentY - 1] == 1) {
                    grid[currentX][currentY - 1] = 2;
                    queue.add(new int[] { currentX, currentY - 1 });
                }
                // right
                if (isWithinMatrix(currentX, currentY + 1, grid.length, grid[0].length)
                        && grid[currentX][currentY + 1] == 1) {
                    grid[currentX][currentY + 1] = 2;
                    queue.add(new int[] { currentX, currentY + 1 });
                }
            }
        }
        
        System.out.println("timeElapsed : " + timeElapsed);
        for (int xAxis = 0; xAxis < grid.length; xAxis++) {
            for (int yAxis = 0; yAxis < grid[0].length; yAxis++) {
                if (grid[xAxis][yAxis] == 1) {
                    return -1;
                }
            }
        }

        return Math.max(0, timeElapsed - 1);
    }

    public static boolean isWithinMatrix(int x, int y, int xAxisLength, int yAxisLength) {
        if (x >= 0 && x < xAxisLength && y >= 0 && y < yAxisLength) {
            return true;
        }
        return false;
    }

    public static void print(int[][] grid){
        for (int xAxis = 0; xAxis < grid.length; xAxis++) {
            for (int yAxis = 0; yAxis < grid[0].length; yAxis++) {
               System.out.print(grid[xAxis][yAxis]);
            }
            System.out.println("");
        }
    }

}
