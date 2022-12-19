package Mysql;

import Util.Ctx;

public class Display {
	
	final static int DPNUM = 60;
	
	static private String TITLE = "게시판"; 
	static private String LISTTITLE = "글번호	ID	제목			조회수"; 
	static private String REPLYTITLE = "Reply ID	내용";
	
	static public void showTitle() {
		dotT();
		space(30);
		System.out.println(TITLE);
		dotT();
	}
	
	static private String MAIN_MENU = "[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [6]검색 [e]종료";
	static private String REPLY_MENU = "[r]리플입력 [e]뒤로";
	
	public static void Line() {
		for(int i=0;i<DPNUM;i++) {
			Ctx.w("-");
		}
		Ctx.wn("");
	}
	
	public static void dotT() {
		for(int i=0;i<DPNUM;i++) {
			Ctx.w("=");
		}
		Ctx.wn("");
	}
	
	public static void space(int c) {
		for(int i=0;i<c;i++) {
			Ctx.w(" ");
		}
	}
	
	static public void showMainMenu() {
		Line();
		space(2);
		Ctx.wn(MAIN_MENU);
		Line();	
	}
	
	static public void showReplyMenu() {
		Line();
		space(14);
		Ctx.wn(REPLY_MENU);
		Line();	
	}
	
	static public void showListTitle () {
		Ctx.wn(LISTTITLE);
	}
	static public void showReplyTitle () {
		Ctx.wn(REPLYTITLE);
	}
}
