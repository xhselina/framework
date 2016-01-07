package org.framework.demo.model;

import org.framework.model.BaseModel;

/**
 * Created by junhuiji on 2016/1/7.
 */
public class User extends BaseModel {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
