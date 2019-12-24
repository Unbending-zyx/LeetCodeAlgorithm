package com.myprojects.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Easy14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String shortString=strs[0];
        //找出长度最小的字符串
        for (String s:strs){
            if (s.length()<shortString.length()){
                shortString=s;
            }
        }
        int i=0;
        while(i<strs.length){
            if (!strs[i].startsWith(shortString)){
                if (shortString==""){
                    return "";
                }
                shortString=shortString.substring(0,shortString.length()-1);
            }else{
                i++;
            }
        }
        return shortString;
    }

    public static void main(String[] args) {
        String[] strs={"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
