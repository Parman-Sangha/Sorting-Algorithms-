package exercise2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Integer[] nums = sortedArray(100, 10);
        displayArray(nums);

        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter target: ");
			int target = scanner.nextInt();
			int result = binarySearch(nums, target);
			System.out.println(result != -1 ? "Found at index: " + result : "Not found");
		}
    }

    private static Integer[] sortedArray(int size, int upperBound) {
        Integer[] nums = new Integer[size];
        nums[0] = (int) (Math.random() * upperBound);
        for (int i = 1; i < size; i++) {
            nums[i] = nums[i - 1] + (int) (Math.random() * upperBound);
        }
        return nums;
    }

    private static int binarySearch(Integer[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private static void displayArray(Integer[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}