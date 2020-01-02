package com.myprojects.easy;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class Easy26 {
    //思路1：从头开始取出元素   从尾开始查找重复元素并删除，删除当前元素后，将该元素之后的元素依次前移一位
    //此思路时间复杂度极高   不建议使用
    //时间  172ms  空间  39.8M
    public static int removeDuplicates(int[] nums) {
        int result=nums.length;
        for (int i=0;i<nums.length;i++){
            for (int j=result-1;j>i;j--){
                if (nums[i]==nums[j]){
                    result=result-1;
                    for (int a=j;a<nums.length-1;a++){
                        nums[a]=nums[a+1];
                    }
                }
            }
        }
        return result;
    }

    //思路2：由于传入的数组已经是有序的了  所以在思路1的基础上进行优化  将第二层循环由后向前取值变为从前向后
    //判断值的大小  二层循环的值大于一层循环  则跳出
    //这样循环次数大幅度减少
    //时间  63ms   空间  43.4MB
    public static int removeDuplicates1(int[] nums){
        int result=nums.length;
        for (int i=0;i<result;i++){
            for (int j=i+1;j<result;j++){
                if (nums[i]==nums[j]){
                    for (int a=j;a<result-1;a++){
                        nums[a]=nums[a+1];
                    }
                    j=j-1;
                    result=result-1;
                }
                if (nums[i]<nums[j]){
                    break;
                }
            }
        }
        return result;
    }

    //

    /**
     *猜想：
     *  用例说明：
     *      int[] nums={0,0,1,1,1,2,2,3,3,4};  这样一个有序数组
     *      先立一个flag  此flag用与存储当前完成换位操作的位置
     *      外层循环  依次取值  内层循环完成比较及赋值
     *      过程：第一次外层循环取  第一个0  内层循环开始向后比较   如果两值相等  进入下一次内层循环   如果  内层循环取得值大于外层循环
     *          则将这个值赋给数组中flag+1位置   将外层循环中的循环变量置为此刻内层循环的循环变量（此位置之前的元素没有必要再次进行比较） 跳出内层循环
     *          最后的返回值为flag+1  因为flag存储的是排序去重好的最后一个元素的索引值，将该值加1   即是完成操作的数组长度。
     *
     *时间：1ms  空间 39MB
     */
    public static int removeDuplicates2(int[] nums){
        int flag=0;//作为标志位
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if (nums[flag]<nums[j]){
                    nums[flag+1]=nums[j];
                    flag++;
                    i=j;
                    break;
                }
            }
        }
        return flag+1;
    }

    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        int[] nums1={1,2,3};
        System.out.println(removeDuplicates2(nums1));
    }
}
