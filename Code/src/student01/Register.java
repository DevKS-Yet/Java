package student01;

public class Register {
	
	Student[] list = new Student[100];
	
	int i=0;
	
	void regist(Student b) {
		list[i++] = b;
		System.out.println(b.getName()+"이 등록되었습니다.");
	}
}
