package Proc;

import DB.DB;
import Mysql.Display;
import Util.Csc;
import Util.Ctx;

public class ProcListsql {
	
	final static int PAGE = 5;
	
	static void run() {
		
		String str = "select * from board ";
		int mount = DB.countBoard("select count(*) from board;");
		printList(str, mount);
		
	} 
	
	static void printListPage(String query, int key, int mountPage) {
		
		Display.showListTitle();
		DB.dbExecuteQueryList(query); // 페이지 출력
		Display.Line();
		Ctx.wn("page" + (key) + "/" + mountPage);
	}
	
	static void printList(String str, int mount) {
		
		int key;
		int mountPage;
				
		if(mount%PAGE==0) {
			mountPage = mount/PAGE;
		}
		else {
			mountPage = mount/PAGE+1;
		}
		
		printListPage(str + "order by num desc limit 0,5;", 1, mountPage);

		while (true) {
			Display.Line();
			Ctx.wn("[1~" + mountPage + "] 해당 페이지로 이동 [0] 뒤로 ");
			String keyStr = Csc.readlong();
			key = Util.Cet.intToString(keyStr);
			
			if (key == 0) {
				break;
			} 
			else {
				if (key > mountPage) {
					Ctx.wn("해당 페이지가 없습니다.");
				} else {
					printListPage(str + "order by num desc limit " + ((key - 1) * PAGE) + "," + PAGE + ";"
							, key, mountPage);
				}
			}
			
		}
	}

}
