package com.example.spring07.model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

/*
 * 	final field에 DataSource type을 선언하고
 * 	Contstructor Injection DI를 통해 DBCP를 스프링 컨테이너로부터 주입 받는다
 */
@Repository
public class ItemDao {
	private final DataSource dataSource;
	
	public ItemDao(DataSource dataSource) {
		System.out.println(getClass() + " 생성자 실행 -> 객체 생성");
		this.dataSource = dataSource;
	}

	public String findItemById(String id) throws SQLException {	// 실제 db 연동 안함
		Connection con = dataSource.getConnection();	// DBCP로부터 빌려온다
		System.out.println(con.getClass());	// dbcp로부터 빌려 온 커넥션 확인
		
		con.close();//DBCP에 반납
		return id + " 아이템 정보";
	}
}
