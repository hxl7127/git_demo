package miniNews.entity;

import java.util.List;

/**
 * ��װ��ҳ�������
 * 
 * @author Administrator
 *
 */
public class Page<T> {
	private int pageIndex;// ��ǰҳ��
	private int pageSize;// ҳ��С
	private int count;// �ܼ�¼��
	private int pageTotal;// ��ҳ��
	private List<T> pageList;// ��ǰҳ������

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
	 * �����ܼ�¼��ʱ��ͬʱ�õ���ҳ��
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
