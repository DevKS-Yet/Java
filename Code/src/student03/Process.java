package student03;

import java.util.ArrayList;
import java.util.Scanner;

public class Process {
	
	static Scanner scan = new Scanner(System.in);
	
	void main(ArrayList list) {
		loop1:while(true) {
			menuPrint();
			String choice = scan.next();
			
			switch(choice) {
			case "1":
				studentAdd(list);
				break;
			case "2":
				studentUpdate(list);
				break;
			case "3":
				studentSearch(list);
				break;
			case "4":
				studentPrint(list);
				break;
			case "5":
				studentRank(list);
				break;
			case "0":
				break loop1;
			default:
				break;
			}
		}
	}
	
//------------------------------------------------------------------------------
	void menuPrint() {
		System.out.println("[ 성적관리 시스템 ]");
		System.out.println("1. 추가\t"
				+ "2. 수정\t"
				+ "3. 검색\t"
				+ "4. 출력\t"
				+ "5. 등수처리\t"
				+ "0. 시스템 종료");
		System.out.println("원하는걸 선택하시오~");
	}
	
//------------------------------------------------------------------------------
	void studentAdd(ArrayList list) {
		System.out.println("이름(0. 상위메뉴) : ");
		String name = scan.next();
		if(name.equals("0")) {
			System.out.println("상위 메뉴로 이동하겠습니다");
			return;
		} else {
			System.out.print("국어 : ");
			int kor = scan.nextInt();
			if(kor <0|| kor>100) {
				System.out.println("점수는 0~100점만");
				return;
			}
			System.out.print("영어 : ");
			int eng = scan.nextInt();
			if(eng < 0||eng>100) {
				System.out.println("점수는 0~100점만");
				return;
			}
			System.out.print("수학 : ");
			int math = scan.nextInt();
			if(math < 0 || math>100) {
				System.out.println("점수는 0~100점만");
				return;
			}
			list.add(new Student(name, kor, eng, math));
			System.out.println(name+"이 등록되었습니다.");
		}
	}

//------------------------------------------------------------------------------
	
	void studentUpdate(ArrayList list) {
		System.out.println("이름(0.상위메뉴) : ");
		String search = scan.next();
		for(int i=0; i<list.size(); i++) {
			Student s = (Student)list.get(i);
			if(s.getName().equals(search)) {
				studentPrintTop();
				studentPrint1(list, i);
				System.out.println("어떤거 수정?");
				search = scan.next();
				switch(search) {
				case "국어":
					System.out.print("국어 : ");
					int score = scan.nextInt();
					if(score<0||score>100) {
						System.out.println("점수는 0~100점만");
						i--;
						break;
					}
					s.setKor(score);
					break;
				case "영어":
					System.out.print("영어 : ");
					score = scan.nextInt();
					if(score<0||score>100) {
						System.out.println("점수는 0~100점만");
						i--;
						break;
					}
					s.setEng(score);
					break;
				case "수학":
					System.out.print("수학 : ");
					score = scan.nextInt();
					if(score<0||score>100) {
						System.out.println("점수는 0~100점만");
						i--;
						break;
					}
					s.setMath(score);
					break;
				default:
					System.out.println("제대로 입력해주세요~");
					i--;
					break;
				}
				s.setTotal(s.getKor()+s.getEng()+s.getMath());
				s.setAvg(s.getTotal()/3.0);
				System.out.println(search+" 점수가 반영되었습니다.");
			}
		}
	}
	
//------------------------------------------------------------------------------
	
	void studentSearch(ArrayList list) {
		int check = 0;
		System.out.println("검색 이름 : ");
		String search = scan.next();
		for(int i=0; i<list.size(); i++) {
			Student s = (Student)list.get(i);
			if(s.getName().contains(search)) {
				if(check == 0) {
					studentPrintTop();
				}
				studentPrint1(list, i);
				check = 1;
			}
		}
		if(check == 0) {
			System.out.println("이름 없음~");
		}
	}
//------------------------------------------------------------------------------
	
	void studentPrintTop() {
		System.out.println("ID\t이름\t국어\t영어\t수학\t합계\t평균\t등수");
	}
	
	void studentPrint1(ArrayList list, int i) {
		Student s = (Student)list.get(i);
		System.out.printf("%s\t%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n", s.getId(), s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getTotal(), s.getAvg(), s.getRank());
	}
	
	void studentPrint(ArrayList list) {
		studentPrintTop();
		for(int i=0; i<list.size(); i++) {
			studentPrint1(list, i);
		}
	}
//------------------------------------------------------------------------------
	
	void studentRank(ArrayList list) {
		for(int i=0; i<list.size(); i++) {
			int rank = 1;
			Student s1 = (Student)list.get(i);
			for(int j=0; j<list.size();j++) {
				Student s2 = (Student)list.get(j);
				if(s1.getTotal()<s2.getTotal()) {
					rank++;
				}
			}
			s1.setRank(rank);
		}
	}
	
	
}//class
