class OuterClass {
	int x = 10;

	class InnerClass { // can be private or protected or static
		int y = 5;

		public int myInnerMethod() {
			return x;
		}
	}
}

public class B08_InnerClasses {
	public static void main(String[] args) {
		OuterClass myOuter = new OuterClass();
		OuterClass.InnerClass myInner = myOuter.new InnerClass();
		System.out.println(myInner.y + ", " + myOuter.x);
		System.out.println(myInner.myInnerMethod());
	}
}
