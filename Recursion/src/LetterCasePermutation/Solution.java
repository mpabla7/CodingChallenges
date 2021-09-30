package LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private ArrayList<String> result = new ArrayList<>();
    
    /*
     *  Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
     *  Return a list of all possible strings we could create. You can return the output in any order.
     *  
     *  LC Medium : https://leetcode.com/problems/letter-case-permutation/
     *  45 mins from scratch
	 *
	 * Input: S = "a1b2"
     * Output: ["a1b2","a1B2","A1b2","A1B2"]
     */
    public List<String> letterCasePermutation(String S) {
        
        permuate(S, 0);
        return result;
    }
    
    public void permuate(String S, int start) {
        
        if(!result.contains(S)) {
            result.add(S);
        }
        
        StringBuilder current = new StringBuilder(S);
        
        for(int i = start ; i< S.length();i++) {
            
            char c = S.charAt(i);
            
            if(!Character.isDigit(c)) {
                if(Character.isUpperCase(c)){
                    
                    permuate(S, ++start);
                    char low = Character.toLowerCase(c);
                    current.setCharAt(i, low);
                    permuate(current.toString(), start++);
                } else {
                    permuate(S, ++start);
                    char up = Character.toUpperCase(c);
                    current.setCharAt(i, up);
                    permuate(current.toString(), start++);
                }
            }        
        }
    }
}
