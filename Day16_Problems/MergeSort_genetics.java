import java.util.*;

public class MergeSort_genetics {
    public static <E extends Comparable<E>> void mergeSort(List<E> list){
        if (list == null || list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        List<E> left = new ArrayList<>(list.subList(0, mid));
        List<E> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static <E extends Comparable<E>> void merge(List<E> list, List<E> left, List<E> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) <= 0) {
                list.set(mergedIndex++, left.get(leftIndex++));
            } else {
                list.set(mergedIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            list.set(mergedIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            list.set(mergedIndex++, right.get(rightIndex++));
        }
    }

    public static <E> void printArray(List<E> list) {
        for (E element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {5, 2, 9, 1, 5, 6};
        List<Integer> intList = Arrays.asList(intArray);
        ArrayList<Integer> intArrayList = new ArrayList<>(intList);

        Double[] doubleArray = {3.2, 1.5, 2.8, 0.9, 3.7};
        List<Double> doubleList = Arrays.asList(doubleArray);
        ArrayList<Double> doubleArrayList = new ArrayList<>(doubleList);

        String[] stringArray = {"banana", "apple", "orange", "grapes", "kiwi"};
        List<String> stringList = Arrays.asList(stringArray);
        ArrayList<String> stringArrayList = new ArrayList<>(stringList);

        System.out.println("Integer Array before sorting:");
        printArray(intArrayList);
        mergeSort(intArrayList);
        System.out.println("Integer Array after sorting:");
        printArray(intArrayList);

        System.out.println("\nDouble Array before sorting:");
        printArray(doubleArrayList);
        mergeSort(doubleArrayList);
        System.out.println("Double Array after sorting:");
        printArray(doubleArrayList);

        System.out.println("\nString Array before sorting:");
        printArray(stringArrayList);
        mergeSort(stringArrayList);
        System.out.println("String Array after sorting:");
        printArray(stringArrayList);
    }
}
