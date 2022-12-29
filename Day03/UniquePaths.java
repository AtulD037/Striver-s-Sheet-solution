package Day03;
//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.
//Given the two integers m and n, return the number of possible unique paths that the robot
// can take to reach the bottom-right corner.
public class UniquePaths {
    static int pathFinder(int m,int n){
        int[][] paths = new int[m][n]; // Take a m*n matrix

        // Since we know in left column and top row there is one way possible to travel path therefor fill those with 1
        for (int i = 0; i < m; i++) {
            paths[i][0]=1;
        }for (int j = 0; j < n; j++) {
            paths[0][j]=1;
        }

        // Now in the inner matrix element = prevCol element + prevRow parallel element

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i][j-1]+paths[i-1][j];
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(pathFinder(3,7));
        System.out.println(pathFinder(3,2));
    }
}
