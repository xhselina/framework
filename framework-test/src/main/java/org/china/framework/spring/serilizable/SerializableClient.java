package org.china.framework.spring.serilizable;

import java.io.*;
import java.util.Date;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/23 9:52.
 */
public class SerializableClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path="F:\\JGS\\secret\\WorkSpace\\framework\\framework-test\\src\\main\\java\\org\\china\\framework\\spring\\serilizable\\student.txt";
        Student student = new Student(1l,true,new Date());
        student.setName("lucy");
        student.setAge(30);
        student.setPhone("18500237786");
        System.out.println(student);
        System.out.println(student.TEST);

        //序列化
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(path)));
        outputStream.writeObject(student);
        System.out.println("student类序列化成功");
        outputStream.close();

        Student.TEST="testtest";

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Student stu = (Student) inputStream.readObject();
        System.out.println(stu);
        System.out.println(stu.getPhone() + "==============");
        System.out.println(stu.TEST);
        System.out.println("student反序列化成功");
    }
}
