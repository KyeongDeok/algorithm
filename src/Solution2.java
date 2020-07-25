import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution2 {
	static long N;
	static LinkedList <Long> list = new LinkedList<>();
	static PriorityQueue <Long> ans = new PriorityQueue<>();
	public static void main(String [] args) {
		System.out.println(solution(11));
	}
	public static  long solution (long n) {
		long answer = 0;
		N = n;
		long cnt=1;
		long num=1;
		list.add(num);
		ans.offer(num);
		while(cnt<=n/2) {
			num = (long)Math.pow(3,cnt);
			list.add(num);
			ans.offer(num);
			cnt++;
		}
		for(int k=0;k<list.size();k++) {
			System.out.println("--");
			System.out.println(list.get(k));
		}
		
		for(int i=2;i<n;i++) {
			dfs(0,0,0,i);
			if(n <= list.size()) {
				break;
			}
		}
		for(int i=0;i<n-1;i++) {
//			ans.poll();
			System.out.println(ans.poll());
		}
		return answer = ans.poll();
	}
	public static void dfs(int cur,long sum,long cnt,long lim) {
		if(cnt == lim) {
			ans.offer(sum);
			return;
		}
		for(int i=cur;i<=N/2;i++) {
			sum += list.get(i);
			dfs(cur+1,sum,cnt+1,lim);
			sum -= list.get(i);
		}
	}
}
