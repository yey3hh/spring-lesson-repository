package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

/*
 * 	final field로 DataSource를 선언, Constructor Injection
 * 	실제 DataSource를 이용해 spring_member table의 회원정보를 조회하여 회원 객체를 리턴
 */
@Repository
public class MemberDao {

    private final DataSource dataSource;
//  @Autowired 생략 가능
	public MemberDao(DataSource dataSource) {	// DI : Constructor Injection 된 것
		System.out.println(getClass() + " 생성자 실행 -> 객체 생성");
		this.dataSource = dataSource;
	}

	public MemberVo findMemberById(String id) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo vo = null;
		
		try {
			con = dataSource.getConnection();	// DataSource 타입의 DBCP 구현체로부터 커넥션을 빌려온다
			String sql = "SELECT id, password, name, address FROM spring_member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} 
					
		} finally {
			closeAll(rs, pstmt, con);
		} 
		return vo;
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null) 
			pstmt.close();
		if (con != null)
			con.close();
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null) 
			pstmt.close();
		if (con != null)
			con.close();	// 커넥션을 소멸시키는 것이 아니라 dbcp에 커넥션을 반납
		
	}

}
