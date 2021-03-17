import java.util.Comparator;
import java.util.PriorityQueue;

public class bunniesescape {

    final static int[] dy = new int[]{1, -1, 0, 0}, dx = new int[]{0, 0, 1, -1};
    static int rows, cols;
    static Point[][] grid;
    static int ans = Integer.MAX_VALUE;


    static void reset(){
        for(Point[] row: grid)
            for(Point p: row){
                p.distance = Integer.MAX_VALUE;
                p.visited = false;
            }

    }

    static boolean inBounds(int r, int c){
        return 0<=r && r<rows && 0<=c && c<cols;
    }

    static int shortestPath(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        grid[0][0].distance = 1;
        pq.add(grid[0][0]);
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            for(int i=0; i<4; ++i){
                int toRow = cur.row + dy[i];
                int toCol = cur.col + dx[i];
                if(!inBounds(toRow, toCol)) continue;
                Point neighbor = grid[toRow][toCol];
                if(neighbor.obstacle || neighbor.visited) continue;
                if(cur.distance + 1 < neighbor.distance){
                    neighbor.distance = cur.distance + 1;
                    pq.add(neighbor);
                }
            }
            cur.visited = true;
            if(cur.row == rows-1 && cur.col == cols-1)
                return cur.distance;
        }
        return Integer.MAX_VALUE;
    }

    public static int solution(int[][] map){
        rows = map.length;
        cols = map[0].length;
        boolean obstacle = false;
        grid = new Point[rows][cols];

        for(int i=0; i<rows; ++i)
            for(int j=0; j<cols; ++j) {
                grid[i][j] = new Point(i, j);
                if (map[i][j] == 1) grid[i][j].obstacle = true;
            }

        for(int i=0; i<rows; ++i)
            for(int j=0; j<cols; ++j)
                if(grid[i][j].obstacle){
                    obstacle = true;
                    reset();
                    grid[i][j].obstacle = false;
                    ans = Math.min(ans, shortestPath());
                    grid[i][j].obstacle = true;
                }

        if(!obstacle) return shortestPath();
        else return ans;

    }

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{
                        {0,1,0,0,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,1,0},
                        {0,1,0,1,0,0,0}
                }
        ));
    }

    static class Point implements Comparable<Point> {
        final int row, col;
        boolean visited = false;
        boolean obstacle = false;
        int distance = Integer.MAX_VALUE;

        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.distance, o.distance);
        }
    }


}
