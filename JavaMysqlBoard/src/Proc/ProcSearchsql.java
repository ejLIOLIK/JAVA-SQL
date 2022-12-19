package Proc;

import DB.DB;
import Util.Csc;
import Util.Ctx;

public class ProcSearchsql {
	
	final static int PAGE = 5;
	
	static void run() {
		
		String str="";
		
		Ctx.wn("검색어를 입력하세요.");
		str = Csc.readlong();

		int mount = DB.countBoard("select count(*) from board where title like '%"+ str +"%'");
		
		str = "select * from board where title like '%"+ str +"%' ";
		ProcListsql.printList(str, mount);
	}
}
