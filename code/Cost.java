package com.yihui.define;

import java.util.Scanner;

//某快递公司的运费规则如下(首重1kg，超出部分按kg计算，不足1kg按1kg算):首重1kg:10元;
//超出1-5kg:每kg加2元;超出5kg以上:每kg加1.5元。
//键盘录入小数，表示用户快递的重量，计算最终的结果
// 要求1:快递重量必须大于0，否则重新输入
//要求2:不同价位的计算，单独定义一个方法
public class Cost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //键盘录入小数，表示用户快递的重量
        System.out.println("请输入快递的重量：");
        double weight=0;
        while (true) {
            weight = sc.nextDouble();
            if (weight > 0) {
                break;
            } else {
                System.out.println("请输入正确的重量：");
                weight = sc.nextDouble();
            }
        }
        System.out.println("快递的运费为：" + getCost(weight));
    }
    public static double getCost(double weight){
        int cost = 0;
        if (weight <= 1){
            cost = 10;
        }else if (weight > 1 && weight <= 5){
            cost = (int)(10 + (weight - 1) * 2);
        }else {
            cost = (int)(10 + 8 * 2 + (weight - 5) * 1.5);
        }
        return cost;
    }
}
