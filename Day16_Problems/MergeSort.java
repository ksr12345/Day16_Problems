import java.util.*;

public class MergeSort {

    public static void mergeSort(List<String> list) {
        if (list == null || list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        List<String> left = new ArrayList<>(list.subList(0, mid));
        List<String> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        merge(list, left, right);
    }

    private static void merge(List<String> list, List<String> left, List<String> right) {
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

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("banana");
        list.add("apple");
        list.add("orange");
        list.add("grapes");
        list.add("kiwi");

        System.out.println("List before sorting:");
        System.out.println(list);

        mergeSort(list);

        System.out.println("\nList after sorting:");
        System.out.println(list);
    }
}
