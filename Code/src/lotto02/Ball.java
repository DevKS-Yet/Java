package lotto02;

public class Ball {

	private int[] ball = new int[45];
	private int[] player = new int[6], random = new int[6], correct = new int[6], correctrdm = new int[6];
	private int count = 0, countrdm = 0;

	public int[] getCorrectrdm() {
		return correctrdm;
	}

	public void setCorrectrdm(int[] correctrdm) {
		this.correctrdm = correctrdm;
	}

	public int getCountrdm() {
		return countrdm;
	}

	public void setCountrdm(int countrdm) {
		this.countrdm = countrdm;
	}

	public int[] getBall() {
		return ball;
	}

	public void setBall(int[] ball) {
		this.ball = ball;
	}

	public int[] getPlayer() {
		return player;
	}

	public void setPlayer(int[] player) {
		this.player = player;
	}

	public int[] getCorrect() {
		return correct;
	}

	public void setCorrect(int[] correct) {
		this.correct = correct;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int[] getRandom() {
		return random;
	}

	public void setRandom(int[] random) {
		this.random = random;
	}

}
