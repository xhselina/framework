package org.framework.model;

import java.io.Serializable;

/**
 * Created by junhuiji on 2016/1/7.
 */
public class BaseModel implements Serializable {
    /**
     * 排序字段
     */
    private String sortColumns;

    public String getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(String sortColumns) {
        this.sortColumns = sortColumns;
    }
}
