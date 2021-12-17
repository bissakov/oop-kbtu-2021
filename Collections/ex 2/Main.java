import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Person> queue = new PriorityQueue<>(new AgeComparator());

        queue.add(new Person("A", 18));
        queue.add(new Person("B", 78));
        queue.add(new Person("C", 98));
        queue.add(new Person("D", 48));
        queue.add(new Person("E", 28));

        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getInfo());
        }
    }
}

class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getInfo() {
        return name + " " + Integer.toString(age);
    }
}

class AgeComparator implements Comparator<Person> {
    // negative x < y, zero x==y, positive x > y
    public int compare(Person p1, Person p2) {
        if (p1.age == p2.age) {
            return p1.name.compareTo(p2.name);
        }

        return p2.age - p1.age;
    }
}
  