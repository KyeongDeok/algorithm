import java.io.*;
import java.util.*;

class Groom43128 {
    static class Night{
        int y,x,cnt;
        public Night(int y,int x,int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int l;
    static int [][] dir = {{-2,-1},{-2,1},{2,1},{2,-1},{1,-2},{-1,-2},{1,2},{-1,2}};
    static int fy,fx;
    static int [][] squ;
    static boolean [][] visited;
    static int stoi(String s){
        return Integer.parseInt(s);
    }

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = stoi(br.readLine());
        squ = new int[l][l];
        visited = new boolean[l][l];
        
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int ny = stoi(stk.nextToken());
        int nx = stoi(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        fy = stoi(stk.nextToken());
        fx = stoi(stk.nextToken());

        visited[ny][nx] = true;
        System.out.println(bfs(new Night(ny, nx, 0)));
    }
    
    public static int bfs(Night init){
        Queue <Night> q = new LinkedList<>();
        q.offer(init);

        while(!q.isEmpty()){
            // System.out.println("test");

            Night n = q.poll();
            int y = n.y;
            int x = n.x;
            int cnt = n.cnt;

            if(y == fy && x == fx){
                int answer = cnt;
                return answer;
            }

            int len = dir.length;
            int cy,cx;
            for(int i=0;i<len;i++){
                cy = y + dir[i][0];
                cx = x + dir[i][1];
                if(check(cy,cx) && !visited[cy][cx] ){
                    q.offer(new Night(cy, cx, cnt+1));
                    visited[cy][cx] = true;
                }
            }
        }

        return -1;
    }

    public static boolean check(int y,int x){
        if(y < 0 || y >= l || x < 0 || x >= l){
            return false;
        }
        return true;
    }
}