package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Util.Cet;
import Util.Ctx;

public class DB {
	
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	
	public static void dbExecuteQuery(String query) {
		
		try {
			result = st.executeQuery(query);

			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
			
				Ctx.w("글번호: " + result.getString("num") + "		");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				Ctx.wn("ID: " + result.getString("ID") + "	");	
				Ctx.wn("글제목: " + result.getString("title"));
				Ctx.wn("조회수: " + result.getString("hit"));
				Ctx.wn(result.getString("contents"));	
				
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	public static void dbInit() {
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = DB.con.createStatement();	// Statement는 정적 SQL문을 실행하고 결과를 반환받기 위한 객체다. Statement하나당 한개의 ResultSet 객체만을 열 수있다.
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	public static void dbExecuteQueryList(String query) {
		
		try {
			result = st.executeQuery(query);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				
				Ctx.w(result.getString("num") + "	");	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				Ctx.w(result.getString("ID") + "	");	
				Ctx.w(result.getString("title") + " [" + result.getString("replyCount") + "]		");	
				Ctx.wn(result.getString("hit") + "		");	
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	public static void dbexecuteQueryReply(String query) {
		
		try {
			result = st.executeQuery(query);

			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				Ctx.wn(result.getString("replyId") + "	: " + result.getString("replyText"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	
	public static void dbExecuteUpdate(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int countBoard(String query) { // 게시글 총 수량 리턴 
		
		int mount = 0;
		
		try {
			result = st.executeQuery(query);
			result.next();			
			String count = result.getString("count(*)");
			mount = Cet.intToString(count);
			
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
		
		return mount;
	}

}
