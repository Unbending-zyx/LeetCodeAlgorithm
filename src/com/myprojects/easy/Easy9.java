package com.myprojects.easy;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Easy9 {
    //使用字符串作为中间变量   倒序进行比较
    public static boolean isPalindrome(int x) {
        String str=((Integer)x).toString();
        StringBuffer stringBuffer=new StringBuffer(str);
        stringBuffer.reverse();
        if(str.equals(stringBuffer.toString())){
            return true;
        }else{
            return false;
        }
    }

    //第二种想法   先判断是否为负数  负数肯定不满足要求   然后直接将数字倒序  与传入参数进行比较
    //时间复杂度  为log10（n）

    public static boolean isPalindrome1(int x) {
        if(x<0){
            return false;
        }
        int rev=0;
        int temp=x;
        while(temp!=0){
            int pop=temp%10;
            temp=temp/10;
            rev=rev*10+pop;
        }
        if (rev==x){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome1(121));
    }
}
