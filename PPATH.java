import java.util.*;
import java.io.*;
 class karan_kun {
	
	public static int MAX = 100001;
	public static boolean[] sieve = new boolean[MAX];
	public static void main(String[] args) {
		for(int i=0; i<MAX; i++) {sieve[i] = true;}
		
		//System.out.println(sieve_().size());
		HashMap<Integer, Integer> map = sieve_();
		graph g = new graph();
		Set<Integer> set = map.keySet();
		for(int i : set) {
			for(int j : set) {
				if(diff(i,j)) {
					g.addEdge(i, j);
				}
			}
		}
		Scanner scan = new Scanner(System.in);
		//g.display();
		int T = scan.nextInt();
		
		for(int t=0; t<T; t++) {
			int src = scan.nextInt(), des= scan.nextInt();
			LinkedList<Integer> queue = new LinkedList<>(); queue.addLast(src);
			LinkedList<Integer> answer = new LinkedList<>(); answer.addLast(0);
			HashMap<Integer, Boolean> visited= new HashMap<>(); visited.put(src,true);
			System.out.println(g.bfs(queue, visited, answer, des));
		}
		//System.out.println(diff(6079,2053));
		
	}
	
	public static boolean diff(int a, int b) {
		char[] s1= String.valueOf(a).toCharArray(),  s2 = String.valueOf(b).toCharArray();
		/*for(int i=0; i<s1.length; i++) {
			System.out.println(s2[i]);
		}*/
		
		if(s1[0] == s2[0] && s1[1] == s2[1] && s1[2] == s2[2] && s1[3] != s2[3]) {
			//System.out.println("here1");
			return true;
		}
		
		else if(s1[0] == s2[0] && s1[1] == s2[1] && s1[2] != s2[2] && s1[3] == s2[3]) {
			//System.out.println("here2");
			return true;
		}
		
		else if(s1[0] == s2[0] && s1[1] != s2[1] && s1[2] == s2[2] && s1[3] == s2[3]) {
			//System.out.println("here3");
			return true;
		}
		
		else if(s1[0] != s2[0] && s1[1] == s2[1] && s1[2] == s2[2] && s1[3] == s2[3]) {
			//System.out.println("here4");
			return true;
		}
		else {
			return false;
		}
	}
	
	public static HashMap<Integer,Integer>sieve_(){
		ArrayList<Integer> answer=  new ArrayList<>();
		HashMap<Integer,Integer> ans__ = new HashMap<>();
		for(int i=2; i*i<=MAX; i++) {
			for(int j=i*i; j<MAX && sieve[i]; j=j+i) {
				sieve[j] = false;
			}
		}
		
		for(int i=2; i<MAX; i++) {
			if(sieve[i]) {
				if(i >= 1000 && i<= 9999) {
					ans__.put(i, 1);
				}
			}
		}
		
		return ans__;
	}
	
	static class graph{
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		graph(){};
		
		public void addEdge(int src, int des) {
			if(!map.containsKey(src)) {
				map.put(src, new HashMap<>());
			}
			if(!map.containsKey(des)) {
				map.put(des, new HashMap<>());
			}
			
			map.get(src).put(des, 1);
			map.get(des).put(src, 1);
		}
		
		public void display() {
			Set<Integer> set = map.keySet();
			for(int i : set) {
				System.out.println(i +"=>" + map.get(i));
			}
		}
		
		public int bfs(LinkedList<Integer> queue, HashMap<Integer, Boolean> visited, LinkedList<Integer> answer, int des) {
			
			while(!queue.isEmpty()) {
				int curr = queue.removeFirst();
				int ans = answer.removeFirst();
				if(curr == des) {
					return ans;
				}else {
					
					Set<Integer> set = map.get(curr).keySet();
					for(int i : set) {
						if(!visited.containsKey(i)) {
							visited.put(i, true);
							queue.addLast(i);
							answer.addLast(ans+1);
						}
					}
					
				}
			}
			
			return -1;
			
		}
		
	}

}
