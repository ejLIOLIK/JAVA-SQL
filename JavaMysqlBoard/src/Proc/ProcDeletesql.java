package Proc;

import DB.DB;
import Util.Csc;
import Util.Ctx;

public class ProcDeletesql {
	
	static void run() {
		
		Ctx.wn("삭제할 글 번호를 입력하세요.");
	
		String num = Csc.readlong();
		
		DB.dbExecuteUpdate("delete from board where num="+num);
		DB.dbExecuteUpdate("delete from reply where replyNum="+num); // 리플 테이블도 삭제
		
		Ctx.wn(num + "번 게시글이 삭제되었습니다.");
	}

}
