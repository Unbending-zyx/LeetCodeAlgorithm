package com.myprojects.easy;


/**
 * 罗马数字回转
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 *
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 */
public class Easy13 {

    /**
     * 解题思路：
     *      将字符拆分，并按顺序保存在整形数组中（转化成罗马字符对应的整数值）  遍历整形数组
     *      相邻数比较    如果左边数大于等于右边数   则结果加上左边数    反之则减去左边数
     * @param str
     * @return
     */
    public static int romanToInt(String str){
        int result=0;
        char[] chars=str.toCharArray();
        int[] numArray=new int[chars.length];
        for (int i=0;i<chars.length;i++){
            numArray[i]=outNum(chars[i]);
        }
        for (int i=0;i<numArray.length;i++){
            if (i==numArray.length-1){
                result+=numArray[i];
            }else{
                if (numArray[i]>=numArray[i+1]){
                    result+=numArray[i];
                }else{
                    result-=numArray[i];
                }
            }
        }
        return result;
    }
    public static int outNum(char c){
        int result=0;
        if ('M'==c){
            result=1000;
        }
        if ('D'==c){
            result=500;
        }
        if ('C'==c){
            result=100;
        }
        if ('L'==c){
            result=50;
        }
        if ('X'==c){
            result=10;
        }
        if ('V'==c){
            result=5;
        }
        if ('I'==c){
            result=1;
        }
        return result;
    }

    public static void main(String[] args) {
        String roman="MCMXCIV";
        System.out.println(romanToInt(roman));
    }
}
