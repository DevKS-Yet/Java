interface AnimalInterface {
	public void animalSound();
	public void sleep();
}

class PigInterface implements AnimalInterface {
	public void animalSound() {
		// the body of animalSound() is provided here
		System.out.println("The pig says: wee wee");
	}
	public void sleep() {
		// the body of sleep() is provided here
		System.out.println("Zzz");
	}
}

class B10_Interface {
	public static void main(String[] args) {
		PigInterface myPig = new PigInterface();
		myPig.animalSound();
		myPig.sleep();
	}
}
