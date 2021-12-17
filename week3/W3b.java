public class W3b{
	public static void main(String[] args) {
		House h1 = new House(50, "White");
		House h2 = new House(120, "Brown");
		House h3 = new House(90, "Black");
		House h4 = new House(40, "Orange");

		String col1 = h1.getHouseCol(), col2 = h2.getHouseCol();
		String col3 = h3.getHouseCol(), col4 = h4.getHouseCol();

		int cnt = House.getTotalNumberOfHouses();
		System.out.println("Total num of houses: " + cnt);

		System.out.println();

		h1.showStreetName();
		System.out.println("The color of the house is: " + col1 + "\n");

		h2.showStreetName();
		System.out.println("The color of the house is: " + col2 + "\n");

		h3.showStreetName();
		System.out.println("The color of the house is: " + col3 + "\n");

		h4.showStreetName();
		System.out.println("The color of the house is: " + col4 + "\n");
	}
}

class House{
	int numOfFloors;
	int area;
	String color;
	static String streetName;
	int addressNum; // // TASK-1: Add at least one more instance data field;
	private static int counter = 0;

	House(int a, String c){
		area = a;
		color = c;
		counter++;
		streetName = "Abylai Khan ";
		addressNum = counter;
	}

	void showArea(){
		System.out.println(area);
	}

	// TASK-4: Generate Addresses (Street numbers) automatically (Ex: Abylai khan 1, Abylai khan 2, etc.).
	void showStreetName(){
		System.out.println(streetName + addressNum);
	}	

	// TASK-2: Add at least one more instance method;
	String getHouseCol(){
		return color;
	}

	// TASK-3: Create a method showTotalNumberOfHouses();
	static int getTotalNumberOfHouses(){
		return counter;
	}	
}

