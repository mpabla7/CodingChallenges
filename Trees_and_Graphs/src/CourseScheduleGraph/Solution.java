package CourseScheduleGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    
    /**
     * This will return false if there is a cycle in the DAG. 
     * 
     * LC MEDIUM: https://leetcode.com/problems/course-schedule/
     * 
     * Resources:
     * https://www.youtube.com/watch?v=rG2-_lgcZzo&ab_channel=NideeshTerapalli
     * https://en.wikipedia.org/wiki/Topological_sorting#Algorithms			(Kahn's algorithm)
     * 
     * 
     * Done from scratch find a better version
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishAttempt(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        //indegree occurance counter table
        int [] table = new int[numCourses];
        
        if(prerequisites.length==1) return true;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            } 
            ArrayList<Integer> l = map.get(prerequisites[i][1]);
            l.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], l);
            table[prerequisites[i][0]]++;
            
            // last element in array
            if(i == prerequisites.length-1) {
                int end = Collections.max(map.keySet()) + 1;
                if(end < table.length) table[end]=-1;
            }
        }
        
       // int realSize = 0;
        for(int i = 0; i < table.length; i++) {
            if(table[i] > -1) {
                if(table[i]==0 && map.containsKey(i)){
                    q.add(i);
                }
                //realSize++;
            }
        }
        

        // pointer to queue
        int cur = 0;
         while(!q.isEmpty()) {
            
            int node = q.remove();
            cur++;
      
            // find all neighbors of current node, decrememnt their indegree count by 1
            // why ??? B/c this is the new starting node
           
            ArrayList<Integer> l = map.get(node);
             if(l == null) continue;
            for(int i = 0; i < l.size(); i++) {               
                table[l.get(i)]--;
                if(table[l.get(i)] == 0) {
                    q.add(l.get(i));
                }
            }            
        }
        for(int i : table) {
            if(i!=-1) {
                if(i > 0) return false;
            } else {
                break;
            }
        }
//         for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())   {
//                     System.out.println("Key = " + entry.getKey());
//                     ArrayList<Integer> j = entry.getValue();
//                     for(int i : j) {
//                         System.out.println("value= " + i);
//                     }                                  
//         } System.out.println("--------------\n");  
//         for(int i :table) System.out.print( i + " " );   
//         System.out.println("--------------\n");
//         for(int i = 0; i < q.size(); i++) System.out.println( q.poll() +" ");
        return true;
    }
}