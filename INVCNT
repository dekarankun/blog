import java.util.*;
import java.io.*;
 class INVCNT_karan_kun_ {
	public static Scanner scan = new Scanner(System.in);
	public static int MAX = 10000001;
	public static void main(String[] args) throws IOException{
		
		int T = scan.nextInt();
		for(int t=0;t<T; t++) {
			long[] tree = new long[4*MAX+1];
			long answer = 0;
			int N = scan.nextInt();
			for(int i=0; i<N; i++) {
				int curr = scan.nextInt();
				answer+=query(0,MAX,1,tree,curr+1,MAX);
				update(0,MAX,1,tree,curr,curr);
			}
			System.out.println(answer);
		}
		
	}
	
	
	public static void update(int left, int right, int index, long[] tree,int ql,int qr) {
		
		if(left == right && (ql <=left && qr >= right)) {
			tree[index]++;
		}
		
		else if(qr < left || ql > right) {
			return ;
		}
		
		else {
			int mid = (left+right)/2;
			update(left,mid,2*index,tree,ql,qr);
			update(mid+1,right,2*index+1,tree,ql,qr);
			tree[index] = (tree[2*index]+tree[2*index+1]);
		}
		
	}
	
	public static long query(int left, int right, int index, long[]tree, int ql,int qr) {
		if(qr < left || ql > right) {
			return 0;
		}
		else if(ql <= left && qr >= right) {
			return tree[index];
		}
		else {
			int mid = (left+right)/2;
			long a = query(left,mid,2*index,tree,ql,qr);
			long b = query(mid+1,right,2*index+1,tree,ql,qr);
			return (a+b);
		}
	}

}
