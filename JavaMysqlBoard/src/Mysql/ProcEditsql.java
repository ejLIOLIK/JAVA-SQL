package Mysql;

import java.io.IOException;

import Util.Util;

public class ProcEditsql {
	
	static void run() {
		
		String tmp="";

		System.out.println("수정할 글 번호를 입력하세요.");
		String num = Util.sc.next();
		
		System.out.println("수정할 부분을 선택하세요.");
		System.out.println("[1]글제목 [2]글내용 [3]ID");
		String editStr = Util.sc.next();
		
		System.out.println("수정할 내용을 입력하세요.");		
				
		try {
			tmp = Util.rd.readLine();
		} catch (IOException e) { // 예외처리
			e.printStackTrace();
		}
		
		switch(editStr) {
		case "1": //update Tot set name = '로드리고벤탄쿠르' where backnum=30;
			Util.dbExecuteUpdate("update board set title='" + tmp + "' where num=" + num);
			break;
		case "2":
			Util.dbExecuteUpdate("update board set contents='" + tmp + "' where num=" + num);
			break;
		case "3":
			Util.dbExecuteUpdate("update board set ID='" + tmp + "' where num=" + num);
			break;
			default:
		}
				
		System.out.println(num + "번 게시글이 수정되었습니다.");
	}

}
