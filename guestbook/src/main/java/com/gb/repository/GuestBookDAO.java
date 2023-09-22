package com.gb.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gb.exception.GlobalExceptionHandler;
import com.gb.exception.GuestBookException;
import com.gb.vo.GuestBookVO;

@Repository
public class GuestBookDAO {
//	private Connection getConnection() throws SQLException {
//		Connection conn = null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			String url = "jdbc:mysql://localhost/test";
//			conn = DriverManager.getConnection(url, "test", "test");
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			System.out.println(" 드라이버 로딩 실패");
//		}
//		
//		return conn;
//	}
	
	// 커넥션 풀 이용
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSession sqlSession;
	
	// 방명록 게시글 리스트를 조회하는 메서드
	public List<GuestBookVO> getList() {
		List<GuestBookVO> list = sqlSession.selectList("guestbook.getList");
		return list;
	}
	
	public String getPwd(Integer no) throws GuestBookException{
		String pwd = sqlSession.selectOne("guestbook.getOriginPwd", no);
		return pwd;
	}
	
	public String getInputPwd(String pwd) throws GuestBookException{
		String parsePwd = sqlSession.selectOne("guestbook.getInputPwd", pwd);
		return parsePwd;
	}
	
	public boolean insert(GuestBookVO vo) throws GuestBookException{
		int count = sqlSession.insert("guestbook.insert", vo);
		return count == 1;
	}
	
	public boolean delete(Integer no) throws GuestBookException{
		int count = sqlSession.delete("guestbook.delete", no);
		return count == 1;
	}
	
//	// 게시글을 등록하는 메서드
//	public boolean insert(GuestBookVO vo) {
//		boolean result = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			
//			// password(?)로 진행했을 때 에러 발생
//			String sql = "INSERT INTO guestbook VALUES (null, ?, ?, ?, (SELECT SYSDATE()) )";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getPwd());
//			pstmt.setString(3, vo.getContent());
//			int count = pstmt.executeUpdate();
//			
//			result = (count == 1);
//		} catch (SQLException e) {
//			// TODO: handle exception
////			e.printStackTrace();
//			throw new GlobalExceptionHandler();
//		}
//		
//		return result;
//	}
//	
//	// 게시글 삭제를 위해 게시글에 설정된 비밀번호를 조회하는 메서드
//	public String getPwd(int no) {
//		String pwd = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			
//			String sql = "SELECT pwd FROM guestbook WHERE no=?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, no);
//			rs = pstmt.executeQuery();
//			
//			// 조회되는 데이터가 1개여도 rs.next() 메서드를 호출히야 함.
//			if(rs.next()) {
//				pwd = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return pwd;
//	}
//	
//	// 게시글 삭제를 위해 삭제하려는 사용자가 입력한 비밀번호를 MySQL에서 암호화해서 조회하는 메서드
//	public String getInputPwd(String pwd) {
//		String parsePwd = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			
//			String sql = "SELECT ?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, pwd);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				parsePwd = rs.getString(1);
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return parsePwd;
//	}
//	
//	// 게시글을 삭제하는 메서드
//	public boolean delete(int no) {
//		boolean result = false;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			
//			String sql = "DELETE FROM guestbook WHERE no=?";
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setInt(1, no);
//			int count = pstmt.executeUpdate();
//			
//			result = (count == 1);
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
}
