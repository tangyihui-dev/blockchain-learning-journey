package com.yihui.Algorithm;
//中位数
//给定两个正序数组 arr1和 arr2，请先合并数组，并找出合并之后数组的中位数。举例：
//        1 2 3 4 5 6 7 8 9
//        1 2 3 4 5 6
//中位数：5
//中位数： (3+4) 12
public class Median {
    public static void main(String[] args) {
        //创建两个正序数组
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        //合并两个数组
        int[] arr = new int[arr1.length + arr2.length];
        //定义两个指针分别查询两个数组
        int a = 0;
        int b = 0;
        //创建for循环将两个数组合并到arr数组中
        for (int i = 0; i < arr.length; i++) {
            if(a<arr2.length) {
                if (arr2[a] < arr1[b]) {
                    arr[i] = arr2[a];
                    a++;
                } else {
                    arr[i] = arr1[b];
                    b++;
                }
            }else if(b<arr1.length){
                arr[i] = arr1[b];
                b++;
            }
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("中位数："+arr[arr.length/2+1]);
    }
}
