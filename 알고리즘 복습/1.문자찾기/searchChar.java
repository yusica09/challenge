package challenge;

import java.io.IOException;

import java.util.*;

public class searchChar {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		//LowerCase 대신 UpperCase도 가능!
		String str = scanner.next().toLowerCase();
		//char의 경우 Character.toLowerCase(c); 로 함수 이용가능하나, 
		//여기선 처음 string을 LowerCase 하고, 한글자만 가져왔으므로 상관 X
		char c = scanner.next().toLowerCase().charAt(0);
		
		int count = 0;
		char [] strArr = str.toCharArray();
		//charArray를 이용한다면 for문보단 foreach문이 더 좋다
		/*
		for (char s : str.toCharArray()) {
			if(s == c) count ++;
		} 
		*/
		for (int i = 0; i < strArr.length; i++) {
			if(strArr[i] == c) {
				count++;
			}
		}
		//charArr 안쓰고 string 상태에서 비교하는 방법
		/*
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c)	count++;
		}
		*/

		scanner.close();
		System.out.println(count);

	}//main
}