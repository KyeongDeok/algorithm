package boj;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2800 {
	static int [] match;
	static char [] charSet;
	static boolean [] erase;
	static StringBuilder sb = new StringBuilder();
	static List <String> list = new LinkedList<>();
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		
		charSet = str.toCharArray();
		int len = str.length();
		
		Stack <Integer> st = new Stack<>();
		match = new int[len];
		erase = new boolean[len];
		
		char c;
		for(int i=0;i<len;i++) {
			c = charSet[i];
			if(c == '(') {
				st.push(i);
			}else if(c == ')'){
				match[i] = st.peek();
				match[st.peek()] = i;
				st.pop();
			}
		}
		eraseString(0);
		
		Collections.sort(list);
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static void eraseString(int cur) {
		
		if(cur == charSet.length) {
			list.add(sb.toString());
			return;
		}
		
		if(charSet[cur] == '(') {
			erase[match[cur]] = true;
			eraseString(cur+1);
			erase[match[cur]] = false;
		}
		
		if (charSet[cur] == ')' && erase[cur]){
			eraseString(cur+1);
		}
		
		sb.append(charSet[cur]);
		eraseString(cur+1);
		sb.delete(sb.length() -1 , sb.length());
	}
}
