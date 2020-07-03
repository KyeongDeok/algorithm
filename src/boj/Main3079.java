package boj;
import java.util.Scanner;

public class Main3079 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextInt();
		long [] time = new long[N];
		long max = 0;
		for(int i=0;i<N;i++) {
			time[i] = sc.nextLong();
			max = Math.max(max,time[i]);
		}
		long l=1;
		long r = M * max;
		while(l<=r) {
			long mid = (l+r)/2;
			long sum = 0;
			for(int j=0;j<N;j++) {
				sum += mid/time[j];
			}
			if(sum < M) {
				l = mid + 1;
			}else if(sum >= M){
				r = mid - 1;
			}
		}
		System.out.println(l);
		sc.close();
	}
}
