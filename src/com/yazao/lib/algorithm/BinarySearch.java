package com.yazao.lib.algorithm;

/**
 * 二分查找算法
 */
public class BinarySearch {

    //**************************** 二分查找 -- 递归解法 ******************************

    /**
     * 递归二分查找
     *
     * @param arr    有序数据源
     * @param target 目标数据
     * @param low    起始位置角标
     * @param high   终点位置角标
     * @return 如果找到目标数据，返回对应的角标；否则返回 -1
     */
    public int binarySearchByRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[middle] > target) {
            return binarySearchByRecursive(arr, target, low, middle - 1);
        } else {
            return binarySearchByRecursive(arr, target, middle + 1, high);

        }
    }

    //**************************** 二分查找 -- while循环 ******************************

    /**
     * while二分查找
     *
     * @param arr    有序数据源
     * @param target 目标数据
     * @param low    起始位置角标
     * @param high   终点位置角标
     * @return 如果找到目标数据，返回对应的角标；否则返回 -1
     */
    public int binarySearchByWhile(int[] arr, int target, int low, int high) {

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (arr[middle] == target) {
                return middle;
            }

            if (arr[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    //**************************** main ******************************
    public static void main(String[] args) {
        //例题：假设我们要从一个排好序的数组里 {1, 3, 4, 6, 7, 8, 10, 13, 14} 查看一下数字 7 是否在里面，如果在，返回它的下标，否则返回 -1。

        int[] arr = {1, 3, 4, 6, 7, 8, 10, 13, 14};
        int target = 7;
        int low = 0;
        int high = arr.length - 1;

        // 递归解法
        int position = BinarySearch.getInstance().binarySearchByRecursive(arr, target, low, high);
        System.out.println("position = " + position);

        position = BinarySearch.getInstance().binarySearchByWhile(arr, target, low, high);
        System.out.println("position = " + position);
    }

    //**************************** 单例 ******************************
    private BinarySearch() {
    }

    public static BinarySearch getInstance() {
        return SingleInstance.instance;
    }

    private static class SingleInstance {
        private final static BinarySearch instance = new BinarySearch();
    }

}
