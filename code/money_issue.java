package com.yihui.Algorithm;
import java.util.Random;
import java.util.Scanner;

//红包问题
//给你两个整数M和N，M表示红包的总额，N表示红包的个数
//现在又N个人来抽红包，每个人都是随机的，打印每个人领的红包金额
public class money_issue {
    public static void main(String[] args) {
        //定义一个变量用来从键盘接收输入的红包数额（使用double支持小数）
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入红包的总数额：");
        double m = sc.nextDouble();
        //定义一个变量用来保存红包的个数
        System.out.print("请输入红包的个数：");
        int n = sc.nextInt();
        //有n个人来抽取红包，红包金额随机，创建一个随机数
        Random r = new Random();
        //定义一个数组来保存每次抽中的红包金额（使用double存储小数金额）
        double[] arr = new double[n];
        //记录已分配的红包总金额
        double distributed = 0;
        //for循环为前n-1个人随机分配红包金额
        for (int i = 0; i < n - 1; i++) {
            //计算当前可分配的最大金额 = 总金额 - 已分配金额 - 后续每人至少0.01元
            double maxAmount = m - distributed - 0.01 * (n - i - 1);
            
            //生成0.01到maxAmount之间的随机金额（单位：元）
            //先转换为分（整数），再生成随机数，最后转回元，确保两位小数
            int minCents = 1; // 最小1分（0.01元）
            int maxCents = (int) (maxAmount * 100); // 最大金额转换为分
            
            //生成[minCents, maxCents]范围内的随机整数（单位：分）
            int randomCents = r.nextInt(minCents, maxCents + 1);
            
            //将分转换为元，保留两位小数
            arr[i] = randomCents / 100.0;
            
            //累加已分配的金额
            distributed += arr[i];
            
            //格式化输出红包金额，保留两位小数
            System.out.println("第" + (i + 1) + "个人抢到红包：" + String.format("%.2f", arr[i]));
        }
        
        //最后一个人获得剩余的所有金额，确保总和等于M
        arr[n - 1] = m - distributed;
        System.out.println("第" + n + "个人抢到红包：" + String.format("%.2f", arr[n - 1]));
    }
}
