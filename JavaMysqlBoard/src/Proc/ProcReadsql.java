package Proc;

import DB.DB;
import Mysql.Display;
import Util.Csc;
import Util.Ctx;

public class ProcReadsql {

	static void run() {

		Ctx.wn("읽을 글 번호를 입력하세요. [e]뒤로");
		String num = Csc.readlong();

		loop_Read : while (true) {
			
			switch (num) {
			case "e":
				break loop_Read;
			default:
				
				Display.Line();
				DB.dbExecuteQuery("select * from board where num = " + num);
				DB.dbExecuteUpdate("update board set hit=hit+1 where num=" + num); // 조회수 1 올려주기
				Display.Line();

				Display.showReplyTitle();
				DB.dbexecuteQueryReply("select * from reply where replyNum = " + num);

				// 덧글달기 선택지
				Display.showReplyMenu();
				String key = Util.Csc.readlong();
				
				// [r]리플입력 [e]뒤로
				switch (key) {
				case "r":
					String replyCon = "";
					// ======================================================================
					Ctx.wn("리플을 입력해주세요:");
					replyCon = Csc.readlong();

					// ======================================================================
					Ctx.wn("ID를 입력하세요");
					String ID = Csc.readlong();

					// 덧글 입력
					DB.dbExecuteUpdate("insert reply set replyNum = '" + num + "', replyText = '" + replyCon
							+ "', replyId = '" + ID + "';");
					// 해당 게시글 덧글 수 +1
					DB.dbExecuteUpdate("update board set replyCount = replyCount+1 where num = '" + num + "';");
					//
					break;
				case "e":
					break loop_Read;
				default:					
				}
			}
		}
	}
}
