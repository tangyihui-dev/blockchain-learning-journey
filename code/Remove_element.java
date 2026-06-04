package com.yihui.Algorithm;
//移除元素
//给你一个数组 nums和一个值val，你需要删除所有数值等于 val的元素举例1:
//输入：nums =[3, 2, 2, 3] val=3输出：nums=[2, 2] 剩余2个元素举例1:
//输入：nums=[0, 1, 2, 2, 3, 0, 4, 2] val=2
//输出：nums=[0, 1, 4, 0, 3] 剩余5个元素
public class Remove_element {
    public static void main(String[] args) {
        //给定一个数组nums
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        //给定一个值val
        int val = 2;
        //创建一个快指针fast
        int fast = 0;
        //创建一个慢指针slow
        int slow = 0;
        while (fast < nums.length){
            //判断快指针的元素是否等于 val
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        System.out.print("[");
        for (int i = 0; i < slow; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println("]");
        System.out.println("剩余数组中不等于val的数有："+ slow+ "个");
    }
}
