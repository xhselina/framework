package org.china.framework.spring.pattern.factory.abstractfactory;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/5/9 13:19.
 */
public class ProductFactory {

    public static <T extends  Product> T createProduct(Class<T> cls){
        Product product = null;
        try {
            product = (Product)Class.forName(cls.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
