package Proc;

import DB.DB;
import Mysql.Display;
import Util.ScanUtil;

public class ProcListsql {
	
	final static int PAGE = 5;
	
	static void run() {
		
		int key;
		int mountPage;
		
		if(DB.countBoard()%PAGE==0) {
			mountPage = DB.countBoard()/PAGE;}
		else {
			mountPage = DB.countBoard()/PAGE+1;
		}
		
		Display.Line();
		
		printList("select * from board order by num desc limit 0,5;", 1, mountPage);

		while (true) {
			Display.Line();
			System.out.println("[1~" + mountPage + "] 해당 페이지로 이동 [0] 뒤로 ");
			
			String keyStr = ScanUtil.readlong();
			key = Util.EctUtil.intToString(keyStr);
			
			if (key == 0) {
				break;
			} 
			else {
				if (key > mountPage) {
					System.out.println("해당 페이지가 없습니다.");
				} else {
					printList("select * from board order by num desc limit " + ((key - 1) * PAGE) + "," + PAGE + ";"
							, key, mountPage);
				}
			}
			
		}
	} 
	
	static void printList(String query, int key, int mountPage) {
		
		Display.showListTitle();
		DB.dbExecuteQueryList(query); // 첫 페이지 출력
		Display.Line();
		System.out.println("page" + (key) + "/" + mountPage);
	}

}
