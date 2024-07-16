public class InsertionSort_generics {
    public static <E extends Comparable<E>> void insertionSort(E[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            E key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

    }

    public static <E> void printArray(E[] arr) {
        for (E element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 9, 1, 5, 6};
        Double[] doubleArray = {3.2, 1.5, 2.8, 0.9, 3.7};
        String[] stringArray = {"banana", "apple", "orange", "grapes", "kiwi"};

        System.out.println("Integer Array before sorting:");
        printArray(intArray);
        insertionSort(intArray);
        System.out.println("Integer Array after sorting:");
        printArray(intArray);

        System.out.println("\nDouble Array before sorting:");
        printArray(doubleArray);
        insertionSort(doubleArray);
        System.out.println("Double Array after sorting:");
        printArray(doubleArray);

        System.out.println("\nString Array before sorting:");
        printArray(stringArray);
        insertionSort(stringArray);
        System.out.println("String Array after sorting:");
        printArray(stringArray);
    }

}
