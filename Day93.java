/*Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets.
Note: The test cases are generated so that the length of the output string will never exceed 105 .*/
class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }else if (c == '['){
                countStack.push(num);
                stringStack.push(currentString);
                
                currentString = new StringBuilder();
                num = 0;
            }else if (c == ']'){
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                for(int i = 0 ; i < repeatTimes ; i ++){
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            }else{
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
