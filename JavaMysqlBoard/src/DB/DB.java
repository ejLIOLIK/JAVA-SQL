package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	public static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	public static int mountBoard = 0;
	
	public static void dbExecuteQuery(String query) {
		
		String str="";
		
		try {
			result = st.executeQuery(query);

			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				str += "글번호: " + result.getString("num") + "		";	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				str += "ID: " + result.getString("ID") + "	\n";	
				str += "글제목: " + result.getString("title") + "\n";
				str += "조회수: " + result.getString("hit") + "\n";
				str += result.getString("contents") + "	\n";	
				
				System.out.println(str);
	
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
		
		String str = "";
		
		try {
			result = st.executeQuery(query);
			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				str += result.getString("num") + "	";	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				str += result.getString("ID") + "	";	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				str += result.getString("title") + " [" + result.getString("replyCount") + "]		";	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)
				str += result.getString("hit") + "		";	// p_name 필드(열) 의 데이터 꺼내기(1개 꺼낸거에서)

				System.out.println(str);
				str = "";
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
	
	public static void dbexecuteQueryReply(String query) {
		
		String str="";
		
		try {
			result = st.executeQuery(query);

			while (result.next()) {	// 결과를 하나씩 빼기. 더 이상 없으면(행 수가 끝나면) false 리턴됨.
				str += result.getString("replyId") + "	: " + result.getString("replyText") ;
				System.out.println(str);
				
				str="";
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
	
	public static int countBoard() { // 게시글 총 수량 리턴 
		try {
			result = st.executeQuery("select count(*) from board;");
			if (result.next()) {
				return result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
