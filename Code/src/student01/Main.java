package student01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Register r = new Register();
		

		loopwhile1:while (true) {
			System.out.println("성적관리시스템");
			System.out.println("1.추가\t2.출력\t3.수정\t4.검색\t5.등수\t0.프로그램종료");
			System.out.println("-----------------------------------------------------");
			System.out.println("선택!");
			String choice = scan.next();

			switch (choice) {
			case "1":
				System.out.print("반(A, B, C) : ");
				String group = scan.next();
				switch(group) {
				case "A":
					System.out.print("이름 : ");
					String name = scan.next();
					System.out.print("국어 : ");
					int kor = scan.nextInt();
					System.out.print("영어 : ");
					int eng = scan.nextInt();
					System.out.print("수학 : ");
					int math = scan.nextInt();
					r.regist(new GroupA(name, kor, eng, math));
					break;
				case "B":
					System.out.print("이름 : ");
					name = scan.next();
					System.out.print("국어 : ");
					kor = scan.nextInt();
					System.out.print("영어 : ");
					eng = scan.nextInt();
					System.out.print("수학 : ");
					math = scan.nextInt();
					r.regist(new GroupB(name, kor, eng, math));
					break;
				case "C":
					System.out.print("이름 : ");
					name = scan.next();
					System.out.print("국어 : ");
					kor = scan.nextInt();
					System.out.print("영어 : ");
					eng = scan.nextInt();
					System.out.print("수학 : ");
					math = scan.nextInt();
					r.regist(new GroupC(name, kor, eng, math));
					break;					
				}
				break;
			case "2":
				for(int i=0; i<r.i;i++) {
					System.out.print(r.list[i].getId()+"\t");
					System.out.print(r.list[i].getName()+"\t");
					System.out.print(r.list[i].getKor()+"\t");
					System.out.print(r.list[i].getEng()+"\t");
					System.out.print(r.list[i].getMath()+"\t");
					System.out.print(r.list[i].getTotal()+"\t");
					System.out.println(r.list[i].getAvg());
				}
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "0":
				System.out.println("시스템을 종료합니다.1");
				break loopwhile1;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
		scan.close();
	}// main
}// class
