package groom;

import java.io.*;
import java.util.*;

class Main43266 {
    static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = stoi(stk.nextToken());
        int K = stoi(stk.nextToken());

        int [] arr = new int[N+1];

        int death_cnt = 0;
        int target = 1;

        while(N - death_cnt > 2){
            if(arr[target] == -1 || target == 0){
                target++;
                continue;
            }else{
                System.out.println(target);
                arr[target] = -1;
                death_cnt++;
            }

            target += (K);
            if(target > N){
                target %= N;
            }
        }

        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> alives = new ArrayList<>();

        for(int i=1;i<=N;i++){
            if(arr[i] == -1) continue;

            alives.add(i-1);
        }
        Collections.sort(alives);
        System.out.println(alives.get(0)+" "+alives.get(1));
    }
}