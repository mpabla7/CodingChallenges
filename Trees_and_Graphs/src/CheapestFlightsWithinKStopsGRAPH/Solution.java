package CheapestFlightsWithinKStopsGRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	/**
	 * 
	 * Finding shortest path with in a weighted graph
	 * 
	 * It was really hard to code the DFS part. LOOK AT PICS 2/9/21
	 * 
	 * LC MEDIUM : https://leetcode.com/problems/cheapest-flights-within-k-stops/
	 * Resources: https://www.youtube.com/watch?v=60RbWlDFsmI&t=948s&ab_channel=TECHDOSE
	 * 
	 * NOTE: you can get rid of costMatrix and just use: (slower run time)         
	 * HashMap<Integer, HashMap<Integer, Integer>> adjMap = new HashMap<>();
	 * 
	 * @param n
	 * @param flights
	 * @param src
	 * @param dst
	 * @param K
	 * @return
	 */
	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	        
	        HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
	        int[][] costMatrix = new int[n+1][n+1];
	        boolean[] visited = new boolean[n+1];
	        
	        for(int[] flight : flights) {
	            
	            if(adjMap.containsKey(flight[0])) {
	                 adjMap.get(flight[0]).add(flight[1]);
	            } else {
	                List<Integer> destinations = new ArrayList<>();
	                destinations.add(flight[1]);
	                adjMap.put(flight[0],destinations);
	            }
	            costMatrix[flight[0]][flight[1]] = flight[2];
	        }
	       int fare = Integer.MAX_VALUE;
	      // logger(adjMap, costMatrix, visited, n);
	        fare = dfs(adjMap, costMatrix, visited, K, src, dst, fare, 0);
	        if(fare == Integer.MAX_VALUE) return -1;
	        return fare;
	    }
	    
	    public int dfs(HashMap<Integer, List<Integer>> adjMap, int[][] costMatrix, boolean[] visited, int k, int src, int dst, int fare, int totalCost ) {
	        
	        if(k<-1) return fare;
	        if(src==dst) {
	            fare = Math.min(fare, totalCost);
	            return fare;
	        }
	       List<Integer> adjList = adjMap.get(src);
	       if(adjList==null) return fare;
	        
	        visited[src] = true;
	        for(int i =0; i < adjList.size(); i++) {
	            
	            if(!visited[adjList.get(i)]) {
	                if(totalCost + costMatrix[src][adjList.get(i)] <= fare) {
	                    fare = dfs(adjMap, costMatrix, visited, k-1, adjList.get(i), dst, fare, totalCost + costMatrix[src][adjList.get(i)]);
	                }
	            }
	        }
	        visited[src] = false;
	        return fare;
	    }
	    
	    public void logger(HashMap<Integer, List<Integer>> adjMap,  int[][] costMatrix, boolean[] visited, int n) {
	        for(Map.Entry<Integer,List<Integer>> entry : adjMap.entrySet()) {
	           System.out.println("k = " + entry.getKey() + " v = " + entry.getValue());
	       }
	       System.out.println("-----------------");
	       for(int i = 0; i <= n; i++) {
	          for(int j = 0; j <= n; j++) {
	              System.out.print(" " + costMatrix[i][j]);
	          }
	           System.out.println();
	       }
	        System.out.println("-----------------");
	        for(boolean i : visited ) System.out.print(" " + i);
	    }
}
