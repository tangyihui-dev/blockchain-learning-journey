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
//一等奖:5+2
//二等奖:5+1
//三等奖:5+0/4+2
//四等奖:4+1/3+2
//五等奖:4+0/3+1/2+2
//六等奖:3+0/1+2/2+1/0+2
public class Super_Lotto {
    public static void main(String[] args) {
        // 1. 调用random方法生成随机数，生成真实彩票号码
        int[] arr = creatlettonnumber();
        System.out.println(); // 换行，使输出更清晰
        
        // 2. 调用scanner方法接收用户输入的彩票号码
        int[] input = inputlettonnumber();
        
        // 3. 判断是否中奖
        winner(arr, input);
    }

    /**
     * 判断中奖等级
     * @param arr1 系统生成的彩票号码数组（前5个是前区，后2个是后区）
     * @param arr2 用户输入的彩票号码数组（前5个是前区，后2个是后区）
     */
    public static void winner(int[] arr1, int[] arr2) {
        // 统计前区和中号码数量（比较前5个号码）
        int count1 = countFrontMatches(arr1, arr2);
        // 统计后区和中号码数量（比较后2个号码）
        int count2 = countBackMatches(arr1, arr2);
        
        System.out.println("\n===== 开奖结果 =====");
        System.out.println("前区匹配: " + count1 + " 个，后区匹配: " + count2 + " 个");
        
        // 根据大乐透规则判断中奖等级
        if (count1 == 5 && count2 == 2) {
            System.out.println("恭喜你中一等奖！");
        } else if (count1 == 5 && count2 == 1) {
            System.out.println("恭喜你中二等奖！");
        } else if ((count1 == 5 && count2 == 0) || (count1 == 4 && count2 == 2)) {
            System.out.println("恭喜你中三等奖！");
        } else if ((count1 == 4 && count2 == 1) || (count1 == 3 && count2 == 2)) {
            System.out.println("恭喜你中四等奖！");
        } else if ((count1 == 4 && count2 == 0) || (count1 == 3 && count2 == 1) || (count1 == 2 && count2 == 2)) {
            System.out.println("恭喜你中五等奖！");
        } else if ((count1 == 3 && count2 == 0) || (count1 == 2 && count2 == 1) || (count1 == 1 && count2 == 2) || (count1 == 0 && count2 == 2)) {
            System.out.println("恭喜你中六等奖！");
        } else {
            System.out.println("很遗憾，未中奖！再接再厉！");
        }
    }

    /**
     * 统计前区匹配的号码数量
     * @param arr1 系统生成的号码数组
     * @param arr2 用户输入的号码数组
     * @return 前区匹配的号码数量
     */
    public static int countFrontMatches(int[] arr1, int[] arr2) {
        int count = 0;
        // 遍历前区的5个号码（索引0-4）
        for (int i = 0; i < 5; i++) {
            // 在用户输入的前区号码中查找匹配的号码
            for (int j = 0; j < 5; j++) {
                if (arr1[i] == arr2[j]) {
                    count++;
                    break; // 找到匹配后跳出内层循环，避免重复计数
                }
            }
        }
        return count;
    }
    
    /**
     * 统计后区匹配的号码数量
     * @param arr1 系统生成的号码数组
     * @param arr2 用户输入的号码数组
     * @return 后区匹配的号码数量
     */
    public static int countBackMatches(int[] arr1, int[] arr2) {
        int count = 0;
        // 遍历后区的2个号码（索引5-6）
        for (int i = 5; i < 7; i++) {
            // 在用户输入的后区号码中查找匹配的号码
            for (int j = 5; j < 7; j++) {
                if (arr1[i] == arr2[j]) {
                    count++;
                    break; // 找到匹配后跳出内层循环，避免重复计数
                }
            }
        }
        return count;
    }

    /**
     * 接收用户输入的彩票号码（指定范围）
     * @param arr 存储号码的数组
     * @param start 起始索引（包含）
     * @param end 结束索引（不包含）
     * @return 填充好的数组
     */
    public static int[] inputlettonnumbers(int[] arr, int start, int end) {
        Scanner sc = new Scanner(System.in);
        boolean isDuplicate; // 标记号码是否重复
        
        for (int i = start; i < end; ) {
            int number = sc.nextInt();
            
            // 验证号码范围：前区1-35，后区1-12
            boolean isValidRange;
            if (start == 0) {
                // 前区号码范围：1-35
                isValidRange = (number >= 1 && number <= 35);
            } else {
                // 后区号码范围：1-12
                isValidRange = (number >= 1 && number <= 12);
            }
            
            if (!isValidRange) {
                System.out.print("号码超出范围，请重新输入：");
                continue;
            }
            
            // 检查号码是否重复
            isDuplicate = checknumber(number, arr, start, i);
            if (!isDuplicate) {
                arr[i] = number; // 保存号码
                i++; // 移动到下一个位置
            } else {
                System.out.print("号码重复，请重新输入：");
            }
        }
        return arr;
    }

    /**
     * 接收用户输入的完整彩票号码（前区5个 + 后区2个）
     * @return 包含7个号码的数组
     */
    public static int[] inputlettonnumber() {
        int[] arr = new int[7];
        
        // 接收前区5个号码（索引0-4）
        System.out.print("请输入前区5个号码（1-35，用空格分隔）：");
        arr = inputlettonnumbers(arr, 0, 5);
        
        // 接收后区2个号码（索引5-6）
        System.out.print("请输入后区2个号码（1-12，用空格分隔）：");
        arr = inputlettonnumbers(arr, 5, 7);
        
        return arr;
    }

    /**
     * 随机生成一注大乐透号码
     * @return 包含7个号码的数组（前5个是前区，后2个是后区）
     */
    public static int[] creatlettonnumber() {
        Random r = new Random();
        // 创建一个数组保存彩票号码（前5个是前区，后2个是后区）
        int arr[] = new int[7];
        
        // 生成前区的5个号码（范围1-35，不可重复）
        System.out.print("系统生成的前区号码：");
        for (int i = 0; i < 5; ) {
            arr[i] = r.nextInt(1, 36); // 生成1-35的随机数
            int number = arr[i];
            // 检查号码是否重复
            boolean isDuplicate = checknumber(number, arr, 0, i);
            if (!isDuplicate) {
                i++;
                System.out.print(number + " ");
            }
        }
        
        // 生成后区的2个号码（范围1-12，不可重复）
        System.out.print("\n系统生成的后区号码：");
        for (int i = 5; i < 7; ) {
            arr[i] = r.nextInt(1, 13); // 生成1-12的随机数
            int number = arr[i];
            // 检查号码是否重复
            boolean isDuplicate = checknumber(number, arr, 5, i);
            if (!isDuplicate) {
                i++;
                System.out.print(number + " ");
            }
        }
        
        return arr;
    }

    /**
     * 检查号码在指定范围内是否重复
     * @param number 要检查的号码
     * @param arr 号码数组
     * @param start 检查范围的起始索引（包含）
     * @param end 检查范围的结束索引（不包含）
     * @return true表示重复，false表示不重复
     */
    public static boolean checknumber(int number, int[] arr, int start, int end) {
        // 遍历指定范围内的号码
        for (int i = start; i < end; i++) {
            if (number == arr[i]) {
                return true; // 发现重复，立即返回
            }
        }
        return false; // 没有发现重复
    }
}
