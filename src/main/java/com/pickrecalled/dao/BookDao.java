package com.pickrecalled.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	/**
	 * 默认lable为1说明是通过BookServiceImpl使用 lable为2说明是@Bean方式加入到容器的组件
	 */
	private String lable = "1";

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("BookDao{");
		sb.append("lable='").append(lable).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
