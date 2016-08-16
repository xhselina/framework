package org.china.framework.spring.sort;

import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/25 10:16.
 */
public class FastSortClient {

    public static void main(String[] args) {
        int num = 5000000;
        Integer[] source = initData(num);
        List result = new ArrayList<>();
        Long start = System.currentTimeMillis();
        sort(source,result);
        Long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");

        start = System.currentTimeMillis();
        Arrays.sort(source);
        end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
//        System.out.println(Arrays.toString(source));
    }

    private static Integer[] initData(int seed){
        Integer [] source = new Integer[seed];
        for (int i=0; i<seed; i++){
            source[i] = new Random().nextInt(seed);
        }
//        System.out.println(Arrays.toString(source) + "========" + source.length);
        return  source;
    }

    private static void sort(Object[] source,List result){
        List minList = new ArrayList<>();
        List maxList = new ArrayList<>();
        // 取第一个值为种子值
        for (int i=1; i< source.length; i++){

            if ((int)source[0] >= (int)source[i]){
                minList.add(source[i]);
            } else {
                maxList.add(source[i]);
            }
        }
//        //把种子值 放在小的数组中
//        minList.add(source[0]);
        maxList.add(source[0]);
        loopMinSort(minList.toArray(),result);
        loopMaxSort(maxList.toArray(),result);
    }

    private static void loopMinSort(Object[] min,List result){
        if (min.length > 1){ // 循环最小的数组
          sort(min,result);
        } else if(min.length == 1){
            result.add(min[0]);
        }
    }

    private static void loopMaxSort(Object[] max,List result){
        if (max.length > 1){ // 循环最小的数组
            sort(max,result);
        } else if(max.length == 1){
            result.add(max[0]);
        }
    }

    static void quicksort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
    }

    static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
