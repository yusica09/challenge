package challenge;

import java.util.Scanner;

public class BaskinRabins31 {

	public static void main(String[] args) {
		int num = 1; boolean winner = false;
		// 선플레이어 정하기
		System.out.println("> 베스킨 라빈스 31 게임 시작");
		boolean first = (int)(Math.random()*2) == 0? true:false;
		if(first) {
			while(num <= 32) {
				//플레이어 입력받기
				num = userNumInput(num);
				if(num == 32) {
					winner = true;
					break;
				}
				//컴퓨터 숫자 입력
				num = comNumInput(num);
				if(num == 32) {
					winner = false;
					break;
				}
			}
		}else {
			while(num <= 32) {
				//컴퓨터 숫자 입력
				num = comNumInput(num);
				if(num == 32) {
					winner = false;
					break;
				}
				//플레이어 입력받기
				num = userNumInput(num);
				if(num == 32) {
					winner = true;
					break;
				}
			}
		}
		
		System.out.println(winner?"> 31도달, 컴퓨터의 승리": "> 31도달, 플레이어의 승리");
		
	}//main
	
	// 컴퓨터 1~3 랜덤 숫자 뽑고 화면 출력
	private static int comNumInput(int num) {
		int comNum;
		do {
			comNum = (int)(Math.random()*3)+1;
		} while (num + comNum > 32);
		for (int i = 0; i < comNum; i++) {
			if(num == 32) {
				System.out.printf(i==0? "> 컴퓨터 : %d ":"%d ",num++);
				break;
			}else System.out.printf(i==0? "> 컴퓨터 : %d ":"%d ",num++);
		}
		System.out.println();
		return num;
	}

	//플레이어한테 숫자 개수 입력받고 화면 출력
	private static int userNumInput(int num) {
		Scanner scanner = new Scanner(System.in);
		String userStr; int userNum; boolean overNum,overInsert ;
		overNum = false;
		do {
			if(overNum) {
				System.out.println("> 31이 넘습니다 다시 입력해주세요..");
			}
			overInsert = false;
			do {
				if(overInsert) {
					System.out.println("> 1 ~ 3 중에 입력해주세요..");
					System.out.println("> 다시");
				}
				System.out.print("> 플레이어는 숫자 개수를 입력하세요 (1~3) : ");
				userStr = scanner.next();
				overInsert = true;
			} while (!(userStr.matches("^[123]$")));
			userNum = Integer.parseInt(userStr);
			overNum = true;
		} while (userNum + num > 32);
		for (int i = 0; i < userNum; i++) {
			if(num == 32) {
				System.out.printf(i==0? "> 플레이어 : %d ":"%d ",num++);
				break;
			}else System.out.printf(i==0? "> 플레이어 : %d ":"%d ",num++);
		}
		System.out.println();
		return num;
	}

}
