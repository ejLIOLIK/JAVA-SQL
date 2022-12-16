package Mysql;

public class Display {
	static private String TITLE_BAR = "================================================================"; 
	static private String TITLE 	= "-------------------------     게시판     -------------------------"; 
	
	static public void showTitle() {
		System.out.println(TITLE_BAR);
		System.out.println(TITLE);
		System.out.println(TITLE_BAR);
	}
	
	static private String MAIN_MENU_BAR = "------------------------------------------------------------";
	static private String MAIN_MENU	 	= "    [1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정 [e]종료";
	
	static public void showMainMenu() {
		System.out.println(MAIN_MENU_BAR);
		System.out.println(MAIN_MENU);
		System.out.println(MAIN_MENU_BAR);	
	}
	
	public static void Line() {
		System.out.println(MAIN_MENU_BAR);
	}
}
