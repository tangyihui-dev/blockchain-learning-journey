package com.yihui.Algorithm;

import java.util.Scanner;

//接雨水
//给定n个非负整数表示每个宽度为1的柱子的高度图，
//计算按此排列的柱子，下雨之后 能接多少雨水
//输入：height=[0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
//输出：6
//解释：下面是由数组 [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]表示的高度图，
// 在这种情况下，可以接6个单位的雨水（蓝色部分表示雨水）
public class Collect_rainwater {
    public static void main(String[] args) {
        //定义键盘输入n个数组
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        /*
        System.out.print("请输入需要的数量：");
        int n = sc.nextInt();
        //for循环从键盘接收水量
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("请输入第"+(i+1)+"个数：");
            arr[i] = sc.nextInt();
            if(arr[i]<0){
                System.out.println("输入的数不能小于0");
                i--;
            }
        }
         */

        // 调用接雨水算法并输出结果
        int totalWater = trap(arr);
        System.out.println("接雨水的雨水是：" + totalWater);
    }

    /**
     * 计算能接多少雨水（动态规划解法）
     * 
     * 核心思想：
     * 对于每个位置i，能接的雨水量取决于它左边和右边的最高柱子
     * 雨水量 = min(左边最高柱子, 右边最高柱子) - 当前位置高度
     * 
     * 算法步骤：
     * 1. 预计算每个位置左边的最高柱子高度
     * 2. 预计算每个位置右边的最高柱子高度
     * 3. 遍历每个位置，根据公式计算雨水量并累加
     * 
     * @param height 柱子高度数组
     * @return 总共能接的雨水量
     */
    public static int trap(int[] height) {
        // 边界条件检查：如果数组为空或长度小于等于2，无法接雨水
        if (height == null || height.length <= 2) {
            return 0;
        }

        int n = height.length;  // 柱子数量
        int totalWater = 0;     // 总雨水量

        // 第一步：预计算每个位置左边的最高柱子高度
        // leftMax[i] 表示位置i及其左边所有柱子中的最大高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];  // 第一个位置左边最高就是它自己
        for (int i = 1; i < n; i++) {
            // 当前位置左边最高 = max(前一个位置的左边最高, 当前柱子高度)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 第二步：预计算每个位置右边的最高柱子高度
        // rightMax[i] 表示位置i及其右边所有柱子中的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];  // 最后一个位置右边最高就是它自己
        for (int i = n - 2; i >= 0; i--) {
            // 当前位置右边最高 = max(后一个位置的右边最高, 当前柱子高度)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 第三步：计算每个位置能接的雨水量并累加
        for (int i = 0; i < n; i++) {
            // 当前位置能接的雨水 = 左右两边最高柱子的较小值 - 当前高度
            // 原理：水的高度由较矮的那一边决定（木桶效应）
            int waterAtPosition = Math.min(leftMax[i], rightMax[i]) - height[i];
            totalWater += waterAtPosition;  // 累加到总雨水量
        }

        return totalWater;
    }
}

