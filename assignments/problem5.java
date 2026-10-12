import java.util.*;

public class problem5 {
    static int[] busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int rowTotal = 0;

            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRow = i;
            }
        }

        return new int[]{bestRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = busiestRow(grid);

        System.out.println(
                "Row " + result[0] + ", Total " + result[1]
        );

        sc.close();
    }
}