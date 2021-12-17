public class Main {
    static void print() {
        System.out.println(Operator.initialValue);
    }
    public static void main(String[] args) {
        Clear clear = new Clear();
        Add add = new Add();
        Subtract subtract = new Subtract();
        Multiply multiply = new Multiply();
        Divide divide = new Divide();

        clear.execute(); //0
        print();

        add.execute(5); // 5
        print();

        subtract.execute(1); // 4
        print();

        multiply.execute(4); // 16
        print();

        divide.execute(2); // 8
        print();
    }
}

abstract class Operator {
    public static int initialValue;

    public Operator() {}

    public abstract void execute(int anotherValue);

    //overload
    public void execute() {}
}

class Add extends Operator {
    @Override
    public void execute(int anotherValue) {
        initialValue += anotherValue;
    }
}

class Subtract extends Operator {
    @Override
    public void execute(int anotherValue) {
        initialValue -= anotherValue;
    }
}

class Multiply extends Operator {
    @Override
    public void execute(int anotherValue) {
        initialValue *= anotherValue;
    }
}

class Divide extends Operator {
    @Override
    public void execute(int anotherValue) {
        initialValue /= anotherValue;
    }
}

class Clear extends Operator {
    @Override
    public void execute() {
        initialValue = 0;
    }
    @Override
    public void execute(int anotherValue) {}
}