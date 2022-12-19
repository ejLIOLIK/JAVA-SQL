package Proc;

import DB.DB;
import Util.ScanUtil;

public class ProcEditsql {
	
	static void run() {
		
		String tmp="";

		System.out.println("수정할 글 번호를 입력하세요.");
		String num = ScanUtil.read();
		
		System.out.println("수정할 부분을 선택하세요.");
		System.out.println("[1]글제목 [2]글내용 [3]ID");
		String editStr = ScanUtil.read();
		
		System.out.println("수정할 내용을 입력하세요.");		
				
		tmp = ScanUtil.readlong();
		
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
				
		System.out.println(num + "번 게시글이 수정되었습니다.");
	}

}
