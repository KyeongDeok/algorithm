import java.io.*;
import java.util.*;

public class Main2163 {
    static int N,M;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        
        int size = N*M;
        int [] dp = new int[size+1];

        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=size;i++){
            int a = i/2;
            int b = i-a;

            dp[i] = dp[a] + dp[b] + 1;
        }
        System.out.println(dp[size]);
    }
}