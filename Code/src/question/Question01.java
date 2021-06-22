package question;

public class Question01 {

	public static void main(String[] args) {

		// 오름차순으로 정렬되어있는 두 배열 arrA, arrB를 하나의 배열로 합칠려고 함.
		// 합친 후의 배열도 오름차순으로 정렬되어있어야 함.
		// 예: arrA = [-2, 3, 5, 9] arrB = [0, 1, 5] -> result = [-2, 0, 1, 3, 5, 5, 9]

		int[] arrA = { -2, 3, 5, 9 };
		int[] arrB = { 0, 1, 5 };
		int[] result = new int[7];
		int countA = 0;
		int countB = 0;
		int count = 0;

		for (int i = 0; i < arrA.length + arrB.length; i++) {
			if (arrA[countA] <= arrB[countB]) {
				result[count] = arrA[countA];
				countA++;
				count++;
			} else if(arrA[countA] > arrB[countB]){
				result[count] = arrB[countB];
				countB++;
				count++;
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "\t");
		}

	}
}
