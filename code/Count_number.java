package com.yihui.Algorithm;

import java.util.Random;
import java.util.Scanner;

//统计个数
//学校选举学生会主席，有5个候选人
//全校1000名同学参与投票（每人一票，可以弃权，或者选1-5号)。
//投票使用Random模拟。0：弃权，1~5：给对应的候选人投票
//要求1:
//统计每个候选人的得票数和得票率，找出得票最多的候选人?
//要求2:
//统计弃票数和弃票率是多少?
public class Count_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //定义一个随机数
        Random r = new Random();
        //定义一个变量保存弃票总数
        int count = 0;
        //从键盘录入投票数
        System.out.print("请输入投票数：");
        int n = sc.nextInt();
        float rate = n;
        //定义一个数组保存每个候选人的得票数
        int[] arr = new int[5];
        for (int i = 0; i < n; i++) {
            int a=r.nextInt(0,6);
            switch ( a) {
                case 0:
                    //弃权
                    count++;
                    break;
                case 1:
                    //给1号投票
                    arr[0]++;
                    break;
                case 2:
                    //给2号投票
                    arr[1]++;
                    break;
                case 3:
                    //给3号投票
                    arr[2]++;
                    break;
                case 4:
                    //给4号投票
                    arr[3]++;
                    break;
                case 5:
                    //给5号投票
                    arr[4]++;
                    break;
                default:
                    break;
            }
        }
        //定义一个变量保存获胜者
        int winner = arr[0];
        int index = 1;  // 默认1号候选人获胜
        for (int i = 0; i < 5; i++) {
            System.out.printf("第%d个候选人的得票数是：%d，得票率是：%.2f%%\n", (i+1), arr[i], (arr[i]/rate*100));
            if(winner < arr[i]){
                winner = arr[i];
                index = i+1;
            }
        }
        System.out.printf("得票最多的候选人是：%d号\n", index);
        System.out.printf("弃票数是：%d\n", count);
        System.out.printf("弃票率是：%.2f%%\n", count/rate*100);
    }
}
