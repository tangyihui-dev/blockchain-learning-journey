package com.yihui.define;

import java.util.Scanner;

//跳水比赛有五个评委打分，分数在0~100之间。最终得分会去掉一个最高分，去掉一个最低分，
//剩余的分数再求平均数，改平均数为选手最终得分。整数存入数组当中，如果分数超出范围需要重新录入
//要求1:利用键盘录入5个
//要求2:定义方法分别求数放组的最大值和最小值
//要求3:计算五名评委的总总分
//要求4:总分-最大值-量最小值，求选手最终平均分
public class swing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分：");
            arr[i] = sc.nextInt();
        }
        getMaxAndMin(arr);
    }
    // 定义方法分别求数放组的最大值和最小值
    public static void getMaxAndMin(int[] arr){
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
          if(max<arr[i]){
              max = arr[i];
          }
          if(min>arr[i]){
              min = arr[i];
          }
            //计算五名评委的总总分
           sum+=arr[i];
        }
        System.out.println("最大值为："+max);
        System.out.println("最小值为："+min);
        //总分-最大值-量最小值，求选手最终平均分
        System.out.println("总分为："+sum);
        System.out.println("选手最终得分为："+(sum-max-min)/3);
    }

}
