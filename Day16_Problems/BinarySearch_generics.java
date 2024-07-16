public class BinarySearch_generics {
    public static <E extends Comparable<E>> int binarySearch(E[] arr, E key) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cmp = key.compareTo(arr[mid]);
            if (cmp == 0) {
                return mid;
            }

            else if (cmp > 0) {
                left = mid + 1;
            }


            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        Integer key = 23;

        int index = binarySearch(arr, key);

        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        } else {
            System.out.println("Element " + key + " not found in the array");
        }
    }
}
