package groom;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main49096 {
    static int stoi(String s){
        return Integer.parseInt(s);
    }
    static long stol(String s){
        return Long.parseLong(s);
    }
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long N = stol(stk.nextToken());
        long M = stol(stk.nextToken());

        ArrayList<Integer> fishs = new ArrayList<>();

        stk = new StringTokenizer(br.readLine());
        System.out.println(stk.countTokens());

        while(stk.hasMoreTokens()){
            fishs.add(stoi(stk.nextToken()));
        }

        long cnt = 0;
        int s=0, e=0;
        long sum = 0;

        while(true){
            if(sum >= M) sum -= fishs.get(s++);
            else if(e == N) break;
            else sum += fishs.get(e++);
            if(sum == M) cnt++;
        }

        System.out.println(cnt);
    }
}
