public class Main {
	public static void main(String[] args) {
        Integer[] list1 = {12, 20, 1, 7, 11, 18, 9, 14, 5, 10};
        Float[] list2 = {17.0f, 13.0f, 8.0f, 19.0f, 6.0f, 11.0f, 3.0f, 9.0f, 12.0f, 7.0f};
        Double[] list3 = {72.0, 1.0, 95.0, 99.0, 10.0, 23.0, 47.0, 29.0, 11.0, 76.0};
        String[] list4 = {"Volvo", "BMW", "Ford", "Mazda"};


        execute(list1);
        execute(list2);
        execute(list3);
        execute(list4);
    }

    static <E extends Comparable<E>> void selectionSort(E[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minI = i;
    
            for (int j = i + 1; j < list.length; j++) {
                if (list[minI].compareTo((list[j])) > 0) {
                    minI = j;
                }
            }

            E temp = list[minI];
            list[minI] = list[i];
            list[i] = temp;
        }
    }

    static <E> void print(E[] list) {
        for (E el : list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    static <E extends Comparable<E>> void execute(E[] list) {
        System.out.print("Original list: ");
        print(list);
        selectionSort(list);
        System.out.print("Sorted list: ");
        print(list);
        System.out.println();
    }
}