package groom;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main43165 {
    static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = stoi(stk.nextToken());
        int M = stoi(stk.nextToken());

        BigInteger [] dp = new BigInteger[N+1];

        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");
        for(int i=3;i<=N;i++){
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
        }

        System.out.println(dp[N].mod(BigInteger.valueOf(M)));
    }
}
