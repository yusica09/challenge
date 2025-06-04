package challenge;

import java.util.Scanner;

public class ChangeUpperLower {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    String str = scanner.next();
	    
	    StringBuilder sb = new StringBuilder("");
	    /*
	     * for(char c : str.toCharArray()){} 로도 가능
	     */
	    for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			/*
			 * 대문자 A~Z ( 65 ~ 90 )
			 * 소문자 a~z ( 97 ~ 122 )
			 * 
			 * if( c >= 65 && c <= 90 )  -> 대문자인 경우
			 * 		sb.append((char)(x+32))
			 * if( c >= 97 && c <= 122) -> 소문자인 경우
			 * 		sb.append((char)(x-32))
			 */
			if(Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
			else sb.append(Character.toLowerCase(c));
		}
	    System.out.println(sb);
	    scanner.close();
	}

}
