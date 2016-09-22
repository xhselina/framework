package org.china.framework.spring.error;

/**
 * 当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf，如果看看valueOf的源代码就知道发生了什么。
 * 当值在-128-127时，Integer是从数据缓存池中去的值，其他值是新new的
 * 简单的说，如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，所以上面的面试题中f1==f2的结果是true，而f3==f4的结果是false。
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/22 13:56.
 */
public class IntegerClient {
    public static void main(String[] args) {
        Integer i=100,j=100,a=-129,b=-129;
        System.out.println(i == j);
        System.out.println(a == b);
        System.out.println(i.equals(j));
        System.out.println(a.equals(b));
    }
}
