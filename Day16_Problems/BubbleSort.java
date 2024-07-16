public class BubbleSort {
    public static void bubblesort(int[] arr){

        int n = arr.length;

        for (int i=0; i<n; i++){
            for(int j = 0; j<n-i-1; j++){
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 6, 8, 7};

        System.out.println("Array before Sorting:");
        printArray(a);

        bubblesort(a);

        System.out.println("Array after Sorting:");
        printArray(a);
    }
}

