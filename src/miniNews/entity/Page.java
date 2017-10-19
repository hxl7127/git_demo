package miniNews.entity;

import java.util.List;

/**
 * 封装分页相关数据
 * 
 * @author Administrator
 *
 */
public class Page<T> {
	private int pageIndex;// 当前页码
	private int pageSize;// 页大小
	private int count;// 总记录数
	private int pageTotal;// 总页数
	private List<T> pageList;// 当前页面结果集

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	/**
	 * 设置总记录数时，同时得到总页数
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
		if (this.pageSize != 0) {
			this.setPageTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		}

	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

}
