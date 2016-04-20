package org.framework.model;

import java.io.Serializable;

/**
 * 基础model类
 */
public class BaseModel implements Serializable {
    /**
     * 排序字段
     */
    private String sortColumns;
    /**
     * 分表用
     */
    private String yyyymm;

    public String getYyyymm() {
        return yyyymm;
    }

    public void setYyyymm(String yyyymm) {
        this.yyyymm = yyyymm;
    }

    public String getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(String sortColumns) {
        this.sortColumns = sortColumns;
    }
}
