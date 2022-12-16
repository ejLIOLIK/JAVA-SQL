package Mysql;

import Util.Util;

public class ProcReadsql {

	static void run() {
		
		System.out.println("읽을 글 번호를 입력하세요.");
		
		String num = Util.sc.next();
		
		Display.Line();
		Util.dbExecuteQuery("select * from board where num = " + num);
		Util.dbExecuteUpdate("update board set hit=hit+1 where num="+num); // 조회수 1 올려주기
		Display.Line();
		
		// 조회수 부분
		//update board set hit = 0;
		
	}
	
}
