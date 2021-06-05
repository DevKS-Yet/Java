package student04;

import java.util.ArrayList;

public class Student {

	static int count;
	private String id, name;
	private int total, rank;
	private ArrayList<Integer> score = new ArrayList<Integer>();
	private double avg;
	
	{
		id = "S"+String.format("%02d", ++count);
	}
	
	Student(){}
	Student(String name, ArrayList<Integer> score){
		this.name = name;
		for(int i=0; i<score.size();i++) {
			this.score.add(score.get(i));
			this.total += score.get(i);
		}
			this.avg = this.total/score.size();
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public ArrayList<Integer> getScore() {
		return score;
	}
	public void setScore(ArrayList<Integer> score) {
		this.score = score;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
