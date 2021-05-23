import java.util.Scanner;

public class Grade03 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("최대 학생의 숫자를 입력하세요");
		int studentNumber = scan.nextInt();
		System.out.println("과목 수를 입력하세요");
		int subjectNumber = scan.nextInt();

		String[] subjectName = new String[subjectNumber]; // 받은 과목 수(subjectNumber)만큼 과목 이름 넣을 배열 생성
		System.out.println("과목별로 이름을 입력해주세요");
		for (int i = 0; i < subjectNumber; i++) { // 반복문을 통해 과목 이름을 넣기
			System.out.print("제 " + (i + 1) + "과목은 : "); // i가 입력한 과목 수보다 작을때까지
			subjectName[i] = scan.next();
		}

		String[] studentName = new String[studentNumber]; // 입력한 최대 학생 수만큼 배열 생성
		int[][] studentScore = new int[studentNumber][subjectNumber + 1]; // 입력한 [최대 학생 수, 과목 수+합계]만큼 배열 생성

		int count = 0; // 학생이 추가될때마다 1씩 더해질 예정인 카운트
		String search = ""; // 학생성적 검색&수정&삭제에서 사용될 변수
		int intTemp = 0; // 임시 정수 변수
		String strTemp = ""; // 임시 문자열 변수

		int[] rank = new int[studentNumber];

		loopwhile1: while (true) { // 프로그램 종료 전까지 안에서 돌도록 한 반복문

			System.out.println(" [ 학생관리시스템 ]");
			System.out.println(
					"1.검색\t2.추가\t3.수정\t4.삭제\t5.등수\t6.출력\t0.프로그램종료\n----------------------------------------------------------\n어떤 것을 선택하시겠습니까?");

			String program_choice = scan.next(); // 스위치문에 입력될 문자

			loopswitch1: switch (program_choice) {
			case "1": // 학생성적검색
				System.out.println();

				// count가 0일 경우 학생이 없음을 알려줌
				if (count == 0) { // 학생성적추가를 한번도 안하고 들어왔을 경우
					System.out.println("등록된 학생 성적이 없습니다. 추가해주세요.");
					break;
				}

				// count가 0이 아닐 경우
				System.out.println("찾고자하는 학생의 이름을 적어주세요");
				search = scan.next();
				for (int i = 0; i < count; i++) { // 지금까지 등록한 학생수 만큼 돌리기
					if (search.equals(studentName[i])) { // 만약 입력된 변수와 동일한 값의 이름이 있을 경우
						System.out.println(studentName[i] + "의 성적입니다.");
						System.out.print("이름");
						for (int j = 0; j < subjectName.length; j++) {
							System.out.print("\t" + subjectName[i]);
						}
						System.out.println("\t합계\t평균");
						for (int j = 0; j < subjectName.length + 3; j++) {
							System.out.print("--------");
						}
						System.out.print("\n" + studentName[i]); // 출력부분
						for (int j = 0; j < subjectNumber + 1; j++) {
							System.out.print("\t" + studentScore[i][j]);
						}
						System.out.printf("\t%.2f\n", (float) (studentScore[i][subjectNumber] / subjectNumber)); // 평균부분
						break loopswitch1;
					}
				}
				System.out.println("해당 이름을 갖고 있는 학생은 없습니다.");
				break;

			case "2": // 학생성적추가
				System.out.println();

				if (count >= studentNumber) { // 만약 배열 최대 수를 넘었을 경우
					System.out.println("추가할 수 있는 최대 학생의 수를 넘었습니다.");
					break;
				}

				System.out.println("학생 이름을 입력하세요 : (취소: 0)");
				studentName[count] = scan.next();

				if ("0".equals(studentName[count])) { // 0을 입력한 경우 바로 상위 메뉴로 복귀
					break;
				}

				for (int i = 0; i < subjectNumber; i++) {
					System.out.print(subjectName[i] + " 과목의 점수를 입력하세요 : ");
					studentScore[count][i] = scan.nextInt(); // 과목별 점수 입력
					studentScore[count][subjectNumber] += studentScore[count][i]; // 점수 합계
				}

				count++;

				while (true) {
					for (int i = count; i < studentNumber; i++) {
						if (null != studentName[i]) {
							count++;
						} else {
							break loopswitch1;
						}
					}
					break;
				}
				break;

			case "3": // 학생성적수정
				System.out.println();

				System.out.println("수정할 학생 이름을 입력해주세요 : ");

				search = scan.next();
				for (int i = 0; i < count; i++) {
					if (search.equals(studentName[i])) { // 입력한 학생 이름이 존재할 경우
						System.out.println(studentName[i] + "의 성적을 수정하겠습니다.\n어떤 내용을 수정하시겠습니까?");
						for (int j = 0; j < subjectName.length; j++) { // 과목 이름 출력부분
							System.out.print((j + 1) + ". " + subjectName[j] + "\t");
						}
						System.out.println((subjectName.length + 1) + ". " + "전체"); // 성적 전체를 바꾸고 싶을 경우를 위한 출력
						intTemp = scan.nextInt();
						if (intTemp == subjectName.length + 1) { // 입력한 값이 성적 전체를 바꾸고싶은 수와 같은 경우
							studentScore[i][subjectNumber] = 0; // 해당 학생의 합계 점수 초기화
							for (int j = 0; j < subjectName.length; j++) {
								System.out.println(subjectName[j] + " 과목의 점수를 입력하세요 :");
								studentScore[i][j] = scan.nextInt();
								studentScore[i][subjectNumber] += studentScore[i][j]; // 과목별로 입력하는 값을 합계에 더하기
							}
							System.out.println(studentName[i] + "의 점수가 수정되었습니다.");
							break loopswitch1;
						} else { // 하나의 성적만 수정하고자 할 경우
							System.out.println(subjectName[(intTemp - 1)] + " 과목의 점수를 입력하세요 : ");
							studentScore[i][intTemp - 1] = scan.nextInt(); // 과목명에서 1부터 선택할 수 있도록 했었기에 해당 위치로 갈려면 인덱스-1
							studentScore[i][subjectNumber] = 0; // 해당 학생의 합계 점수 초기화
							for (int j = 0; j < subjectName.length; j++) { // 해당 학생의 합계 점수 다시 계산
								studentScore[i][subjectNumber] += studentScore[i][j];
							}
							System.out.println(studentName[i] + "의 " + subjectName[intTemp - 1] + " 과목의 점수가 수정되었습니다.");
							break loopswitch1;
						}
					}
				}
				System.out.println("해당 학생의 정보가 존재하지 않습니다.");
				break;

			case "4": // 학생성적삭제
				System.out.println();

				if (count == 0) {
					System.out.println("등록된 학생 정보가 없습니다.");
					break;
				}

				System.out.println("삭제할 학생의 이름을 입력해주세요 (전체 삭제:" + (studentNumber + 1) + ")");
				search = scan.next();
				if (search.equals(Integer.toString(studentNumber + 1))) { // 전체를 삭제로 눌렀을시
					for (int i = 0; i < count; i++) {
						studentName[i] = null;
						for (int j = 0; j < subjectNumber; j++) {
							studentScore[i][j] = 0;
						}
					}
					count = 0;
					System.out.println("전체가 삭제되었습니다.");
					break loopswitch1;
				} else {
					for (int i = 0; i < count; i++) {
						if (search.equals(studentName[i])) { // 삭제할 학생의 이름과 동일한 값
							strTemp = studentName[i];
							studentName[i] = null; // 해당 학생 이름 초기화
							for (int j = 0; j < subjectNumber; j++) {
								studentScore[i][j] = 0; // 해당학생 성적 초기화
							}
							count = i;
							System.out.println(strTemp + "의 성적이 삭제되었습니다.");
							break loopswitch1;
						}
					}
					System.out.println("해당 학생의 이름은 없습니다.");
				}
				break;

			case "5": // 학생성적등수
				System.out.println();

				System.out.println("학생 성적을 등수대로 표기합니다");

				for (int i = 0; i < studentNumber; i++) { // 등수표기할 rank배열 전체에 1대입
					rank[i] = 1;
				}
				for (int i = 0; i < studentNumber; i++) { // rank배열은 다수대 다수니까 이중포문
					for (int j = 0; j < studentNumber; j++) {
						if (studentScore[i][subjectNumber] < studentScore[j][subjectNumber]) {
							rank[i]++; // 평균 점수가 낮으면 rank[i]는 ++
						}
					}
				}

				for (int i = 0; i < studentNumber - 1; i++) {
					for (int j = i + 1; j < studentNumber; j++) {
						if (rank[i] > rank[j]) { // 등록된 순으로 1과 2, 2와 3, 3과 4, ... 으로 쭉 비교(의문점 숫자가 많도 뒤죽박죽일 경우 i만큼 돌아가서
													// 비교?....?.. 에바)
							intTemp = rank[i];
							rank[i] = rank[j];
							rank[j] = intTemp; // rank[i]가 rank[j]보다 높다면 i와 j의 자리 바꾸기
							strTemp = studentName[i];
							studentName[i] = studentName[j];
							studentName[j] = strTemp; // 위와 동일 이름 위치 바꾸기
							for (int k = 0; k < subjectNumber + 1; k++) {
								intTemp = studentScore[i][k];
								studentScore[i][k] = studentScore[j][k];
								studentScore[j][k] = intTemp; // 위와 동일 점수 및 합계 바꾸기
							}
						}
					}
				}

				for (int i = 0; i < studentNumber; i++) {
					System.out.println(studentName[i] + "의 순위 : " + rank[i] + "등");
				}
				break;

			case "6": // 학생성적출력
				System.out.println();

				if (count == 0) {
					System.out.println("출력할 학생이 없습니다. 추가해주세요.");
					break;
				} else {
					System.out.print("이름");
					for (int i = 0; i < subjectName.length; i++) {
						System.out.print("\t" + subjectName[i]);
					}
					System.out.println("\t합계\t평균");
					for (int i = 0; i < subjectName.length + 3; i++) {
						System.out.print("--------");
					}
					System.out.println();
					for (int i = 0; i < count; i++) {
						System.out.print(studentName[i]);
						for (int j = 0; j < subjectNumber + 1; j++) {
							System.out.print("\t" + studentScore[i][j]);
						}
						System.out.printf("\t%.2f\n", (float) (studentScore[i][subjectNumber] / subjectNumber));
					}

				}
				break;

			case "0":
				System.out.println("프로그램을 종료하겠습니다.");
				break loopwhile1;

			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}// switch
		} // while
		scan.close();
	}// main
}// class
