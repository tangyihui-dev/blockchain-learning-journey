package com.yihui.define;

import java.util.Scanner;

//班主任需要统计10名学生的
//计算及格率，平均分，并找出出最高分。
//要求1:键盘录入10名学生的成绩，存入数组。超出范围，提示“成绩无效，请重新输入”。
//要求2:定义方法，求及格人数，根据及格人数，求及格率。
//要求3:定义方法求总分，根据总分求平均分要求
// 4:定义方法求最大值。
public class score {
    public static void main(String[] args) {
        //键盘录入10名学生的成绩
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("输入十名同学的分数");
            for (int i = 0; i < arr.length; i++) {
                System.out.println("请输入第"+(i+1)+"名同学的分数");
                int score = sc.nextInt();
                if(score<0||score>100){
                    System.out.println("成绩无效，请重新输入");
                    i--;
                    continue;
                }
                arr[i] = score;
            }
        System.out.println("请选择功能:\n1,及格人数与及格率。\n2,总分与平均分。\n3,分数最大值。");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    getCount(arr);
                    break;
                case 2:
                    getSum(arr);
                    break;
                case 3:
                    getMax(arr);
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        //定义方法，求及格人数，根据及格人数，求及格率
    public static void getCount(int[] arr){
        //定义变量接收及格人数
        int count = 0;
        //创建循环判断学生成绩是否及格
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>=60){
                count++;
            }
        }
        //根据及格人数，求及格率
        System.out.println("及格人数为："+count);
        System.out.println("及格率为："+count/10);
    }
    //定义方法求总分，根据总分求平均分要求
    public static void getSum(int[] arr){
        //循环求总分
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("总分为："+sum);
        System.out.println("平均分为："+sum/10);
    }
    //定义方法求最大值。
    public static void getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
            }
        }
        System.out.println("最大值为："+max);
    }
 }
