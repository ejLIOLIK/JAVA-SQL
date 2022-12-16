package Mysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Util.Util;

public class ProcWritesql {

	static void run() {
		
		String contents ="";
		String title = "";

		// ======================================================================
		Util.sc=new Scanner(System.in);
		System.out.println("글제목을 입력해주세요:");
		try {
			title = Util.rd.readLine();
		} catch (IOException e) { // 예외처리
			e.printStackTrace();
		}
		
		// ======================================================================
		System.out.println("글내용을 입력해주세요:");
		try {
			contents = Util.rd.readLine();
		} catch (IOException e) { // 예외처리
			e.printStackTrace();
		}
		// ======================================================================
		System.out.println("ID를 입력하세요");
		String ID = Util.sc.next();
		// ======================================================================		
		Util.dbExecuteUpdate("insert into board (title, ID, date, contents, hit) values('" + title + "', '"+ ID +"', now(), '"+ contents +"', 0);");
		
		System.out.println("게시글이 등록되었습니다.");
		
		
	}
}
