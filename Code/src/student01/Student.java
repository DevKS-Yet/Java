package student01;

import java.util.Scanner;

public class Student {
	
	static Scanner scan = new Scanner(System.in);
	
	static int count_a;
	static int count_b;
	static int count_c;
	private String id, name;
	private int kor, eng, math, total, rank;
	private double avg;
	private char group;
	
	Student(){}
	
	Student(char group, String name, int kor, int eng, int math){
		if(group=='A') {
			id = group + String.format("%02d", ++count_a);
		} else if(group=='B') {
			id = group + String.format("%02d", ++count_b);
		} else {
			id = group + String.format("%02d", ++count_c);
		}
		this.group = group;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor+eng+math;
		this.avg = this.total/3.0;
	}

//---------------------------getter setter-------------------------------
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

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public char getGroup() {
		return group;
	}

	public void setGroup(char group) {
		this.group = group;
	}
//-----------------------------------------------------------------------
}//class
