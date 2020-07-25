import java.util.ArrayList;
import java.util.Scanner;


public class Main1644 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		boolean [] p = new boolean[N+1];
		double sqrt = Math.floor(Math.sqrt(N));
		
		for(int i=2;i<=sqrt;i++) {
			for(int j=i+i;j<=N;j+=i) {
				p[j] = true;
			}
		}
		ArrayList <Integer> a = new ArrayList<>();
		for(int i=2;i<=N;i++) {
			if(p[i]) continue;
			a.add(i);
		}
		int s,e;
		s=0;
		e=0;
		int len = a.size();
		int ans = 0;
		int sum;
		while(s<len && e<len) {
			sum = getSum(s,e,a);
			if(sum < N) {
				e++;
			}else if(sum > N){
				s++;
			}else {
				ans+=1;
				s++;
				e++;
			}
		}
		System.out.println(ans);
	}
	public static int getSum(int s,int e,ArrayList<Integer>a) {
		int sum = 0;
		for(int i=s;i<=e;i++) {
			sum+=a.get(i);
		}
		return sum;
	}
}
