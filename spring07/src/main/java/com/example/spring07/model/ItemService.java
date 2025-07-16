package com.example.spring07.model;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

/*
 * 	final field로 ItemDao 선언
 * 	Constructor Injection DI 
 */	
@Service
public class ItemService {
	private final ItemDao itemDao;
	public ItemService(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

//	public String findItemById(String id) throws SQLException {	
	public String findItemById(String id) throws SQLException {
		return itemDao.findItemById(id);
	}

	
}
