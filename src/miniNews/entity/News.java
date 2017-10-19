package miniNews.entity;

import java.util.Date;

/**
 * javaBean 分为：实体Bean 、 业务Bean 此类是实体Bean： 规范:1、无参构造方法 2、属性私有化
 * 3、提供私有属性的getXx()和setXx()
 * 
 * @author Administrator
 *
 */
public class News {

	private Integer nid;
	private Integer ntid;
	private String ntitle;
	private String nauthor;
	private Date ncreateDate;
	private String npicpath;
	private String ncontent;
	private Date nmodifyDate;
	private String nsummary;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public Integer getNtid() {
		return ntid;
	}
	public void setNtid(Integer ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getNcreateDate() {
		return ncreateDate;
	}
	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}
	public String getNpicpath() {
		return npicpath;
	}
	public void setNpicpath(String npicpath) {
		this.npicpath = npicpath;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNmodifyDate() {
		return nmodifyDate;
	}
	public void setNmodifyDate(Date nmodifyDate) {
		this.nmodifyDate = nmodifyDate;
	}
	public String getNsummary() {
		return nsummary;
	}
	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}
	
	
}
