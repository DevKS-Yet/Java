package com.grade.ex;

public class Student {
	
	private String stuName;
	private int stuKor, stuEng, stuMath, stuTotal, stuRank;
	private double stuAvg;
	
	Student(String stuName, int stuKor, int stuEng, int stuMath){
		this.stuName = stuName;
		this.stuKor = stuKor;
		this.stuEng = stuEng;
		this.stuMath = stuMath;
		this.stuTotal = stuKor+stuEng+stuMath;
		this.stuAvg = this.stuTotal/3.0;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuKor() {
		return stuKor;
	}

	public void setStuKor(int stuKor) {
		this.stuKor = stuKor;
	}

	public int getStuEng() {
		return stuEng;
	}

	public void setStuEng(int stuEng) {
		this.stuEng = stuEng;
	}

	public int getStuMath() {
		return stuMath;
	}

	public void setStuMath(int stuMath) {
		this.stuMath = stuMath;
	}

	public int getStuTotal() {
		return stuTotal;
	}

	public void setStuTotal(int stuTotal) {
		this.stuTotal = stuTotal;
	}

	public int getStuRank() {
		return stuRank;
	}

	public void setStuRank(int stuRank) {
		this.stuRank = stuRank;
	}

	public double getStuAvg() {
		return stuAvg;
	}

	public void setStuAvg(double stuAvg) {
		this.stuAvg = stuAvg;
	}
	
}
