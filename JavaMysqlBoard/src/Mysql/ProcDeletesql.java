package Mysql;

import Util.Util;

public class ProcDeletesql {
	
	static void run() {
		
		System.out.println("삭제할 글 번호를 입력하세요.");
	
		String num = Util.sc.next();
		
		Util.dbExecuteUpdate("delete from board where num="+num);
		
		System.out.println(num + "번 게시글이 삭제되었습니다.");
	}

}
