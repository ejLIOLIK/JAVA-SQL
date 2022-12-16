package Mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import Util.Util;

public class ProcBoard {

	void run() {
		
		Display.showTitle();
		Util.dbInit();
		
//		dbExecuteQuery("select * from tottenham_squad where p_number=7");

		loop_quit : while(true) {
		
			String key = "";
			Display.showMainMenu();
			Util.sc = new Scanner(System.in);
			key = Util.sc.next();

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
