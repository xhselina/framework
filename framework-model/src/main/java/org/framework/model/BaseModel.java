package org.framework.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 基础model类
 * 添加统一输出toString
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

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this);
    }
}
