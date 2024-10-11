package exercise3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Integer[] array = randomArray(10, 100);
        System.out.println("Before sorting: " + Arrays.toString(array));

        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Choose sorting algorithm (b, i, s, q): ");
			char choice = scanner.next().charAt(0);

			switch (choice) {
			    case 'b': bubbleSort(array); break;
			    case 'i': insertionSort(array); break;
			    case 's': selectionSort(array); break;
			    case 'q': quickSort(array, 0, array.length - 1); break;
			    default: System.out.println("Invalid input");
			}
		}
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static Integer[] randomArray(int size, int bound) {
        Integer[] arr = new Integer[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(bound);
        return arr;
    }

    private static void bubbleSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    private static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}