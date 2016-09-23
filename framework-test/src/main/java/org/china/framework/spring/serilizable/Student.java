package org.china.framework.spring.serilizable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @version Ver 1.0
 * @Author <a href="mailto:jeffreyji@yeah.net">jeffrey</a>
 * @Date 2016/9/23 9:48.
 */
public class Student extends Persion implements Serializable{

    private static final long serialVersionUID = -5809782578272943999L;

    public static String TEST="TEST";
    private long id;
    private boolean sex;
    private Date birthday;
    private String phone;

    public Student(long id, boolean sex, Date birthday) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField putField = out.putFields();
        System.out.println("原来的手机号是:" + phone);
        phone += 12345;
        putField.put("phone",phone );
        System.out.println("加密后的手机号是:" + phone );
        out.writeFields();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField getField = in.readFields();
        Object obj = getField.get("phone","");
        System.out.println("取到的手机号是:" + obj.toString());
        phone= "18500237786";
    }

}
