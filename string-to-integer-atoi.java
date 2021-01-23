// Question solved from leetcode: https://leetcode.com/problems/string-to-integer-atoi/

// Implement the myAtoi(string s) function, 
// which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

class Solution {
    public int myAtoi(String s) {
        // set up variables 
        boolean positive = true;
        int result = 0;
        String currResult = "";
        boolean checkNumber = true;
        int pos = 0;
        int numOfSigns = 0;
        boolean seenNumber = false;
        
        // while loop, ignore whitespace, look for - or + , save numbers, stop looping after numbers
        while(checkNumber && pos < s.length()) {
            Character c = s.charAt(pos);
            // System.out.println(c);
            if(c == '-' || c == '+') {
                if(seenNumber) {
                    break;
                }
                numOfSigns++;
                if (numOfSigns == 2) {
                    return 0;
                }
                if (c == '-') {
                    positive = false;
                }
            } else if(Character.isDigit(c)) {
                currResult += c;
                seenNumber = true;
            } else if(c != ' ' && c != '+'){
                if (currResult == "") {
                    return result;
                } else {
                    checkNumber = false;
                }
            } else {
                // here it is ' '
                if (seenNumber || numOfSigns > 0) {
                    break;
                }
            }
            pos++;
        }
        
        // System.out.println(currResult);
        // convert to int or return 0 if nothing to convert
        try { 
            if (currResult == "") {
                return 0;
            } else {
                result = Integer.parseInt(currResult); 
                if(!positive) {
                    result *= -1;
                } 
            }
        } catch (NumberFormatException e) {
            result = 2147483647;
            if(!positive) {
                result = -2147483648;
            }
        }
        
        return result;
        
    }
}
