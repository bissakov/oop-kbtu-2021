public class Main {

    static int l, r;

	public static void main(String[] args) {
        Integer[] list1 = {5, 8, 21, 22, 28, 38, 52, 62, 67, 100};
        Float[] list2 = {21.0f, 23.0f, 35.0f, 42.0f, 55.0f, 57.0f, 62.0f, 63.0f, 70.0f, 79.0f};
        Double[] list3 = {3.0, 15.0, 18.0, 21.0, 38.0, 60.0, 69.0, 84.0, 96.0, 98.0};
        String[] list4 = {"BMW", "Ford", "Mazda", "Volvo"};

        execute(list1, Integer.valueOf(22));
        execute(list2, Float.valueOf(62.0f));
        execute(list3, Double.valueOf(38.0));
        execute(list4, String.valueOf("Ford"));
        execute(list1, Integer.valueOf(101));
    }

    static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        l = 0;
        r = list.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (list[m].compareTo(key) == 0){
                return m;
            }

            if (list[m].compareTo(key) < 0) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return -1;
    }

    static <E extends Comparable<E>> void execute(E[] list, E key) {
        int res = binarySearch(list, key);

        if (res == -1) {
            System.out.println("No such element in the list.");
        }
        else {
            System.out.println(res);
        }        
    }
}