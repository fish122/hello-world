import java.util.Stack;

public class Solution6 {

    public static void main(String[] args) {
        String s = "{()}";
        isValid(s);
    }


    /**
     * 判断是否满足条件
     * @param s string字符串 字符串s
     * @return bool布尔型
     */
    public static boolean isValid (String s) {
        // write code here
        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<brackets.length;i++){
            if(!stack.empty()){
                if(brackets[i] == '}'){
                    if(stack.pop() == '{'){
                        continue;
                    }else {
                        return false;
                    }
                }
                if(brackets[i] == ')'){
                    if(stack.pop() == '('){
                        continue;
                    }else {
                        return false;
                    }
                }
                if(brackets[i] == ']'){
                    if(stack.pop() == '['){
                        continue;
                    }else {
                        return false;
                    }
                }
                stack.push(brackets[i]);
            }else {
                stack.push(brackets[i]);
            }
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
        return stack.empty();
    }
}
