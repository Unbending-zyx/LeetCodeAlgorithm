package com.myprojects.easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Easy20 {
    /**
     * 我的想法   使用栈  遇到左括号  入栈  遇到右括号则出栈
     * 最后判断栈是否为空   为空则返回true   否则返回false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack stack=new Stack();
        char[] chars=s.toCharArray();
        for (char c:chars){
            if (c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if (stack.empty()){
                    return false;
                }
                if (c==')'){
                    if ((char)stack.peek()=='('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if (c==']'){
                    if ((char)stack.peek()=='['){
                        stack.pop();
                    }else{
                        return false;
                    }
                }else if (c=='}'){
                    if ((char)stack.peek()=='{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.empty()?true:false;
    }

    public static void main(String[] args) {
        String s="(])";
        System.out.println(isValid(s));
    }
}
