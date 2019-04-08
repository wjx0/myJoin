package myJoin.common.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
/**
 * 分页工具类
 * @author user
 *
 */
public class Pager<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179175020059291893L;

	private List<T> resultList = Collections.emptyList();;

	public final static String DIRECTION_DESC = "DESC";
	public final static String DIRECTION_ASC = "ASC";

	/** 当前页，真实页数，取值：1、2、3.... */
	private int page = 1;

	/** 记录开始的rowNum，从零开始*/
	private int start;

	/** 每页显示数量limit */
	private int rows = 10;

	/** 排序asc,desc */
	private String sort;

	/** 排序字段 */
	private String sidx;

	private long totalCount;
	
	private long totalPage;
	/** 查询实体*/
	private T t;
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	final public long getTotalCount() {
		return totalCount;
	}

	final public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	final public void calStart() {
		if (start >= totalCount) {
			start = ((int) ((totalCount - 1) / rows)) * rows;
		}
	}

	final public int getPgNumber() {
		return start / rows + 1;
	}

	final public int getEnd() {
		return this.start + this.rows;
	}

	final public int getStart() {
		return start;
	}

	final public void setStart(int start) {
		this.start = start;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
		this.start = (page - 1) * rows;
	}

	final public String getSort() {
		return sort;
	}

	final public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public int getPage() {
		return start / rows;
	}

	public void setPage(int page) {
		if (page < 1) {
			page = 1;
		}
		this.page = page;
		this.start = (page - 1) * rows;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public long getTotalPage() {
		if (totalCount <= rows) {
			return 1;
		} else {
			return ((int) (totalCount % rows)) != 0 ? ((int) (totalCount / rows)) + 1
				: ((int) (totalCount / rows));
		}
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	
	
}
