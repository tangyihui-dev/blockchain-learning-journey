package com.yihui.Algorithm;

import java.util.Random;
import java.util.Scanner;

//大乐透选号规则明确规定:同一投注区内的号码不可重复，但不同投注区之间允许号码重复。
//具体规则可分为前区和后区两个维度:
//大乐透选号重复规则详解
//1.前区号码不可重复。
//        ·投注范围:从01-35中选择5个号码。
//规则要求:所选5个号码之间不可出现重复数字，如出现重复则该注视为无效投注。
//        .后区号码不可重复。
//投注范围:从01-12中选择2个号码。
//规则要求:所选2个号码之间不可重复，否则同样视为无效投注。
// 跨区重复规则。
//前区与后区号码允许交叉重复，例如前区选10，后区也可选10。
//系统自动判定:跨区重复不会触发错误提示，属于有效投注。
// 3玩法知识延伸
//基本结构:采用”5+2”双区投注模式，前区35选5与后区12选2组合形成完整投注号码。
//无效投注判定:同一区内重复号码在开奖前会被系统自动识别为无效票，无法参与兑奖。
//策略提醒:虽然跨区重复有效，但统计显示前区与后区号码重复概率仅3.8%，
//建议选号时优先考虑号码分布合理性。
public class Super_Lotto {
    public static void main(String[] args) {
        System.out.println("大乐透选号(从01-35中选择5个号码)：");
        Scanner sc = new Scanner(System.in);
        //定义一个数组保存这五个号码
        int[] arr = new int[5];
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入第"+(i+1)+"个数：");
            arr[i] = sc.nextInt();
            if(arr[i]<1||arr[i]>35){
                System.out.println("输入的数不在范围内，请重新输入：");
                i--;
            }
            for (int j = 0; j < i; j++) {
                if(arr[i]==arr[j]){
                    flag = true;
                }
            }
        }
        System.out.println("大乐透选号(从01-12中选择2个号码)：");
        int[] arr1 = new int[2];
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("请输入第"+(i+1)+"个数：");
            arr1[i] = sc.nextInt();
            if(arr1[i]<1||arr1[i]>12){
                System.out.println("输入的数不在范围内，请重新输入：");
                i--;
            }
            if(arr1[0]==arr1[1]){
                flag = true;
            }
        }
        //生成一个数组用来保存中奖号码
        int[] arr2 = new int[5];
        int[] arr3 = new int[2];
        Random r = new Random();
        for (int i = 0; i < arr2.length; i++) {
            int a = r.nextInt(1,36);
            arr2[i] = a;
            for (int j = 0; j < i; j++) {
                if(arr2[i]==arr2[j]){
                    i--;
                }
            }
        }
        for (int i = 0; i < arr3.length; i++) {
            int a = r.nextInt(1,13);
            arr3[i] = a;
            for (int j = 0; j < i; j++) {
                if(arr3[i]==arr3[j]){
                    i--;
                }
            }
        }
        System.out.print("前区号码：");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
        System.out.print("后区号码：");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        System.out.println(" ");
        if(flag){
            System.out.println("输入的号码有重复，无效票，无法兑奖！");
        }else {
            System.out.print("中奖号码：");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i]+" ");
            }
            System.out.println(" ");
            System.out.print("\t\t ");
            for (int i = 0; i < arr3.length; i++) {
                System.out.print(arr3[i]+" ");
            }
        }
    }
}
