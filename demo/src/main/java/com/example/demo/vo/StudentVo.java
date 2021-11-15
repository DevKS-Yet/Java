package com.example.demo.vo;

public class StudentVo {
	
	int Math;
	int Engliash;
	int Korean;
	
	public StudentVo() {}
	
	public StudentVo(int math, int engliash, int korean) {
		Math = math;
		Engliash = engliash;
		Korean = korean;
	}
	
	public int getMath() {
		return Math;
	}
	public void setMath(int math) {
		Math = math;
	}
	public int getEngliash() {
		return Engliash;
	}
	public void setEngliash(int engliash) {
		Engliash = engliash;
	}
	public int getKorean() {
		return Korean;
	}
	public void setKorean(int korean) {
		Korean = korean;
	}
	
}
