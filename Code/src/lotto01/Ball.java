package lotto01;

public class Ball {

	private int[] ball = new int[45];
	private int[] player_ball = new int[6];
	private int[] correct_ball = new int[6];
	private int count;
	
	
	public int[] getBall() {
		return ball;
	}
	public void setBall(int[] ball) {
		this.ball = ball;
	}
	public int[] getPlayer_ball() {
		return player_ball;
	}
	public void setPlayer_ball(int[] player_ball) {
		this.player_ball = player_ball;
	}
	public int[] getCorrect_ball() {
		return correct_ball;
	}
	public void setCorrect_ball(int[] correct_ball) {
		this.correct_ball = correct_ball;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
