import java.util.*;
import java.io.*;

class Main {
	static final int POP = 1;
	static final int PUSH = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int len = 10;
		Integer [] st = new Integer[len];
		int top = -1;
		
		for(int i=0;i<num;i++){
			int comm = sc.nextInt();
			if(comm != POP && comm != PUSH){
				break;
			}else{
				if(comm == POP){
					if(top < 0){
						System.out.println("underflow");
					}else{
						top--;
					}
				}else if(comm == PUSH){
					int number = sc.nextInt();
					if(top >= 9){
						System.out.println("overflow");
					}else{
						st[++top] = number;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<=top;i++){
			sb.append(st[i]+" ");
		}

		System.out.println(sb.toString());
		sc.close();
	}
}