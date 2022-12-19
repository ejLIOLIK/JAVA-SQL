package Proc;

import DB.DB;
import Util.Csc;
import Util.Ctx;

public class ProcWritesql {

	static void run() {
		
		String contents ="";
		String title = "";

		// ======================================================================
		Ctx.wn("글제목을 입력해주세요:");
		title = Csc.readlong();
		
		// ======================================================================
		Ctx.wn("글내용을 입력해주세요:");
		contents = Csc.readlong();
		
		// ======================================================================
		Ctx.wn("ID를 입력하세요");
		String ID = Csc.readlong();
		// ======================================================================		
		
		DB.dbExecuteUpdate("insert into board (title, ID, date, contents, hit, replyCount) values('" + title + "', '"+ ID +"', now(), '"+ contents +"', 0, 0);");
		
		Ctx.wn("게시글이 등록되었습니다.");
		
	}
}
