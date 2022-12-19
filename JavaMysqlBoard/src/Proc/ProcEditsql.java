package Proc;

import DB.DB;
import Util.Csc;
import Util.Ctx;

public class ProcEditsql {
	
	static void run() {
		
		String tmp="";

		Ctx.wn("수정할 글 번호를 입력하세요.");
		String num = Csc.readlong();
		
		Ctx.wn("수정할 부분을 선택하세요.");
		Ctx.wn("[1]글제목 [2]글내용 [3]ID");
		String editStr = Csc.readlong();
		
		Ctx.wn("수정할 내용을 입력하세요.");		
				
		tmp = Csc.readlong();
		
		switch(editStr) {
		case "1": 
			DB.dbExecuteUpdate("update board set title='" + tmp + "' where num=" + num);
			break;
		case "2":
			DB.dbExecuteUpdate("update board set contents='" + tmp + "' where num=" + num);
			break;
		case "3":
			DB.dbExecuteUpdate("update board set ID='" + tmp + "' where num=" + num);
			break;
			default:
		}
				
		Ctx.wn(num + "번 게시글이 수정되었습니다.");
	}

}
