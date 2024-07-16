public class BubbleSort_genetics {
    public static <E extends Comparable<E>> void bubbleSort(E[] arr){
        int n = arr.length;

        for (int i=0; i<n; i++){
            for(int j = 0; j<n-i-1; j++){
                if (arr[j].compareTo(arr[j+1]) < 0) {
                    E temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
        bubbleSort(intArray);
        System.out.println("Integer Array after sorting:");
        printArray(intArray);

        System.out.println("\nDouble Array before sorting:");
        printArray(doubleArray);
        bubbleSort(doubleArray);
        System.out.println("Double Array after sorting:");
        printArray(doubleArray);

        System.out.println("\nString Array before sorting:");
        printArray(stringArray);
        bubbleSort(stringArray);
        System.out.println("String Array after sorting:");
        printArray(stringArray);
    }
}
