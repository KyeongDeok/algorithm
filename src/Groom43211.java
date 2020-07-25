//다익스트라 알고리즘
import java.util.*;
import java.io.*;

class Groom43211 {
    public static final int INF = Integer.MAX_VALUE;
    static int [] dist;
    static boolean [] visited;
    static int N,E;
    static int [][] map;

    static class Node implements Comparable<Node> {
        int here,w;
        public Node(int here,int w){
            this.here = here;
            this.w = w;
        }

        @Override
        public int compareTo(Node n){
            return this.w - n.w;
        }
    }
    
    public static int stoi(String s){
        return Integer.parseInt(s);
    }

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        N = stoi(stk.nextToken());
        E = stoi(stk.nextToken());
        dist = new int[N+1];
        visited = new boolean[N+1];
        map = new int[N+1][N+1];

        //무한대로 초기화.
        Arrays.fill(dist,INF);

        //가중치 입력
        int start,end,w;
        for(int i=0;i<E;i++){
            stk = new StringTokenizer(br.readLine());
            start = stoi(stk.nextToken());
            end = stoi(stk.nextToken());
            w = stoi(stk.nextToken());

            //양방향
            if(map[start][end]!=0){
                if(map[start][end] > w){
                    map[start][end] = w;
                    map[end][start] = w;
                }
            }else{
                map[start][end] = w;
                map[end][start] = w;
            }
        }
        
        //시작 정점
        int start_node = stoi(br.readLine());
        dist[start_node] = 0;

        PriorityQueue <Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start_node,dist[start_node]));
        
        while(!pq.isEmpty()){
            int cost = pq.peek().w;
            int here = pq.peek().here;
            pq.poll();

            if(cost > dist[here]){
                continue;
            }
            
            for(int i=1;i<N+1;i++){
                if(map[here][i] != 0 && dist[i] > dist[here] + map[here][i]){
                    dist[i] = dist[here] + map[here][i];
                    pq.offer(new Node(i, dist[i]));
                }
            }
            System.out.println(Arrays.toString(dist));
        }

        for(int i=1;i<N+1;i++){
            System.out.println(i+":"+ dist[i]);
        }
	}
}