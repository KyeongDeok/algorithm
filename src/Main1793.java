import java.util.*;
import java.math.BigInteger;

public class Main1793 {
    static int N = 250;
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger [] dp = new BigInteger [N+1];
        
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for(int i=3;i<=250;i++){
            dp[i] = dp[i-2].multiply(new BigInteger("2"));
            dp[i] = dp[i].add(dp[i-1]);
        }

        while(sc.hasNextInt()){
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}