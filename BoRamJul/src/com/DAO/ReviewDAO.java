package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import com.DTO.memberDTO;
import com.vo.TBookDTO;

public class ReviewDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	int cnt = 0;
	

	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524";
			String dbid = "cgi_7_2_1216";
			String dbpw = "smhrd2";

			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ReviewDAO(String book_title, String mb_id, String review_content, double star_point, String tag1, String tag2, String tag3) {
				
			try {
				getConn();
				
				if (conn != null) {
				} else {
				}
				
				String sql = "insert into t_review("
						+ "book_title, "
						+ "review_content, "
						+ "review_star, "
						+ "review_date, "
						+ "mb_id, "
						+ "review_tag1, "
						+ "review_tag2, "
						+ "review_tag3"
						+ ") values(?,?,?,sysdate,?,?,?,?)";
	
				cnt = psmt.executeUpdate();
				
				psmt.setString(1,book_title);
				psmt.setString(2,mb_id);
				psmt.setString(3,review_content);
				psmt.setDouble(4,star_point);
				psmt.setString(5,tag1);
				psmt.setString(6,tag2);
				psmt.setString(7,tag3);
	
			} catch (Exception e) {
				e.printStackTrace();
	
			} finally {
				close();
			}
			
		}
			
}