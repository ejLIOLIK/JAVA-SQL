package Proc;

import DB.DB;
import Mysql.Display;
import Util.ScanUtil;

public class ProcBoard {

	public void run() {
		
		Display.showTitle();
		DB.dbInit();
		
//		dbExecuteQuery("select * from tottenham_squad where p_number=7");

		loop_quit : while(true) {
		
			String key = "";
			Display.showMainMenu();
			key = ScanUtil.read();

			// "[1]글리스트 [2]글읽기 [3]글쓰기 [4]글삭제 [5]글수정" e종료;
			switch (key) {
			case "1":
				ProcListsql.run();
				break;
			case "2":
				ProcReadsql.run();
				break;
			case "3":
				ProcWritesql.run();
				break;
			case "4":
				ProcDeletesql.run();
				break;
			case "5":
				ProcEditsql.run();
				break;
			case "e":
				System.out.println("종료됩니다.");
				break loop_quit;
			default:
			}
		
		}
	}
}
