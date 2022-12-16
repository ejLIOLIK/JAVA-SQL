package Mysql;

import Util.Util;

public class ProcListsql {
	
	static void run() {
		
		System.out.println("글번호	ID	제목			조회수");
		Util.dbExecuteQueryList("select * from board");
		
	}

}
