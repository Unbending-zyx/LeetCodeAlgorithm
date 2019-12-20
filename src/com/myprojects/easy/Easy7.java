package com.myprojects.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次方,  2的31次方 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 */
public class Easy7 {
    /**
     * 自己的解法
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE){
            return 0;
        }
        Integer num=new Integer(x);
        StringBuffer stringBuffer=new StringBuffer(num.toString());
        stringBuffer.reverse();
        int flag=0;
        if (num<0){
            flag=-1;
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }else{
            flag=1;
        }
        Integer result=0;
        try{
            result=new Integer(stringBuffer.toString());
        }catch (Exception e){
            return 0;
        }
        result=result*flag;
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }else {
            return result;
        }
    }

    /**
     * 最优解法
     * @param x
     * @return
     */
    public static int reverse1(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
    public static void main(String[] args) {
        System.out.println(reverse1(-1234));
    }
}
