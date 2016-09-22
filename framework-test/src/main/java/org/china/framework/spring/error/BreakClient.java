package org.china.framework.spring.error;

/**
 * break 只能跳出当前循环
 * break + lable 可以跳出多层循环
 * continue 同理
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/22 14:24.
 */
public class BreakClient {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("运行第一重循环" + i);
            for (int j = 0; j < 2; j++) {
                System.out.println("运行第二重循环" + j);
                for (int k = 0; k < 2; k++) {
                    if(k==1){
                        break;
                    }
                    System.out.println("运行第三重循环" + k);
                    System.out.println("******************************");

                }
            }
        }
        System.out.println("=========================================================================");

       label: for (int i = 0; i < 2; i++) {
            System.out.println("运行第一重循环" + i);
            for (int j = 0; j < 2; j++) {
                System.out.println("运行第二重循环" + j);
                for (int k = 0; k < 2; k++) {
                    if(k==1){
                        System.out.println("跳出多层循环:");
                        break label;
                    }
                    System.out.println("运行第三重循环" + k);
                    System.out.println("******************************");

                }
            }
        }
    }
}
