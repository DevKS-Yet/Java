import java.util.Scanner;

public class TreasureHunt01 {

	public static void main(String[] args) {

		// 보물찾기

		Scanner scan = new Scanner(System.in);

		// 보물찾기 가로 세로 길이 정하기
		System.out.print("넓이를 적어주세요 : ");
		int treasureWidth = scan.nextInt();
		System.out.print("높이를 적어주세요 : ");
		int treasureHeight = scan.nextInt();

		// 받은 가로 세로 길이만큼 이중배열 생성
		String[][] treasureMapVisible = new String[treasureHeight][treasureWidth];
		int[][] treasureMapInvisible = new int[treasureHeight][treasureWidth];

		// 안에 넣을 것 생성
		System.out.print("보물상자 갯수 : ");
		int treasureNumber = scan.nextInt();
		int[] treasureRandom = new int[treasureHeight * treasureWidth];
		int randomTemp = 0;

		// 안에 적은 보물상자 갯수만큼 1로 대입
		for (int i = 0; i < treasureNumber; i++) {
			treasureRandom[i] = 1;
		}

		// 해당 배열 섞기
		for (int i = 0; i < 200; i++) {
			int random = (int) (Math.random() * treasureHeight * treasureWidth);
			randomTemp = treasureRandom[0];
			treasureRandom[0] = treasureRandom[random];
			treasureRandom[random] = randomTemp;
		}

		// 섞은 랜덤보물을 int보물맵에 대입
		for (int i = 0; i < treasureHeight; i++) {
			for (int j = 0; j < treasureWidth; j++) {
				treasureMapInvisible[i][j] = treasureRandom[treasureWidth * i + j];
			}
		}

		// string보물맵에는 null값이 아닌 ?로 대입
		for (int i = 0; i < treasureHeight; i++) {
			for (int j = 0; j < treasureWidth; j++) {
				treasureMapVisible[i][j] = "?";
			}
		}

		// while문 안에서 출력시키기
		int coin = 0;
		int treasurefound = 0;
		while (treasurefound < treasureNumber) {

			// string보물맵 출력

			// 보물맵 상단 출력
			System.out.print("좌표");
			for (int i = 0; i < treasureWidth; i++) {
				System.out.print("\t" + i);
			}
			System.out.println();
			System.out.print("   ");
			for (int i = 0; i < treasureWidth + 1; i++) {
				System.out.print("------");
			}

			// 보물맵 내용 출력
			System.out.println();
			for (int i = 0; i < treasureHeight; i++) {
				System.out.print(i + "  |");
				for (int j = 0; j < treasureWidth; j++) {
					System.out.print("\t" + treasureMapVisible[i][j]);
				}
				System.out.println();
			}

			// 좌표 클릭 시 int보물맵에서 0인지 1인지 확인 후 1이면 string보물맵에 보물, 0이면 꽝
			System.out.print("높이 선택(0~" + (treasureHeight - 1) + ") : ");
			int heightInput = scan.nextInt();
			System.out.print("가로 선택(0~" + (treasureWidth - 1) + ") : ");
			int widthInput = scan.nextInt();

			if (treasureMapInvisible[heightInput][widthInput] == 1) {
				treasureMapVisible[heightInput][widthInput] = "보물";
				treasurefound++;
			} else {
				treasureMapVisible[heightInput][widthInput] = "꽝";
			}
			coin++;

		}

		// string보물맵 마지막 확인용 출력
		System.out.print("\n\n맵\n");
		for (int i = 0; i < treasureHeight; i++) {
			for (int j = 0; j < treasureWidth; j++) {
				System.out.print(treasureMapVisible[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("도전한 횟수는 " + coin + "번 입니다.");
		scan.close();
	} // main
} // class
