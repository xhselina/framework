//package org.framework.model;
//
//import org.apache.commons.lang.builder.ToStringBuilder;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
///**
// * 所有实体类的基类
// *
// * @author Administrator
// *
// */
//@MappedSuperclass
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//public class BaseEntity implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	/**
//	 * 主键 id
//	 */
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id", nullable = false)
//	private long id;
//	/**
//	 * 创建人
//	 */
//	private String creator;
//	/**
//	 * 更新人
//	 */
//	private String updater;
//	/**
//	 * 创建时间
//	 */
//	private Date createDate;
//	/**
//	 * 更新时间
//	 */
//	private Date updateDate;
//	/**
//	 * 更新次数
//	 */
//	private int count;
//
//	/**
//	 * 构造函数
//	 */
//	public BaseEntity(){}
//
//	/**
//	 * 统一的toString方法
//	 */
//	public String toString(){
//		return ToStringBuilder.reflectionToString(this);
//	}
//
//	public String getCreator() {
//		return creator;
//	}
//
//	public void setCreator(String creator) {
//		this.creator = creator;
//	}
//
//	public String getUpdater() {
//		return updater;
//	}
//
//	public void setUpdater(String updater) {
//		this.updater = updater;
//	}
//
//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}
//
//	public Date getUpdateDate() {
//		return updateDate;
//	}
//
//	public void setUpdateDate(Date updateDate) {
//		this.updateDate = updateDate;
//	}
//
//	public int getCount() {
//		return count;
//	}
//
//	public void setCount(int count) {
//		this.count = count;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//}
