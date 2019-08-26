
package com.qc.common;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class BaseQueryResult<T> implements Serializable
{
	private PageInfo page;
	private List<T> list;

	public BaseQueryResult()
	{

	}

	public BaseQueryResult(List<T> list)
	{
		this(list, null);
	}

	public BaseQueryResult(List<T> list, PageInfo page)
	{
		this.page = page;
		this.list = list;
	}

	public PageInfo getPage()
	{
		return page;
	}

	public void setPage(PageInfo page)
	{
		this.page = page;
	}

	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}
}
