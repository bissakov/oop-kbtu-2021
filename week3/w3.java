import java.util.Random;

class Animal{
	String name;
	int age;
	String color;
	boolean alive;

	void breath(){
		System.out.println("Breathing ...");
	}
}

public class w3{
	public static void main(String[] args) {
		Animal a1 = new Animal();
		a1.name = "Dog";		

		Animal a2 = new Animal();
		a2.name = "Cat";

		Animal a3 = a2; // a3 = reference(address)

		int x = 3;
		int y = x; // y = 3
		x++;

		System.out.println(a1.name);
		System.out.println(a2.name);
		System.out.println(a3.name);

		a3.name = "Dog";
		System.out.println(a1.name);
		System.out.println(a2.name);
		System.out.println(a3.name);

		java.util.Date d = new java.util.Date();
		System.out.println(d.getTime());

		Random r1 = new Random();
		for(int i=0;i<10;i++){
			System.out.print(r1.nextInt(1000) + " ");
		}

		System.out.println();

		Random r2 = new Random();
		for(int i=0;i<10;i++)
			System.out.print(r2.nextInt(1000) + " ");
	}
}