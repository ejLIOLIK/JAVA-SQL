package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScanUtil {
	
	public static Scanner sc = new Scanner(System.in);
	public static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	
	static public String read() {
		return sc.next();
	}
	
	static public String readlong() {
		try {
			return rd.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
