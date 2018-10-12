package com.pickrecalled.service.impl;

import com.pickrecalled.dao.BookDao;
import com.pickrecalled.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired(required = false)
	@Qualifier("bookDao")
	private BookDao bookDao;

	public void testGetBookDaoObject() {
		System.out.println("尝试获取BookDao对象：" + bookDao);
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("BookServiceImpl{");
		sb.append("bookDao=").append(bookDao);
		sb.append('}');
		return sb.toString();
	}
}
