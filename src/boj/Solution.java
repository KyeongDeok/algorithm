package boj;

import java.util.HashSet;

public class Solution {
	public static void main(String [] args) {
		System.out.println(solution(2015));
	}
	public static int solution(int p) {
        int answer = 0;
        for(int i=p+1;i<=10000;i++) {
        	if(check(i)) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
	public static boolean check(int p) {
		HashSet <Character> hs = new HashSet<>();
		String tmp = String.valueOf(p);
		int len = tmp.length();
		char c;
		for(int i=0;i<len;i++) {
			c = tmp.charAt(i);
			if (hs.contains(c)) {
				return false;
		      } else {
		    	  hs.add(c);
		      }
		}
		return true;
	}
}
