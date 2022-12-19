package Proc;

import DB.DB;
import Util.ScanUtil;

public class ProcWritesql {

	static void run() {
		
		String contents ="";
		String title = "";

		// ======================================================================
		System.out.println("글제목을 입력해주세요:");
		title = ScanUtil.readlong();
		
		// ======================================================================
		System.out.println("글내용을 입력해주세요:");
		contents = ScanUtil.readlong();
		
		// ======================================================================
		System.out.println("ID를 입력하세요");
		String ID = ScanUtil.read();
		// ======================================================================		
		
		DB.dbExecuteUpdate("insert into board (title, ID, date, contents, hit, replyCount) values('" + title + "', '"+ ID +"', now(), '"+ contents +"', 0, 0);");
		
		System.out.println("게시글이 등록되었습니다.");
		
		
	}
}
