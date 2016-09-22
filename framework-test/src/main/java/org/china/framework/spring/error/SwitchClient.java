package org.china.framework.spring.error;

/**
 * String long 不可以成为switch（i） i的值
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/22 14:09.
 */
public class SwitchClient {
    public static void main(String[] args) {
        boolean flag = true;
        String str ;

        int i = 10;
        switch (i) {
            case 1: str = "true";    break;
            case 2: str = "2"; break;
            case 10:str = "10"; break;
            default:str="default";
        }

        System.out.println(str);



    }
}
