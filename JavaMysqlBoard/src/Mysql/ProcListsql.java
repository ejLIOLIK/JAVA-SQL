package Mysql;

import Util.Util;

public class ProcListsql {
	
	final static int PAGE = 5;
	
	static void run() {
		
		int mountPage = Util.countBoard()/PAGE+1; // 현재 페이지 수
		
		Display.Line();
		System.out.println("글번호	ID	제목			조회수");
		Util.dbExecuteQueryList("select * from board order by num desc limit 0,5;"); // 첫 페이지 출력

		Display.Line();
		System.out.println("page1" + "/" + mountPage);

		while (true) {
			Display.Line();
			System.out.println("[1~" + mountPage + "] 해당 페이지로 이동 [0] 뒤로 ");
			int key = Util.sc.nextInt();

			if (key == 0) {
				break;
			} else {

				if (key > mountPage ) {
					System.out.println("해당 페이지가 없습니다.");
				} else {
					System.out.println("글번호	ID	제목			조회수");
					Util.dbExecuteQueryList(
							"select * from board order by num desc limit " + ((key - 1) * PAGE) + "," + PAGE + ";");
					Display.Line();
					System.out.println("page" + (key) + "/" + mountPage);
				}
			}
		}
	} 

}
