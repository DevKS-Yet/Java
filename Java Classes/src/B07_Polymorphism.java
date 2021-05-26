class Animal {
	public void animalSound() {
		System.out.println("The animal makes a sound");
	}
}

class Pig extends Animal {
	public void animalSound() {
		System.out.println("The pig says: wee wee");
	}
}

class Dog extends Animal {
	public void animalSound() {
		System.out.println("The dog says: bow wow");
	}
}

public class B07_Polymorphism {
	public static void main(String[] args) {
		Animal myAnimal = new Animal(); // create parent class object
		Animal myPig = new Pig(); // create child class through parent class object variable
		Animal myDog = new Dog();
		myAnimal.animalSound();
		myPig.animalSound();
		myDog.animalSound();
	}
}

// It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.
