package org.china.framework.spring.test;

/**
 * ++操作符的作用
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/13 9:17.
 * @version Ver 1.0
 */
public class Client {
    public static void main(String[] args) {
        int count = 0;
        for(int i=0; i<10; i++){
            /**
             * 注意这里的执行步骤
             * 1 count在内存中的值是0
             * 2 count++是 先把count的值(0)赋值给count  然后count在+1
             * 3 所有count的值是0
             * 如果把count++ 修改为++count则会输出 1-10
             */
            count = count++;
            System.out.println(count);
        }

        Integer i = null;
        System.out.println(i.equals("2"));

        System.out.println(Constanct.AGE);

    }
}
