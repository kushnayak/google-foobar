import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class challenge2 {

    final static int maxN = 8;
    static int startRow, startCol, endRow, endCol;
    final static int[] dy = {2,2,-2,-2,1,1,-1,-1}, dx = {1,-1,1,-1,2,-2,2,-2};
    static int[][] dist = new int[maxN][maxN];

    public static boolean inBounds(int r, int c){
        return 0<=r && r<maxN && 0<=c && c<maxN;
    }

    public static ArrayList<pos> neighbors(pos p){
        ArrayList<pos> neighbor = new ArrayList<>();
        for(int i=0; i<8; ++i) {
            int tor = p.r + dy[i], toc = p.c + dx[i];
            if (inBounds(tor, toc))
                neighbor.add(new pos(tor,toc));
        }
        return neighbor;
    }
    public static void bfs(){
        for(int[] row: dist) Arrays.fill(row, -1);
        Queue<pos> q = new LinkedList<>();
        q.add(new pos(startRow, startCol));
        dist[startRow][startCol] = 0;
        while(!q.isEmpty()){
            pos cur = q.poll();
            if(cur.r == endRow && cur.c == endCol) break;
            for(pos p: neighbors(cur)){
                if(dist[p.r][p.c]==-1){
                    dist[p.r][p.c] = dist[cur.r][cur.c]+1;
                    q.add(p);
                }
            }
        }

    }
    public static int solution(int src, int dest) {
        int counter = 0;
        for(int i=0; i<maxN; i++)
            for(int j=0; j<maxN; j++) {
                if(counter==src){
                    startRow = i;
                    startCol = j;
                }
                if(counter==dest){
                    endRow = i;
                    endCol = j;
                }
                counter++;
            }
        bfs();
        return dist[endRow][endCol];
    }

    static class pos {
        int r, c;
        public pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(0 ,1));
    }
}

