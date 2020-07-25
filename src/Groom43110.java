import java.io.*;
class Groom43110 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        char [] arr = input.toCharArray();
        int len = arr.length;

        StringBuilder sb = new StringBuilder();
        int front=0,rear=len;
        for(int i=0;i<len;i++){
            front = i;
            rear = len-1-i;

            if(front < rear){
                sb.append(input.charAt(front));
                sb.append(input.charAt(rear));
            }else if(front == rear){
                sb.append(input.charAt(front));
            }else{
                break;
            }
        }
        System.out.println(sb.toString());
	}
}