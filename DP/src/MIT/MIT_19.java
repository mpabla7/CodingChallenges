package MIT;

import java.util.ArrayList;
import java.util.HashMap;

public class MIT_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(20));
		System.out.println(fibMemo(20));
	}
	
	/**
	 * Naive recursive algorithm
	 * 
	 * Exponential time: 
	 * T(n) = T(n-1) + T(n-2) + theata(1)
	 * T(n) >= 2T(n-2)
	 * theata(2^(n/2))
	 * 
	 */
	public static int fib(int n) {
		int f = 0;
		
		if(n <= 2) f = 1;
		else f = fib(n-1) + fib(n-2);
		return f;
	}
	
	
	/**
	 * 
	 * Memoized DP algorithm 
	 * 
	 * Why does it improve things? Think about the recursion tree.
	 * fibMemo(k) only recurses the first time it's called. 
	 * 
	 * memoized calls cost O(1) constant time 
	 * # of non-momoized calls is n 
	 * 
	 * Time = O(n) is linear 
	 */
	private static HashMap<Integer, Integer> memo = new HashMap<>();
	public static int fibMemo(int n) {
		int f = 0;
		
		if(memo.containsKey(n)) return memo.get(n); 
		if(n <= 2) f = 1;
		else f = fib(n-1) + fib(n-2);
		memo.put(n, f);
		return f;
	}
	
	/**
	 * Bottom up approach 
	 * 
	 * @param n
	 * @return
	 */
	public static int bottomUpFib(int n) {
		
		int f = 0;
		for(int i = 1; i < n+1; i++) {
			if(i <= 2) f =1;
			else f = memo.get(i-1) + memo.get(i-2);
			memo.put(i,f);
		}
		return memo.get(n);
		
	}
}
