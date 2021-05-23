import java.util.Scanner;

public class Test {

   public static void main(String[] args) {

      // 학생성적 관리를 위한 프로그램 만들기
      Scanner scan = new Scanner(System.in);
      // 변수 위치
      String[] name = new String[10]; // 학생이름 정보
      int[][] score = new int[10][4]; // 학생 성적 정보
      double[] avg = new double[10];   // 평균 정보
      String sell = "";   //이름에 입력되는정보 0 일경우 상위메뉴
      int count = 0;      //입력되는 학생 숫자만큼 증가 몇명이 들어갔는지 확인
      String[] kem = {"국어","영어","수학"}; //score에 순서대로 넣기 확인
      int me = 0;         //정보 수정시 이름을 찾기 위해 배열의 숫자 저장
      
      // 반복문이 돌아가는 위치
      loopt1 :while (true) {

         // 검색해서 볼 목록 확인하기
         System.out.println("[학생 성적 관리 프로그램]");
         System.out.println("1. 학생 성적 정보 입력>>>");
         System.out.println("2. 학생 성적 정보 수정>>>");
         System.out.println("3. 모든 학생 정보 출력>>>");
         System.out.println("4. 검색하는 학생 정보 출력>>>");
         System.out.println("0. 프로그램 종료하기>>>");
         System.out.println("진행할 프로그램 번호를 입력하세요.");
         int coes = scan.nextInt();
         
         //switch 시작
         switch (coes) { //검색한 coes를 찾는다
         
         // 정보입력
         case 1:
            
            System.out.println("[학생 성적 입력]");
            for(int i=count;i<score.length;i++) {//count가 0부터 배열 0자리에 들어간다.
               System.out.println((i+1)+"번째 이름을 입력하세요:(상위 메뉴는 '0')");
               sell = scan.next();//입력한 정보가 sell에 저장
               
               if(sell.equals("0")) {//sell이 0일 경우 밖으로 나간다.
                  break;
               }      
               
               name[i] = sell;      //sell이 0이 아닐경우 멈추기 전까지 name의 배열에 넣는다.
               
               for(int j=0;j<score[i].length-1;j++) {//점수 들어가기 시작
                  System.out.println(kem[j]+"성적을 입력해 주세요:");//j가3번 돌면서 kem에 있는 배열 출력
                  score[i][j] = scan.nextInt();      //국어, 영어, 수학 까지만 입력
               }
               score[i][3] = score[i][0]+score[i][1]+score[i][2];//합계
               avg[i] = score[i][3]/3.0;      //평균
               
               count++;   //0부터 for문이 진행될 때마다 1씩 증가 번호아 겹치지 않도록 설정
            }
            
            break;
            
         // 정보수정
         case 2:

            System.out.println("[학생 정보 수정]");
            System.out.println("수정할 학생 이름을 입력해 주세요:(상위 메뉴는 '0')");
            sell = scan.next();
            
            if(sell.equals("0")) {
               break;
            }
            
            for(int i=0;i<count;i++) {      //count에 입력된 숫자만큼만 돈다.
               if(sell.equals(name[i])) {   //sell에 입력한 정보가 name의 배열에 하나씩 비교
                  me = i;               //맞는게 나요면 해당 배열의 숫자i을 me에 넣는다.
               }                     //me는 내가 찾는 줄의 시작점이 된다.
               
            }
            
            System.out.println(name[me]+"학생을 찾았습니다.");
            System.out.println("수정할 과목을 선택해 주세요:");
            System.out.println("1.국어  2.영어  3.수학");
            int im = scan.nextInt();
            im = im-1;      //선택된 과목의 배열이 0,1,2이라서 1을 빼주면 순서가 맞게 된다.
            
            System.out.println("해당 과목의 점수는 : "+ score[me][im]);//me는 내가 찾는줄의 시작점 im은 해당하는 줄을 보여준다. 
            System.out.println("수정할 점수를 입력해 주세요 :");
            score[me][im] = scan.nextInt(); // 찾은 위치에 내가 입력한 점수를 덮어 쓴다.
            
            score[me][3] = score[me][0]+score[me][1]+score[me][2]; //점수가 달라졌기 때문에 해당하는줄의 평균을 바꿔쓴다.
            avg[me] = score[me][3]/3.0;      //평균도 마찬가지이다.
            
            System.out.println("수정 완료 되었습니다.");
            
            break;
            
         // 정보출력
         case 3:
            
            System.out.println("[학생 성적 정보]");            
            
            System.out.println("이름\t국어\t영어\t수학\t합계\t평균");//기준을 나타내기 위해 표의 윗부분을 보여준다.
            System.out.println("----------------------------------------------------");
            for(int i=0;i<count;i++) {   //0부터 내가 입력한 학생의수(count)까지 실행한다.
               System.out.print(name[i]+"\t");//저장된 이름을 아래로 출력한다.
               for(int j=0;j<score[i].length;j++) {//0부터 입력한 점수와 합계(score)가 실행.
                  System.out.print(score[i][j]+"\t");// 정보가 옆으로 출력.
               }
               System.out.printf("%.2f",avg[i]);//평균이 출력 합계의 옆으로 나온다.
               System.out.println();//평균이 나오고 줄을 바꿔준다.
            }
            
            
            break;
            
         // 1명의 정보 확인
         case 4:

            System.out.println("[학생 정보 확인]");
            System.out.println("확인할 학생 이름을 입력해 주세요:(상위 메뉴는 '0')");
            sell = scan.next();
            
            if(sell.equals("0")) {
               break;
            }
            
            for(int i=0;i<count;i++) {      //count에 입력된 숫자만큼만 돈다.
               if(sell.equals(name[i])) {   //sell에 입력한 정보가 name의 배열에 하나씩 비교
                  me = i;               //맞는게 나요면 해당 배열의 숫자i을 me에 넣는다.
               }                     //me는 내가 찾는 줄의 시작점이 된다.
            }
         
            
            System.out.println("선택한 학생의 정보는:");
            System.out.println("이름\t국어\t영어\t수학\t합계\t평균");//출력문이 보기 편하게 기준을 만든다.
            
            System.out.print(name[me]+"\t");      //이름을 출력 me는 위에서 내가 검색한 이름의 위치값
            for(int i=0;i<score[me].length;i++) {   //찾은 이름의 점수를 출력 위치값(me)의 score점수 범위 지정 
               System.out.print(score[me][i]+"\t");//범위에 해당하는 점수 출력
            }
            System.out.printf("%.2f",avg[me]);//평균 출력
            
            break;
            
         //프로그램 종료
         case 0://0번이 눌리면 loopt1 가 실행되는대 맨 위쪽의 while문을 빠져나가 프로그램이 종료된다.

            break loopt1 ;
            
         default:

            break;

         // 끝
         }

      } // while
      scan.close();
   }// main

}// class