package IntroToAlgo;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p [] = new int[] {0,1,5,8,9,10,17,17,20,24,30};
							//0 1 2 3 4  5  6  7  8  9 10    
		System.out.println(bottomUpCutRod(p, 4)); // 10 
		System.out.println(bottomUpCutRod(p, 5)); // 13
		System.out.println(bottomUpCutRod(p, 6)); // 17 
		System.out.println(bottomUpCutRod(p, 7)); // 18
		System.out.println(bottomUpCutRod(p, 8)); // 22 

	}
	/**
	 * Given a rod of length n inches and a table of prices p for i = 1, 2, …, n ,
	 * determine the maximum revenue obtainable by cutting up the rod and selling the pieces. 
	 * 
	 * @param p - prices array where index represents length of rod, value represents price
	 * @param n - length n inches 
	 * @return
	 */
	public static int bottomUpCutRod(int p [], int n) {
		// cache array
		int [] r = new int[n+1];
		r[0] = 0;
		
		for(int j = 1; j <=n; j++) {
			int q = -1;
			for(int i = 1; i <=j; i++) {
				q = Math.max(q, p[i] + r[j-i]);
			}
			r[j] = q;
		}
		return r[n];
	}
}
