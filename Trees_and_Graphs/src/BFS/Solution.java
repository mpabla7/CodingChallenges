package BFS;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 7; 
		int [] arr = new int[]{4,7,1,3,7,7,7};
		meanNMode(num, arr);
	}
	public static void meanNMode(int num, int [] arr) {
	    
		double mode = 0;
	    for(int i =0; i < arr.length; i++) {
	        mode += arr[i];
	    }
	    double val = mode / num;
	    //System.out.println(val);
	    
	    int m = mode(arr);
	   // m = Math.Round(m, 4);
	    
	    //StringBuilder temp = new StringBuilder(m);
	    //String x = temp.substring(0,7);
	    double o = (double)Math.round(val * 10000d) / 10000d;
	    System.out.println(o + " " + m);
	}
	
	public static int mode(int arr[]) {
	    int maxValue= 0;
	    int maxCount = 0;

	    for (int i = 0; i < arr.length; ++i) {
	        int count = 0;
	        for (int j = 0; j < arr.length; ++j) {
	            if (arr[j] == arr[i]){
	                 ++count;
	            }
	        }
	        if (count > maxCount) {
	            maxCount = count;
	            maxValue = arr[i];
	        }
	    }

	    return maxValue;
	}
}
