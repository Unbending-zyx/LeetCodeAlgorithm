package com.myprojects.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */
public class Easy1 {
    //复杂方式   时间复杂度为  n的平方
    public static int[] twoSum(int[] nums, int target) {
        int[] result={-1,-1};
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

    /**
     * 优化算法   时间复杂度为  n
     * 使用了一个map作为中间存储   使用map中的containsKey方法  判断是否存在key值
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            int num=target-nums[i];
            if (map.containsKey(num)){
                return new int[]{map.get(num),i};
            }
            map.put(nums[i],i);
        }
        throw new RuntimeException("不存在");
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,0};
        int target=1;
        int[] result=twoSum2(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}
