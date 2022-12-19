package Util;

public class Cet {

	public static int intToString (String str) {
		try{
            int number = Integer.parseInt(str);
            return number ; 
        }
        catch (NumberFormatException ex){
        	System.out.println("잘못된 입력입니다.");
            ex.printStackTrace();
        }
		return -1;
	} 
	
}
